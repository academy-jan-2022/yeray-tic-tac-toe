package example;

public class TicTacToeGame {
	public String play(Point point) {


		return getMatrix(point);
	}

	private String getMatrix(Point point) {

		var line = getLine(point);

		if (point.getY() == 1)
			return "_|_|_\n" +
					line + "\n" +
					"_|_|_";

		if (point.getY() == 2)
			return "_|_|_\n" +
					"_|_|_\n" +
					line;

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

	private static String getCellContent(Point point, int indexX) {
		return point.getX() == indexX ? "X" : "_";
	}
}
