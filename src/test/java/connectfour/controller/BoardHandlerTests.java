package connectfour.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardHandlerTests {

	private static final int WIN = 4;

	@Test
	void isWinnerHorizontal_true() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{1, 0, 1, 1, 1, 1, 0},
		};
        assertTrue(BoardHandler.isWinnerHorizontal(WIN, board, 1, 5, 1));
	}

	@Test
	void isWinnerHorizontal_false() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{1, 0, 1, 1, 1, 0, 0},
		};
		assertFalse(BoardHandler.isWinnerHorizontal(WIN, board, 1, 5, 1));
	}

	@Test
	void isWinnerVertical_true() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
		};
		assertTrue(BoardHandler.isWinnerVertical(WIN, board, 1, 2, 2));
	}

	@Test
	void isWinnerVertical_false() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
		};
		assertFalse(BoardHandler.isWinnerVertical(WIN, board, 1, 3, 2));
	}

	@Test
	void isWinnerDiagonal_true() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0},
		};
		assertTrue(BoardHandler.isWinnerDiagonal(WIN, board, 1, 2, 3));
	}

	@Test
	void isWinnerDiagonal_false() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 0},
				{1, 0, 0, 0, 0, 0, 0},
		};
		assertFalse(BoardHandler.isWinnerDiagonal(WIN, board, 1, 3, 2));
	}

	@Test
	void isWinnerReverseDiagonal_true() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 0, 0, 1},
		};
		assertTrue(BoardHandler.isWinnerReverseDiagonal(WIN, board, 1, 2, 3));
	}

	@Test
	void isWinnerReverseDiagonal_false() {
		int[][] board = {
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0},
		};
		assertFalse(BoardHandler.isWinnerReverseDiagonal(WIN, board, 1, 3, 2));
	}

}
