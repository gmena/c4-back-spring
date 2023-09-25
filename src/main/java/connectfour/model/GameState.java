package connectfour.model;

public record GameState(
        long id,
        int nextPlayer,
        int winner,
        int[][] board)
{ }
