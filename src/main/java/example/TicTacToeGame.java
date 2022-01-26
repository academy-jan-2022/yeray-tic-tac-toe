package example;

public class TicTacToeGame {
	public String play(Point point) {
		return getMatrix(point);
	}

	private String getMatrix(Point point) {

		var line = getLine(point);
		var matrix = "";

		for (var i = 0; i< 3 ; i++){
			if (i == point.getY()) matrix += line;
			else matrix += "_|_|_";
			if (i != 2) matrix += "\n";
		}

		return  matrix;
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
