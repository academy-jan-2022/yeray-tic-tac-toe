package example;

public class TicTacToeGame {
	private boolean isPlayerOne = true;

	public String play(Point point) {

		return getMatrix(point);
	}

	private String getMatrix(Point point) {

		StringBuilder matrix = new StringBuilder();

		for (var i = 0; i< 3 ; i++){
			matrix.append(getLine(point, i));
			if (i != 2) {
				matrix.append("\n");
			}
		}

		return matrix.toString();
	}

	private String getLine(Point point, int i) {
		if (i == point.getY()) {
			return lineConstructor(point);
		}
		return "_|_|_";
	}

	private String lineConstructor(Point point) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(point, indexX));
			line.append(getSeparator(indexX));
		}

		return line.toString();
	}

	private String getSeparator(int indexX) {
		if (indexX < 2) return "|";
		return "";
	}

	private String getCellContent(Point point, int indexX) {
		if (point.getX() == indexX) {
			if (isPlayerOne) {
				isPlayerOne = false;
				return "X";
			}
			isPlayerOne = true;
			return "O";
		}
		return "_";
	}
}
