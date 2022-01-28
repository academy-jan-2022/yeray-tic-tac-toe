package example;


public class TicTacToeGame {
	private final Moves moves = new Moves();

	public String play(Point point) {
		moves.add(point);

		return renderLine(moves, 0) + "\n" +
				renderLine(moves, 1) + "\n" +
				renderLine(moves, 2);
	}

	private static String renderLine(Moves moves, int indexY) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(moves, new Point(indexX, indexY)));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private static String getSeparator(int indexX) {
		if (indexX < 2)
			return "|";
		return "";
	}

	private static String getCellContent(Moves moves, Point index) {
		return moves
				.find(index)
				.map(Move::player)
				.orElse("_");
	}
}
