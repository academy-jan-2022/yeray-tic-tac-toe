package example;

public record Move(Player player, Point point) {
	public Player next() {
		return player.flip();
	}
}
