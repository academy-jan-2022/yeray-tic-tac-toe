package example;

public class TicTacToeGame {
	public String play(Point point) {
		return getMatrix(point);
	}

	private String getMatrix(Point point) {

		var line = getLine(point);
		StringBuilder matrix = new StringBuilder();

		for (var i = 0; i< 3 ; i++){
			matrix.append(foo(point, line, i));
			if (i != 2) matrix.append("\n");
		}

		return matrix.toString();
	}

	private String foo(Point point, String line, int i) {
		return i == point.getY() ?  line : "_|_|_";
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
