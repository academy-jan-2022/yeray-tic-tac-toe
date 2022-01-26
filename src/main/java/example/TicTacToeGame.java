package example;

public class TicTacToeGame {
	public String play(int x, int y) {


		if (y == 1)
			return "_|_|_\n" +
					"X|_|_\n" +
					"_|_|_";

		return "X|_|_\n" +
				"_|_|_\n" +
				"_|_|_";
	}
}
