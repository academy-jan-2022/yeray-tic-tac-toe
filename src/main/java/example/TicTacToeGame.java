package example;


import java.util.stream.IntStream;

public class TicTacToeGame {
	private final Moves moves = new Moves();

	public String play(Point point) {
		moves.add(point);

		var lines = IntStream
			.range(0, 3)
			.mapToObj(indexY -> renderLine(moves, indexY))
			.toList();

		return String.join("\n", lines);
	}

	private static String renderLine(Moves moves, int indexY) {
		var cells = IntStream
			.range(0, 3)
			.mapToObj(indexX -> getCellContent(moves, new Point(indexX, indexY)))
			.toList();

		return String.join("|", cells);
	}

	private static String getCellContent(Moves moves, Point index) {
		return moves
				.find(index)
				.map(Move::player)
				.orElse("_");
	}
}
