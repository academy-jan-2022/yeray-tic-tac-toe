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

		return checkResults(board);
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}

		return "O";
	}

	private String checkResults(Board board) {
		String result = board.showBoard().replace("|", "").replace("\n", "");

		for (var i = 0; i < 3; i++){
			if (result.charAt(0+i) == 'X'
					&& result.charAt(3+i) == 'X'
					&& result.charAt(6+i) == 'X'){
				return "Player X wins";
			}
		}
		if (result.charAt(0) == 'X'
				&& result.charAt(4) == 'X'
				&& result.charAt(8) == 'X'){
			return "Player X wins";
		}

		return board.showBoard();
	}
}
