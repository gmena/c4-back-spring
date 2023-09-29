package connectfour.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentMap;

import connectfour.model.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectFourController {

    private static final int WIN = 4;
    private static final int ROWS = 6;
    private static final int COLS = 7;

    private static final Logger logger = LoggerFactory.getLogger(ConnectFourController.class);

    private final AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, GameState> ongoingGames = new ConcurrentHashMap<>();

    @PostMapping("/connectfour")
    public GameState createGame() {
        long id = counter.incrementAndGet();
        int nextPlayer = 1;
        int winner = 0;
        int[][] board = BoardHandler.createBoard(ROWS, COLS); // initialized with 0
        GameState gameState = new GameState(id, nextPlayer, winner, board);

        ongoingGames.put(id, gameState);

        return gameState;
    }

    @GetMapping("/connectfour/{id}")
    public GameState getGame(@PathVariable long id) {
        return ongoingGames.get(id);
    }

    @PostMapping("/connectfour/{id}")
    public GameState putPiece(@PathVariable long id, @RequestParam int player, @RequestParam int column) {
        GameState gameState = ongoingGames.get(id);
        int[][] board = gameState.board();

        Integer row = BoardHandler.putPiece(board, player, column);
        boolean foundEmpty = row != null;

        int nextPlayer = (player == 1) ? 2 : 1;
        int winner = gameState.winner();
        if (foundEmpty && BoardHandler.isWinner(WIN, board, player, row, column)) {
            winner = player;
        }

        GameState newGameState = new GameState(id, nextPlayer, winner, board);
        ongoingGames.put(id, newGameState);

        return newGameState;
    }
}