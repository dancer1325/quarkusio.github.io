#!/bin/bash

echo "=== Testing REACTIVE (Non-Blocking) Model ==="
echo "Sending 10 concurrent requests..."
echo ""

# Enviar 10 requests concurrentes
for i in {1..10}; do
  (
    echo "[Request $i] Started at $(date +%H:%M:%S.%N)"
    curl -s http://localhost:8080/reactive
    echo " - Finished at $(date +%H:%M:%S.%N)"
  ) &
done

wait
echo ""
echo "✓ Check server logs: ALL requests use SAME event loop thread"
echo "✓ Expected: Only 1-2 vert.x-eventloop-thread-X handling 10 requests"
echo "✓ Thread is NEVER blocked - handles multiple requests concurrently"
