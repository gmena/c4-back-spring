package connectfour;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConnectFourControllerTests {

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
        assertTrue(ConnectFourController.isWinnerHorizontal(board, 1, 5, 1));
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
		assertFalse(ConnectFourController.isWinnerHorizontal(board, 1, 5, 1));
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
		assertTrue(ConnectFourController.isWinnerVertical(board, 1, 2, 2));
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
		assertFalse(ConnectFourController.isWinnerVertical(board, 1, 3, 2));
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
		assertTrue(ConnectFourController.isWinnerDiagonal(board, 1, 2, 3));
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
		assertFalse(ConnectFourController.isWinnerDiagonal(board, 1, 3, 2));
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
		assertTrue(ConnectFourController.isWinnerReverseDiagonal(board, 1, 2, 3));
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
		assertFalse(ConnectFourController.isWinnerReverseDiagonal(board, 1, 3, 2));
	}

}
