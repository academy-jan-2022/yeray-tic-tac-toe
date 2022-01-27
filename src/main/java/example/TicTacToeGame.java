package example;

public class TicTacToeGame {
	private Board board = new Board();
	private Player player = new Player();

	public String play(Point point) {
		if (board.setMyCell(getSymbol(),point.getX(), point.getY())) {
			player.flipPlayer();
		}

		if (board.showBoard().contains("X|X|X")){
			return "Player X wins";
		}


		return board.showBoard();
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}
		return "O";
	}
}
