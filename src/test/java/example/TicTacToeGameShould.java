package example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TicTacToeGameShould {
	@Test void
	mark_the_first_move_in_top_left_corner_with_an_X() {
		var game = new TicTacToeGame();
		var result = game.play(0, 0);
		assertEquals(
				"X|_|_\n" +
				"_|_|_\n" +
				"_|_|_",
				result
		);
	}
}
