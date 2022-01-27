package example;

public class TicTacToeGame {
	private final Board board = new Board();
	private final Player player = new Player();

	public String play(Point point) {

		boolean checker= board.setMyCell(getSymbol(), point.getX(), point.getY());

		String output = isAnyWinnerCombination(board,getSymbol().charAt(0));
		if(checker){
			player.flipPlayer();
		}
		return output;
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}

		return "O";
	}

	private String isAnyWinnerCombination(Board board, char playerSymbol) {
		if (board.showBoard().contains(""+playerSymbol+"|"+playerSymbol+"|"+playerSymbol)){
			return "Player "+playerSymbol+" wins";
		}

		String result = board.showBoard().replace("|", "").replace("\n", "");

		for (var i = 0; i < 3; i++){
			if (result.charAt(i) == playerSymbol
					&& result.charAt(3+i) == playerSymbol
					&& result.charAt(6+i) == playerSymbol){
				return "Player "+playerSymbol+" wins";
			}
		}

		if(result.charAt(0) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(8) == playerSymbol
				|| result.charAt(2) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(6) == playerSymbol){
			return "Player "+playerSymbol+" wins";
		};

		if (isItADraw(board)) {
			return "Draw";
		}
		return board.showBoard();
	}

	private boolean isItADraw(Board board) {
		String result = board.showBoard().replace("|", "").replace("\n", "");

		return result.length() == 9 && !result.contains("_");
	}
}
