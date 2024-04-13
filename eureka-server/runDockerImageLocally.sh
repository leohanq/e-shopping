#!/bin/bash
echo "#====================================================================#"
echo "# Running the Eureka Service using a docker-compose file #"
echo "# You can check the file src/main/docker/docker-compose.yml          #"
echo "#====================================================================#"

docker-compose -f src/main/docker/docker-compose.yml up -d

echo "The service Eureka discovery is running..."