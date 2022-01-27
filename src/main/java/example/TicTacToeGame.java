package example;

public class TicTacToeGame {
	private Board board = new Board();
	private Player player = new Player();

	public String play(Point point) {
		if (board.setMyCell(getSymbol(),point.getX(), point.getY())) {
			player.flipPlayer();
		}

		if (isAnyWinnerCombination(board, 'X')){
		 return  "Player X wins";
		}

		if (isAnyWinnerCombination(board, 'O')){
			return  "Player O wins";
		}

		if (isItADraw(board)) {
			return "Draw";
		}


		return board.showBoard();
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}

		return "O";
	}

	private boolean isAnyWinnerCombination(Board board, char playerSymbol) {
		if (board.showBoard().contains(""+playerSymbol+"|"+playerSymbol+"|"+playerSymbol)){
			return true;
		}
		String result = board.showBoard().replace("|", "").replace("\n", "");

		for (var i = 0; i < 3; i++){
			if (result.charAt(i) == playerSymbol
					&& result.charAt(3+i) == playerSymbol
					&& result.charAt(6+i) == playerSymbol){
				return true;
			}
		}

		return result.charAt(0) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(8) == playerSymbol
				|| result.charAt(2) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(6) == playerSymbol;
	}

	private boolean isItADraw(Board board) {
		String result = board.showBoard().replace("|", "").replace("\n", "");

		if (result.length() == 9 && !result.contains("_"))
			return true;
		return false;
	}
}
