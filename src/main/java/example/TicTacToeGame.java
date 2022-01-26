package example;

public class TicTacToeGame {
	public String play(Point point) {
		var line = new StringBuilder();
		for (int indexX = 0; indexX < 3; indexX++) {
			if (point.getX() == indexX) {
				line.append("X");
			} else {
				line.append("_");
			}
			if (indexX < 2)
				line.append("|");
		}
		line.append("\n");


		if (point.getX() == 1)
			return line +
					"_|_|_\n" +
					"_|_|_";

		if (point.getY() == 1)
			return "_|_|_\n" +
					line +
					"_|_|_";

		return line +
				"_|_|_\n" +
				"_|_|_";
	}
}
