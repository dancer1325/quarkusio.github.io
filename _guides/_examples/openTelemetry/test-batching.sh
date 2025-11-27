#!/bin/bash
echo "Generate 10 requests..."
for i in {1..10}; do 
  curl -s http://localhost:8080/hello > /dev/null
  echo "Request $i sent"
done
echo "Check the logs to see the batching"
