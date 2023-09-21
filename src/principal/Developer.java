package principal;

public class Developer {
	private Position position;
	private int bonus = 1;

	public Developer(int x, int y) {
		this.position = new Position(x, y);
	}

	public int getBonus() {
		return bonus;
	}

	public Position getPosition() {
		return position;
	}
}
