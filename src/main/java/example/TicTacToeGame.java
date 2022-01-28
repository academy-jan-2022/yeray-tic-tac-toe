package example;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {
	private final List<Move> moves = new ArrayList<>();

	public String play(Point point) {
		if (!moves.isEmpty())
			moves.add(new Move("O", point));

		if (moves.isEmpty())
			moves.add(new Move("X", point));

		var line = renderLine(moves);

		if (point.y() == 2)
			return "_|_|_\n" +
					"_|_|_\n" +
					line;

		if (point.y() == 1)
			return "_|_|_\n" +
					line + "\n" +
					"_|_|_";

		return line + "\n" +
				"_|_|_\n" +
				"_|_|_";
	}

	private static String renderLine(List<Move> moves) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			line.append(getCellContent(moves, indexX));
			line.append(getSeparator(indexX));
		}
		return line.toString();
	}

	private static String getSeparator(int indexX) {
		if (indexX < 2)
			return "|";
		return "";
	}

	private static String getCellContent(List<Move> moves, int indexX) {
		return moves
				.stream()
				.filter(move -> move.point().x() == indexX)
				.findFirst()
				.map(Move::player)
				.orElse("_");
	}
}
