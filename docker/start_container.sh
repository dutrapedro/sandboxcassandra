#!/bin/bash


docker stop hotel_app_database
docker rm hotel_app_database
docker build -t hotel_app_database .
docker run --name hotel_app_database -p 9042:9042 -d hotel_app_database

while true
do
  if grep -qi "Startup complete" <(docker logs hotel_app_database 2>&1); then
    docker exec hotel_app_database cqlsh -f setup_keyspace.cql;
    echo "***Server ready to connect***";
    break;
  else
    echo "Server not ready yet!";
  fi

  sleep 2
done