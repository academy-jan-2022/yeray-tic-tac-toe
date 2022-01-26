package example;

public class TicTacToeGame {
	public String play(Point point) {
		var line = getLine(point);

		if (point.getX() == 1)
			return line +
					"_|_|_\n" +
					"_|_|_";

		if (point.getY() == 1)
			return "_|_|_\n" +
					line +
					"_|_|_";

		return line +
				"_|_|_\n" +
				"_|_|_";
	}

	private String getLine(Point point) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(point, indexX));
			line.append(getSeparator(indexX));
		}
		line.append("\n");
		return line.toString();
	}

	private String getSeparator(int indexX) {
		return indexX < 2 ? "|" : "";
	}

	private static String getCellContent(Point point, int indexX) {
		return point.getX() == indexX ? "X" : "_";
	}
}
