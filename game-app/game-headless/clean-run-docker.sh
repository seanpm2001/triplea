#!/bin/bash

set -eux
../../gradlew clean shadowJar
docker build . -t bot
docker run \
   --network host \
   --env LOBBY_URI=http://localhost:32768 \
   -v /home/$USER/triplea/downloadedMaps:/downloadedMaps \
   bot

