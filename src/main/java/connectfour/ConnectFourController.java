package connectfour;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentMap;

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
        int[][] board = new int[ROWS][COLS]; // initialized with 0
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

        boolean foundEmpty = false;
        int row = board.length - 1;
        for (; row >= 0; --row) {
            if (board[row][column] == 0) {
                board[row][column] = player;
                foundEmpty = true;
                break;
            }
        }

        int nextPlayer = (player == 1) ? 2 : 1;
        int winner = gameState.winner();
        if (foundEmpty && isWinner(board, player, row, column)) {
            winner = player;
        }

        GameState newGameState = new GameState(id, nextPlayer, winner, board);
        ongoingGames.put(id, newGameState);

        return newGameState;
    }

    boolean isWinner(int[][] board, int player, int row, int column) {
        return isWinnerHorizontal(board, player, row, column)
                || isWinnerVertical(board, player, row, column)
                || isWinnerDiagonal(board, player, row, column)
                || isWinnerReverseDiagonal(board, player, row, column);
    }

    static boolean isWinnerHorizontal(int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(0, 1, board, player, row, column);
    }

    static boolean isWinnerVertical(int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(1, 0, board, player, row, column);
    }

    static boolean isWinnerDiagonal(int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(-1, 1, board, player, row, column);
    }

    static boolean isWinnerReverseDiagonal(int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(1, 1, board, player, row, column);
    }

    private static boolean isWinnerByDeltas(int deltaY, int deltaX, int[][] board, int player, int row, int col) {
        int height = board.length;
        int width = board[0].length;
        int max = (height > width) ? (height - 1) : (width - 1);

        int n = 0;
        for (int i = -max; i <= max; ++i) {
            int y = row + (i * deltaY);
            int x = col + (i * deltaX);
            if ((y < 0) || (y >= height) || (x < 0) || (x >= width)) {
                continue;
            }

            if (board[y][x] == player) {
                ++n;
                if (n == WIN) {
                    return true;
                }
            }
            else {
                n = 0;
            }
        }

        return false;
    }

}