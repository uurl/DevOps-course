#!/usr/bin/env bash

export PG_CONTAINER_NAME=pg_talk_database

docker inspect -f '{{.State.Running}}' $PG_CONTAINER_NAME > /dev/null 2>&1

if [[ $? -eq 0 ]];
then
     echo "PostgreSQL is running"
else
     docker run --rm --name $PG_CONTAINER_NAME -p 5432:5432 -e POSTGRES_DB=comparison -e POSTGRES_USER=user -e POSTGRES_PASSWORD=secret -d postgres:10-alpine  > /dev/null 2>&1
     echo "Started PostgreSQL container"
fi