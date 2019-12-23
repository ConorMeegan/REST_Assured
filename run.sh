#!/usr/bin/env bash
cd client
export JAVA_PROGRAM_ARGS=`docker-machine ip`
mvn exec:java -Dexec.args="$JAVA_PROGRAM_ARGS"