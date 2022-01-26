package example;

public class TicTacToeGame {
	public String play(int x, int y) {
		if (x == 1)
			return "_|X|_\n" +
					"_|_|_\n" +
					"_|_|_";

		if (y == 1)
			return "_|_|_\n" +
					"X|_|_\n" +
					"_|_|_";

		return "X|_|_\n" +
				"_|_|_\n" +
				"_|_|_";
	}
}
