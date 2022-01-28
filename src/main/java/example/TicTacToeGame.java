package example;

public class TicTacToeGame {
	private Point playerXTurn = null;
	private Move playerXMove = null;

	public String play(Point point) {
		var line = renderLine(point);

		if (playerXTurn == null)
			playerXTurn = point;

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

	private String renderLine(Point point) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(point, indexX));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private String getSeparator(int indexX) {
		if (indexX < 2)
			return "|";
		return "";
	}

	private String getCellContent(Point point, int indexX) {
		boolean isMarkOnFirstTurn = playerXTurn == null && point.x() == indexX;
		boolean wasMarkOnFirstTurn = playerXTurn != null && playerXTurn.x() == indexX;

		if (isMarkOnFirstTurn || wasMarkOnFirstTurn)
			return "X";

		if (playerXTurn != null && point.x() == indexX)
			return "O";

		return "_";
	}
}
