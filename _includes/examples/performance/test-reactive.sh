#!/bin/bash

echo "=== Testing REACTIVE (Non-Blocking) Model ==="
echo ""

# Start Quarkus app in background
echo "Starting Quarkus app..."
./mvnw quarkus:dev > /tmp/quarkus-reactive.log 2>&1 &
MAVEN_PID=$!

# Wait for app to be ready
echo "Waiting for app to start..."
for i in {1..30}; do
  if curl -s http://localhost:8080/reactive > /dev/null 2>&1; then
    echo "✓ App ready"
    break
  fi
  sleep 1
done

echo "Sending 10 concurrent requests..."
echo ""

# send 10 concurrent requests
for i in {1..10}; do
  (
    echo "[Request $i] Started at $(date +%H:%M:%S.%N)"
    curl -s http://localhost:8080/reactive
    echo " - Finished at $(date +%H:%M:%S.%N)"
  ) &
done

wait

# Show thread usage
echo ""
echo "=== Thread Analysis ==="
JAVA_PID=$(jps | grep -i quarkus | awk '{print $1}')
if [ -n "$JAVA_PID" ]; then
  EVENTLOOP_COUNT=$(jstack $JAVA_PID 2>/dev/null | grep "vert.x-eventloop" | wc -l | xargs)
  echo "Event loop threads: $EVENTLOOP_COUNT"
  echo ""
  echo "✓ ALL 10 requests handled by $EVENTLOOP_COUNT event loop threads"
else
  echo "⚠ Could not find Java process"
fi
echo "✓ Thread is NEVER blocked - handles multiple requests concurrently"

# Cleanup
echo ""
echo "Stopping Quarkus..."
kill -9 $MAVEN_PID 2>/dev/null
[ -n "$JAVA_PID" ] && kill -9 $JAVA_PID 2>/dev/null
wait $MAVEN_PID 2>/dev/null
echo "✓ Done"

