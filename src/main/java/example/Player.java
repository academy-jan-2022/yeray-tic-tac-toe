package example;

public enum Player {
	X,
	O;

	public Player flip() {
		if (this == X)
			return O;
		return X;
	}
}
