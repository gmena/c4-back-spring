package connectfour.controller;

import connectfour.model.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BoardHandler {

    public static int[][] createBoard(int rowCount, int colCount) {
        return new int[rowCount][colCount]; // initialized with 0
    }

    public static Integer putPiece(int[][] board, int player, int column) {
        for (int row = board.length - 1; row >= 0; --row) {
            if (board[row][column] == 0) {
                board[row][column] = player;
                return row;
            }
        }

        return null;
    }

    static boolean isWinner(int winCount, int[][] board, int player, int row, int column) {
        return isWinnerHorizontal(winCount,board, player, row, column)
                || isWinnerVertical(winCount,board, player, row, column)
                || isWinnerDiagonal(winCount,board, player, row, column)
                || isWinnerReverseDiagonal(winCount, board, player, row, column);
    }

    static boolean isWinnerHorizontal(int winCount, int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(winCount,0, 1, board, player, row, column);
    }

    static boolean isWinnerVertical(int winCount, int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(winCount, 1, 0, board, player, row, column);
    }

    static boolean isWinnerDiagonal(int winCount, int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(winCount,-1, 1, board, player, row, column);
    }

    static boolean isWinnerReverseDiagonal(int winCount, int[][] board, int player, int row, int column) {
        return isWinnerByDeltas(winCount,1, 1, board, player, row, column);
    }

    private static boolean isWinnerByDeltas(int winCount, int deltaY, int deltaX, int[][] board, int player, int row, int col) {
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
                if (n == winCount) {
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