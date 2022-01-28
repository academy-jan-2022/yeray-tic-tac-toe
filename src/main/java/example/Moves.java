package example;

import static example.Player.X;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Moves {
	private final List<Move> moves = new ArrayList<>();

	private final Point[][] winningLines = new Point[][] {
			new Point[] { new Point(0, 0), new Point(1, 0), new Point(2, 0) },
			new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1) },
			new Point[] { new Point(0, 2), new Point(1, 2), new Point(2, 2) },

			new Point[] { new Point(0, 0), new Point(0, 1), new Point(0, 2) },
			new Point[] { new Point(1, 0), new Point(1, 1), new Point(1, 2) },
			new Point[] { new Point(2, 0), new Point(2, 1), new Point(2, 2) },

			new Point[] { new Point(0, 0), new Point(1, 1), new Point(2, 2) },
			new Point[] { new Point(2, 0), new Point(1, 1), new Point(0, 2) }
	};

	public void add(Point point) {
		if (find(point).isEmpty() && !isWon())
			moves.add(new Move(getCurrentPlayer(), point));
	}

	private boolean isWon() {
		return Arrays.stream(Player
				.values())
				.anyMatch(player ->
						Arrays.stream(winningLines).anyMatch(winningLine -> isWinningLine(winningLine, player))
				);
	}

	private boolean isWinningLine(Point[] points, Player player) {
		var foundMoves = moves
				.stream()
				.filter(move -> Arrays.stream(points).anyMatch(p -> p.equals(move.point())))
				.toList();
		if (foundMoves.size() < 3)
			return false;

		return foundMoves
				.stream()
				.allMatch(move -> move.player() == player);
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
