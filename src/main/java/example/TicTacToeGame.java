package example;

public class TicTacToeGame {
	private boolean isPlayerOne = true;

	private Point playerXTurn = null;

	private Board board = new Board();

	public String play(Point point) {
		board.setMyCell(getSymbol(),point.getX(), point.getY());
		board.setMyCell(getSymbol(),point.getX(), point.getY());



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

		playerXTurn = point;
		isPlayerOne = true;

		return matrix.toString();
	}

	private String getLine(Point point, int indexY) {
		if (playerXTurn != null && playerXTurn.getY() == indexY) {
			return lineConstructor(playerXTurn, indexY);
		}
		if (indexY == point.getY()) {
			return lineConstructor(point, indexY);
		}
		return "_|_|_";
	}

	private String lineConstructor(Point point, int indexY) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(point, new Point(indexX, indexY)));
			line.append(getSeparator(indexX));
		}

		return line.toString();
	}

	private String getSeparator(int indexX) {
		if (indexX < 2) return "|";
		return "";
	}

	private String getCellContent(Point point, Point index) {
		if (point.equals(index)) {
			return getSymbol();
		}
		return "_";
	}

	private String getSymbol() {
		if (isPlayerOne) {
			isPlayerOne = false;
			return "X";
		}
		isPlayerOne = true;
		return "O";
	}
}
