package controller.entities.plan;

public class Position {

	private int x;
	private int y;

	public Position() {
		this.x = (int) (Math.random() * 15);
		this.y = (int) (Math.random() * 15);
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void incrementX() {
		this.x++;
	}

	public void decrementX() {
		this.x--;
	}

	public void incrementY() {
		this.y++;
	}

	public void decrementY() {
		this.y--;
	}
}
