#!/bin/bash

echo "=== Testing IMPERATIVE (Blocking) Model ==="
echo "Sending 3 concurrent requests..."
echo ""

# Send 3 concurrent requestS
for i in {1..3}; do
  (
    echo "[Request $i] Started at $(date +%H:%M:%S.%N)"
    curl -s http://localhost:8080/imperative
    echo " - [Request $i] Finished at $(date +%H:%M:%S.%N)"
  ) &
done

wait
echo ""
echo "✓ Check server logs: Each request BLOCKS its thread for 2s"
echo "✓ Expected: 3 different executor-thread-X (one per request)"
