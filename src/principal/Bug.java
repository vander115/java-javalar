package principal;

public class Bug {
	private Position position;
	private int onus = 1;

	public Bug(int x, int y) {
		this.position = new Position(x, y);
	}

	public int getOnus() {
		return onus;
	}

	public Position getPosition() {
		return position;
	}
}
