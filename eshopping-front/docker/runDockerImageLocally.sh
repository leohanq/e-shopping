#!/bin/bash
echo "#====================================================================#"
echo "# Running the Angular Service using a docker-compose file #"
echo "# You can check the file src/main/docker/docker-compose.yml          #"
echo "#====================================================================#"

docker-compose -f docker-compose.yml up -d

echo "The service Angular is running..."