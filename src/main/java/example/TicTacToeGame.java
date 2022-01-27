package example;

public class TicTacToeGame {
	private final Board board = new Board();
	private final Player player = new Player();

	public String play(Point point) {

		boolean isValidMove = board.setMyCell(getSymbol(), point.getX(), point.getY());

		return isGameEnded(board,getSymbol().charAt(0), isValidMove);
	}

	private String getSymbol() {
		if (player.isPlayerX()) {
			return "X";
		}

		return "O";
	}

	private String isGameEnded(Board board, char playerSymbol, boolean isValidMove) {
		String result = board.showBoard().replace("|", "").replace("\n", "");

		if(     isARowWinning(board, playerSymbol) ||
				isAColumnWinning(playerSymbol, result) ||
				isADiagonalWinning(playerSymbol, result)
		){
				return "Player " + playerSymbol + " wins";
		};

		if (isItADraw(board)) {
			return "Draw";
		}

		if(isValidMove){
			player.flip();
		}

		return board.showBoard();
	}



	private Boolean isARowWinning(Board board, char playerSymbol) {
		return board.showBoard().contains(
				playerSymbol +"|"+ playerSymbol +"|"+ playerSymbol
		);
	}

	private  Boolean isAColumnWinning(char playerSymbol, String result){

		for (var i = 0; i < 3; i++){
			if (result.charAt(i) == playerSymbol
					&& result.charAt(3+i) == playerSymbol
					&& result.charAt(6+i) == playerSymbol){
				return true;
			}
		}
		return false;
	}

	private  Boolean isADiagonalWinning(char playerSymbol, String result ){
		if(result.charAt(0) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(8) == playerSymbol
				|| result.charAt(2) == playerSymbol
				&& result.charAt(4) == playerSymbol
				&& result.charAt(6) == playerSymbol){
			return true;
		};
		return  false;
	}

	private boolean isItADraw(Board board) {
		String result = board.showBoard().replace("|", "").replace("\n", "");

		return result.length() == 9 && !result.contains("_");
	}
}
