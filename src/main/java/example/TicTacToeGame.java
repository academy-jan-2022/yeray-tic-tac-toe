package example;

public class TicTacToeGame {
	private boolean isPlayerOne = true;

	private Board board = new Board();

	public String play(Point point) {
		board.setMyCell(getSymbol(),point.getX(), point.getY());

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
