#!/bin/bash
echo "#====================================================================#"
echo "# Running the User Service using a docker-compose file #"
echo "# You can check the file src/main/docker/docker-compose.yml          #"
echo "#====================================================================#"

docker-compose -f src/main/docker/docker-compose.yml up -d

echo "The service User discovery is running..."