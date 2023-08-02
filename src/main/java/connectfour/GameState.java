package connectfour;

public record GameState(
        long id,
        int nextPlayer,
        int winner,
        int[][] board)
{ }
