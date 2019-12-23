#!/usr/bin/env bash
# my project build script
cd core
mvn clean compile install package
cd ../broadcaster
mvn clean compile install package
docker build -t broadcaster:latest .
cd ../soccer
mvn clean compile install package
docker build -t soccer:latest .
cd ../nba
mvn clean compile install package
docker build -t nba:latest .
cd ../client
mvn clean compile install package
cd ..
docker-compose up
