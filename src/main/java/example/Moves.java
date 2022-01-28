package example;

import static example.Player.O;
import static example.Player.X;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moves {
	private final List<Move> moves = new ArrayList<>();

	public void add(Point point) {
		if (find(point).isEmpty() && !isWon())
			moves.add(new Move(getCurrentPlayer(), point));
	}

	private boolean isWon() {
		return isWinningLine(new Point(0, 1), new Point(1, 1), new Point(2, 1), X)
				|| isWinningLine(new Point(0, 0), new Point(1, 0), new Point(2, 0), O)
				|| isWinningLine(new Point(0, 0), new Point(1, 1), new Point(2, 2), X);
	}

	private boolean isWinningLine(Point a, Point b, Point c, Player player) {
		var aDX = find(a);
		var bDX = find(b);
		var cDX = find(c);
		return aDX.isPresent() && aDX.get().player() == player
				&& bDX.isPresent() && bDX.get().player() == player
				&& cDX.isPresent() && cDX.get().player() == player;
	}

	private Player getCurrentPlayer() {
		return getLastMove()
				.map(Move::next)
				.orElse(X);
	}

	private Optional<Move> getLastMove() {
		if (moves.isEmpty())
			return Optional.empty();
		return Optional.of(moves.get(moves.size() - 1));
	}

	public Optional<Move> find(Point index) {
		return moves
				.stream()
				.filter(move -> move.point().equals(index))
				.findFirst();
	}
}
