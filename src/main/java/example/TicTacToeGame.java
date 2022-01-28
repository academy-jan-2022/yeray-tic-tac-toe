package example;


public class TicTacToeGame {
	private final Moves moves = new Moves();

	public String play(Point point) {
		moves.add(point);

		var line = renderLine(moves);

		if (point.y() == 2)
			return "_|_|_\n" +
					"_|_|_\n" +
					line;

		if (point.y() == 1)
			return "_|_|_\n" +
					line + "\n" +
					"_|_|_";

		return line + "\n" +
				"_|_|_\n" +
				"_|_|_";
	}

	private static String renderLine(Moves moves) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(moves, indexX));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private static String getSeparator(int indexX) {
		if (indexX < 2)
			return "|";
		return "";
	}

	private static String getCellContent(Moves moves, int indexX) {
		return moves
				.find(indexX)
				.map(Move::player)
				.orElse("_");
	}
}
