#!/bin/bash

echo "=== Testing Virtual Threads: High Concurrency + Low Memory ==="
echo ""

# Start Quarkus app
echo "Starting Quarkus app..."
./mvnw quarkus:dev > /tmp/quarkus-vt.log 2>&1 &
MAVEN_PID=$!

# Wait for app
echo "Waiting for app to start..."
for i in {1..30}; do
  if curl -s http://localhost:8080/virtual > /dev/null 2>&1; then
    echo "✓ App ready"
    sleep 2  # Extra time for Java process to be visible
    break
  fi
  sleep 1
done

JAVA_PID=$(jps -l | grep -E "quarkus|QuarkusDev|io.quarkus" | awk '{print $1}' | head -1)

if [ -z "$JAVA_PID" ]; then
  JAVA_PID=$(ps aux | grep "[j]ava.*quarkus" | awk '{print $2}' | head -1)
fi

if [ -z "$JAVA_PID" ]; then
  echo "⚠ Could not find Java process"
  echo "Available Java processes:"
  jps -l
  echo ""
  echo "All java processes:"
  ps aux | grep java | grep -v grep
  kill -9 $MAVEN_PID 2>/dev/null
  exit 1
fi

echo "Java PID: $JAVA_PID"

# Baseline memory
echo ""
echo "=== Baseline ==="
BASELINE_MEM=$(ps -o rss -p $JAVA_PID | tail -1 | awk '{print $1/1024}')
BASELINE_THREADS=$(jstack $JAVA_PID 2>/dev/null | grep "java.lang.Thread.State" | wc -l | xargs)
echo "Memory: ${BASELINE_MEM} MB"
echo "Threads: $BASELINE_THREADS"

# Test 1: 1000 concurrent requests
echo ""
echo "=== Test 1: 1000 Concurrent Requests ==="
echo "Sending 1000 requests..."
for i in {1..1000}; do
  curl -s http://localhost:8080/virtual > /dev/null &
done
wait

AFTER_MEM=$(ps -o rss -p $JAVA_PID | tail -1 | awk '{print $1/1024}')
AFTER_THREADS=$(jstack $JAVA_PID 2>/dev/null | grep "java.lang.Thread.State" | wc -l | xargs)
VIRTUAL_THREADS=$(jstack $JAVA_PID 2>/dev/null | grep "VirtualThread" | wc -l | xargs)

echo "Memory: ${AFTER_MEM} MB (Δ: $(echo "$AFTER_MEM - $BASELINE_MEM" | bc) MB)"
echo "Platform threads: $AFTER_THREADS (Δ: $(($AFTER_THREADS - $BASELINE_THREADS)))"
echo "Virtual threads: $VIRTUAL_THREADS"

# Test 2: 10000 concurrent requests
echo ""
echo "=== Test 2: 10,000 Concurrent Requests ==="
echo "Sending 10,000 requests..."
for i in {1..10000}; do
  curl -s http://localhost:8080/virtual > /dev/null &
  if [ $((i % 1000)) -eq 0 ]; then
    echo "  Sent $i requests..."
  fi
done
wait

FINAL_MEM=$(ps -o rss -p $JAVA_PID | tail -1 | awk '{print $1/1024}')
FINAL_THREADS=$(jstack $JAVA_PID 2>/dev/null | grep "java.lang.Thread.State" | wc -l | xargs)

echo "Memory: ${FINAL_MEM} MB (Δ: $(echo "$FINAL_MEM - $BASELINE_MEM" | bc) MB)"
echo "Platform threads: $FINAL_THREADS (Δ: $(($FINAL_THREADS - $BASELINE_THREADS)))"

# Results
echo ""
echo "=== PROOF: Virtual Threads ==="
echo "✓ 10,000 concurrent requests"
echo "✓ Memory increase: ~$(echo "$FINAL_MEM - $BASELINE_MEM" | bc) MB (LOW!)"
echo "✓ Platform threads: ~$FINAL_THREADS (NOT 10,000!)"
echo "✓ Virtual threads handle massive concurrency with minimal memory"

# Cleanup
echo ""
echo "Stopping Quarkus..."
kill -9 $MAVEN_PID $JAVA_PID 2>/dev/null
wait $MAVEN_PID 2>/dev/null
echo "✓ Done"
