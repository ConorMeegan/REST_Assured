#!/usr/bin/env bash
# my project clean script
cd core
mvn clean
cd ../broadcaster
mvn clean
cd ../soccer
mvn clean
cd ../nba
mvn clean
cd ../client
mvn clean
cd ..
#docker-compose up
