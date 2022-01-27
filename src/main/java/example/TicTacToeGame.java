package example;

public class TicTacToeGame {
	private Point playerXTurn = null;

	public String play(Point point) {
		var line = getLine(point);

		if (playerXTurn == null)
			playerXTurn = point;

		if (point.getY() == 2)
			return "_|_|_\n" +
					"_|_|_\n" +
					line;

		if (point.getY() == 1)
			return "_|_|_\n" +
					line + "\n" +
					"_|_|_";

		return line + "\n" +
				"_|_|_\n" +
				"_|_|_";
	}

	private String getLine(Point point) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(point, indexX));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private String getSeparator(int indexX) {
		return indexX < 2 ? "|" : "";
	}

	private String getCellContent(Point point, int indexX) {
		boolean isMarkOnFirstTurn = playerXTurn == null && point.getX() == indexX;
		boolean wasMarkOnFirstTurn = playerXTurn != null && playerXTurn.getX() == indexX;

		if (isMarkOnFirstTurn || wasMarkOnFirstTurn)
			return "X";

		if (playerXTurn != null && point.getX() == indexX)
			return "O";

		return "_";
	}
}
