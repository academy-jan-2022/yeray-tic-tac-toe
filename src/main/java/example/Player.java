package example;

public class Player {
	private boolean playerX = true;

	public boolean isPlayerX() {
		return playerX;
	}

	public void setPlayer(boolean playerX) {
		this.playerX = playerX;
	}

	public void flipPlayer(){
		this.playerX = !this.playerX;
	}
}
