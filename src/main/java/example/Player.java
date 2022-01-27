package example;

public class Player {
	private boolean playerX = true;

	public boolean isPlayerX() {
		return playerX;
	}

	public void flip(){
		this.playerX = !this.playerX;
	}
}
