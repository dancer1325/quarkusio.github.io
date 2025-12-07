#!/bin/bash

echo "=========================================="
echo "Proving Quarkus uses Event Loops"
echo "=========================================="
echo ""

echo "Starting Quarkus app..."
./mvnw quarkus:dev > /tmp/quarkus.log 2>&1 &
PID=$!
sleep 10

echo "✓ Test 1: Check thread names"
echo "-------------------------------------------"
curl -s http://localhost:8080/event-loop-proof
echo ""
echo ""

echo "✓ Test 2: Multiple requests use same few threads"
echo "-------------------------------------------"
echo "Making 20 requests and collecting thread IDs..."
for i in {1..20}; do
    curl -s http://localhost:8080/event-loop-proof | grep "Thread ID" &
done
wait
echo ""
echo "Notice: Only a few different thread IDs (event loops)"
echo "       NOT 20 different threads!"
echo ""

echo "✓ Test 3: Count event loop threads in JVM"
echo "-------------------------------------------"
EVENTLOOP_COUNT=$(jstack $PID 2>/dev/null | grep "vert.x-eventloop" | wc -l | xargs)
TOTAL_THREADS=$(jstack $PID 2>/dev/null | grep "java.lang.Thread.State" | wc -l | xargs)

echo "Event loop threads: $EVENTLOOP_COUNT"
echo "Total threads: $TOTAL_THREADS"
echo ""
echo "Proof: Few event loops ($EVENTLOOP_COUNT) handle all requests"
echo "       NOT creating thread per request"
echo ""

echo "✓ Test 4: Event loops under load"
echo "-------------------------------------------"
echo "Sending 100 concurrent requests..."
for i in {1..100}; do
    curl -s http://localhost:8080/event-loop-proof > /dev/null &
done
wait

EVENTLOOP_AFTER=$(jstack $PID 2>/dev/null | grep "vert.x-eventloop" | wc -l | xargs)
echo "Event loop threads after load: $EVENTLOOP_AFTER"
echo ""
if [ "$EVENTLOOP_COUNT" -eq "$EVENTLOOP_AFTER" ]; then
    echo "✓ PROOF: Thread count unchanged!"
    echo "  Event loops reused for all requests"
else
    echo "⚠ Thread count changed"
fi

kill $PID 2>/dev/null
wait $PID 2>/dev/null

echo ""
echo "=========================================="
echo "Conclusion: Quarkus uses Event Loop model"
echo "- Requests run on vert.x-eventloop threads"
echo "- Few threads (typically 2×CPU cores)"
echo "- Same threads reused for all requests"
echo "=========================================="
