# Back-end for Connect Four clone game using Spring / Java

Two players can start a game and play it using REST calls. No authentication is performed.

## Usage

Start the server.

```bash
$ mvn spring-boot:run
```

Make HTTP requests to start a game.

```bash
$ curl http://localhost:8080/connectfour -X POST && echo
```
```json
{"id":1,"nextPlayer":1,"winner":0,"board":[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]]}
```

Place a piece on the board (columns start at zero).

```bash
$ curl http://localhost:8080/connectfour/1 -X POST -d "player=1&column=0" && echo
```
```json
{"id":1,"nextPlayer":2,"winner":0,"board":[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[1,0,0,0,0,0,0]]}
```

Obtain the current state of a game.

```bash
$ curl http://localhost:8080/connectfour/1 && echo
```
```json
{"id":1,"nextPlayer":2,"winner":0,"board":[[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[1,0,0,0,0,0,0]]}
```

### Requirements

- Java 17
- Spring Boot 3.1.2