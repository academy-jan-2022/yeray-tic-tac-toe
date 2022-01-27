package example;

public class TicTacToeGame {
	private boolean isPlayerOne = true;

	private Board board = new Board();

	public String play(Point point) {
		if (!board.setMyCell(getSymbol(),point.getX(), point.getY())) {
			isPlayerOne = !isPlayerOne;
		}

		return board.showBoard();
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
