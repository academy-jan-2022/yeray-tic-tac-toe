package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TicTacToeGameShould {
	@Test void
	mark_the_first_move_in_top_left_corner_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 0));
		assertEquals(
				"""
						X|_|_
						_|_|_
						_|_|_""",
				result
		);
	}

	@Test void
	mark_the_first_move_in_center_left_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 1));
		assertEquals(
				"""
						_|_|_
						X|_|_
						_|_|_""",
				result
		);
	}

	@Test void
	mark_the_first_move_in_center_top_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(1, 0));
		assertEquals(
				"""
						_|X|_
						_|_|_
						_|_|_""",
				result
		);
	}

	@Test void
	mark_the_first_move_in_right_top_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(2, 0));
		assertEquals(
				"""
						_|_|X
						_|_|_
						_|_|_""",
				result
		);
	}

	@Test void
	mark_the_first_move_in_bottom_right_cell_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(new Point(0, 2));
		assertEquals(
				"""
						_|_|_
						_|_|_
						X|_|_""",
				result
		);
	}

	@Test void
	mark_the_second_move_in_another_line_with_an_O() {
		var game = new TicTacToeGame();
		game.play(new Point(0, 2));
		var result = game.play(new Point(1, 1));
		assertEquals(
				"""
						_|_|_
						_|O|_
						X|_|_""",
				result
		);
	}

	@Test void
	skip_marking_already_marked_point() {
		var game = new TicTacToeGame();
		game.play(new Point(0, 2));
		game.play(new Point(0, 2));
		var result = game.play(new Point(1, 1));
		assertEquals(
				"""
						_|_|_
						_|O|_
						X|_|_""",
				result
		);
	}

	@Test void
	mark_the_second_move_in_the_center_with_an_O() {
		var game = new TicTacToeGame();
		game.play(new Point(2, 1));
		var result = game.play(new Point(1, 1));
		assertEquals(
				"""
						_|_|_
						_|O|X
						_|_|_""",
				result
		);
	}

	@Test void
	mark_the_third_move_in_the_center_left_with_an_X() {
		var game = new TicTacToeGame();
		game.play(new Point(2, 1));
		game.play(new Point(1, 1));
		var result = game.play(new Point(0, 1));
		assertEquals(
				"""
						_|_|_
						X|O|X
						_|_|_""",
				result
		);
	}

	@Test void
	X_wins_in_horizontal_line_so_stops_drawing() {
		var game = new TicTacToeGame();
		game.play(new Point(2, 1));
		game.play(new Point(0, 0));
		game.play(new Point(1, 1));
		game.play(new Point(1, 0));
		game.play(new Point(0, 1));
		var result = game.play(new Point(2, 0));
		assertEquals(
				"""
						O|O|_
						X|X|X
						_|_|_""",
				result
		);
	}

	@Test void
	O_wins_in_horizontal_line_so_stops_drawing() {
		var game = new TicTacToeGame();
		game.play(new Point(2, 1));
		game.play(new Point(0, 0));
		game.play(new Point(1, 1));
		game.play(new Point(1, 0));
		game.play(new Point(0, 2));
		game.play(new Point(2, 0));
		var result = game.play(new Point(2, 2));
		assertEquals(
				"""
						O|O|O
						_|X|X
						X|_|_""",
				result
		);
	}

	@Test void
	X_wins_in_diagonal_line_so_stops_drawing() {
		var game = new TicTacToeGame();

		game.play(new Point(0, 0));
		game.play(new Point(1, 0));
		game.play(new Point(1, 1));
		game.play(new Point(1, 2));
		game.play(new Point(2, 2));
		var result = game.play(new Point(2, 0));
		assertEquals(
				"""
						X|O|_
						_|X|_
						_|O|X""",
				result
		);
	}

	@Test void
	O_wins_in_diagonal_line_so_stops_drawing() {
		var game = new TicTacToeGame();
		game.play(new Point(0, 2));
		game.play(new Point(0, 0));
		game.play(new Point(1, 0));
		game.play(new Point(1, 1));
		game.play(new Point(1, 2));
		game.play(new Point(2, 2));
		var result = game.play(new Point(2, 0));
		assertEquals(
				"""
						O|X|_
						_|O|_
						X|X|O""",
				result
		);
	}

	@Test void
	fills_the_whole_board() {
		var game = new TicTacToeGame();
		game.play(new Point(0,0));
		game.play(new Point(1,0));
		game.play(new Point(0,1));
		game.play(new Point(0,2));
		game.play(new Point(1,2));
		game.play(new Point(1,1));
		game.play(new Point(2,0));
		game.play(new Point(2,2));
		String result = game.play(new Point(2, 1));
		assertEquals(
				"""
						X|O|X
						X|O|X
						O|X|O""",
				result
		);
	}
}
