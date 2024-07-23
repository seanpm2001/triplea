# Headless Game Server

A headless game server for TripleA, also known as a _bot_.

## Run

Example command to run a new headless game server from Gradle:

```
$ ./gradlew :game-headless:run --args=' \
    -Ptriplea.lobby.game.comments=automated_host \
    -Ptriplea.lobby.host=127.0.0.1 \
    -Ptriplea.lobby.port=3304 \
    -Ptriplea.map.folder=/home/me/triplea/downloadedMaps \
    -Ptriplea.name=Bot1_TestServer \
    -Ptriplea.port=3300 \
    -Ptriplea.server=true \
    '
```


## Running bot with docker
```
cd work/triplea/triplea/game-app/game-headless/
../../gradlew clean shadowJar
docker build . -t bot
docker run bot
```


### Docker Lobby + Docker Bot

```
cd work/triplea/lobby-server
# starts up the lobby
docker compose-up

# new terminal, note the port number of the lobby
docker container ls

cd work/triplea/triplea/game-app/game-headless/

# update clean-run-docker.sh with port number, and run:
./clean-run-docker.sh
```




