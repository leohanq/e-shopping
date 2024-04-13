#!/bin/bash
echo "Compiling"
mvn clean package
echo "Building Docker Image with latest code"
cp ./target/*.jar ./src/main/docker/
docker build ./src/main/docker -t eureka:latest
rm -rf ./src/main/docker/*.jar
echo "The Docker image was build successfully"