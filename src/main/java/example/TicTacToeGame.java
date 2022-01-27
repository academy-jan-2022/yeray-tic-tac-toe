package example;

public class TicTacToeGame {
	private Board board = new Board();
	private Player player = new Player();

	public String play(Point point) {
		if (board.setMyCell(getSymbol(),point.getX(), point.getY())) {
			player.flipPlayer();
		}

		return isAnyWinnerCombination(board);
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}

		return "O";
	}

	private String isAnyWinnerCombination(Board board) {
		if (board.showBoard().contains("X|X|X")){
			return "Player X wins";
		}
		if (board.showBoard().contains("O|O|O")){
			return "Player O wins";
		}

		String result = board.showBoard().replace("|", "").replace("\n", "");

		for (var i = 0; i < 3; i++){
			if (result.charAt(0+i) == 'X'
					&& result.charAt(3+i) == 'X'
					&& result.charAt(6+i) == 'X'){
				return "Player X wins";
			}
		}

		for (var i = 0; i < 3; i++){
			if (result.charAt(0+i) == 'O'
					  && result.charAt(3+i) == 'O'
					  && result.charAt(6+i) == 'O'){
				return "Player O wins";
			}
		}
		if (result.charAt(0) == 'X'
				&& result.charAt(4) == 'X'
				&& result.charAt(8) == 'X'
			|| result.charAt(2) == 'X'
				  && result.charAt(4) == 'X'
				  && result.charAt(6) == 'X'){
			return "Player X wins";
		}

		return board.showBoard();
	}
}
