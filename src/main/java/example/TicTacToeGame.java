package example;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicTacToeGame {
	private final Moves moves = new Moves();

	public String play(Point point) {
		moves.add(point);

		var lines =
				IntStream
						.range(0, 3)
						.mapToObj(indexY -> renderLine(moves, indexY))
						.toList();

		return String.join("\n", lines);
	}

	private static String renderLine(Moves moves, int indexY) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(moves, new Point(indexX, indexY)));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private static String getSeparator(int indexX) {
		if (indexX < 2)
			return "|";
		return "";
	}

	private static String getCellContent(Moves moves, Point index) {
		return moves
				.find(index)
				.map(Move::player)
				.orElse("_");
	}
}
