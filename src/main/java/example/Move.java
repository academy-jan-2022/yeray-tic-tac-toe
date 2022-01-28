package example;

public record Move(String player, Point point) {
	public boolean isPlayer(String player) {
		return this.player.equals(player);
	}
}
