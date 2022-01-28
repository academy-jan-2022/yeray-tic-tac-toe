package example;

import static example.Player.X;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moves {
	private final List<Move> moves = new ArrayList<>();

	public void add(Point point) {
		if (find(point).isEmpty())
			moves.add(new Move(getCurrentPlayer(), point));
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
