package example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeGameShould {

	TicTacToeGame game;

	@BeforeEach
	void setUp() {
		this.game = new TicTacToeGame();
	}

	@Test void
	mark_the_first_move_in_top_left_corner_with_an_X() {
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
		var result = game.play(new Point(2, 0));
		assertEquals(
				"_|_|X\n" +
						"_|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_bottom_left_cell_with_an_X() {
		var result = game.play(new Point(0, 2));
		assertEquals(
				"_|_|_\n" +
						"_|_|_\n" +
						"X|_|_",
				result
		);
	}

	@Test void
	mark_the_first_move_in_middle_left_cell_with_an_X() {
		var result = game.play(new Point(0, 1));
		assertEquals(
				"_|_|_\n" +
						"X|_|_\n" +
						"_|_|_",
				result
		);
	}

	@Test void
	mark_the_second_move_in_bottom_left_cell_with_an_O() {
		game.play(new Point(0, 1));
		var result = game.play(new Point(0, 2));
		assertEquals(
				"_|_|_\n" +
						"X|_|_\n" +
						"O|_|_",
				result
		);
	}

	@Test void
	handle_three_steps() {
		game.play(new Point(0, 1));
		game.play(new Point(0, 2));
		var result = game.play(new Point(1, 2));
		assertEquals(
				  "_|_|_\n" +
							 "X|_|_\n" +
							 "O|X|_",
				  result
		);
	}

	@Test void
	ignore_step_if_cell_is_already_taken() {
		game.play(new Point(0, 1));
		var result = game.play(new Point(0, 1));

		assertEquals("_|_|_\n" +
				"X|_|_\n" +
				"_|_|_",result);
	}

	@Test void
	accept_new_step_for_same_player_if_position_is_already_taken() {
		game.play(new Point(0, 1));
		game.play(new Point(0, 1));
		var result = game.play(new Point(0, 2));

		assertEquals("_|_|_\n" +
				"X|_|_\n" +
				"O|_|_",result);
	}

	@Test void
	return_first_player_wins_if_3_x_in_first_row(){
		game.play(new Point(0, 0)); //x
		game.play(new Point(1, 1)); //o
		game.play(new Point(1, 0)); //x
		game.play(new Point(1, 2)); //o
		var result = game.play(new Point(2, 0)); //x

		assertEquals("Player X wins", result);
	}

	@Test void
	return_first_player_wins_if_3_x_in_first_column(){
		game.play(new Point(0, 0)); //x
		game.play(new Point(1, 1)); //o
		game.play(new Point(0, 1)); //x
		game.play(new Point(1, 2)); //o
		var result = game.play(new Point(0, 2)); //x

		assertEquals("Player X wins", result);
	}

	@Test void
	return_first_player_wins_if_3_x_in_second_column(){
		game.play(new Point(1, 0)); //x
		game.play(new Point(2, 0)); //o
		game.play(new Point(1, 1)); //x
		game.play(new Point(2, 2)); //o
		var result = game.play(new Point(1, 2)); //x

		assertEquals("Player X wins", result);
	}

	@Test void
	return_first_player_wins_if_3_x_in_third_column(){
		game.play(new Point(2, 0)); //x
		game.play(new Point(2, 0)); //o
		game.play(new Point(2, 1)); //x
		game.play(new Point(2, 2)); //o
		var result = game.play(new Point(2, 2)); //x

		assertEquals("Player X wins", result);
	}



}
