package example;

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
		var a = find(new Point(0, 1));
		var b = find(new Point(1, 1));
		var c = find(new Point(2, 1));
		return a.isPresent() && a.get().player() == X
			&& b.isPresent() && b.get().player() == X
			&& c.isPresent() && c.get().player() == X;

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
