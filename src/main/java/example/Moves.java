package example;

import static example.Player.O;
import static example.Player.X;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moves {
	private final List<Move> moves = new ArrayList<>();

	public void add(Point point) {
		moves.add(new Move(getCurrentPlayer(), point));
	}

	private Player getCurrentPlayer() {
		if (moves.isEmpty())
			return X;
		var move = moves.get(moves.size() - 1);
		if (move.isPlayer(X))
			return O;
		return X;
	}

	public Optional<Move> find(Point index) {
		return moves
				.stream()
				.filter(move -> move.point().equals(index))
				.findFirst();
	}
}
