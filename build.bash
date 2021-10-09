#!/bin/bash

docker run \
       --rm -it \
       -v $(pwd):/src \
       -v $HOME/.m2-docker:/root/.m2 \
       --workdir /src \
       library/maven:3-openjdk-17 \
       mvn package
