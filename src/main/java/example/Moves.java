package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moves {
	private final List<Move> moves = new ArrayList<>();

	public void add(Point point) {
		moves.add(new Move(getCurrentPlayer(), point));
	}

	private String getCurrentPlayer() {
		if (moves.isEmpty())
			return "X";
		var move = moves.get(moves.size() - 1);
		if (move.player().equals("X"))
			return "O";
		return "X";
	}

	public Optional<Move> find(int indexX) {
		return moves
				.stream()
				.filter(move -> move.point().x() == indexX)
				.findFirst();
	}
}
