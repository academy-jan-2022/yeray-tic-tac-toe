package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TicTacToeGameShould {
	@Test void
	mark_the_first_move_in_top_left_corner_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 0));
		assertEquals(
				"X|_|_\n" +
						"_|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_center_left_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 1));
		assertEquals(
				"_|_|_\n" +
						"X|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_center_top_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(1, 0));
		assertEquals(
				"_|X|_\n" +
						"_|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_right_top_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(2, 0));
		assertEquals(
				"_|_|X\n" +
						"_|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_bottom_right_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 2));
		assertEquals(
				"_|_|_\n" +
						"_|_|_\n" +
						"X|_|_",
				result
		);
	}

	@Test void
	mark_the_second_move_in_the_center_with_an_O() {
		var game = new TicTacToeGame();
		game.play(new Point(2, 1));
		var result = game.play(new Point(1, 1));
		assertEquals(
				"_|_|_\n" +
						"_|O|X\n" +
						"_|_|_",
				result
		);
	}
}
