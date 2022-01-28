package example;

public record Move(Player player, Point point) {
	public boolean isPlayer(Player player) {
		return this.player.equals(player);
	}
}
