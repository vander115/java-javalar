package plan.planets;

import plan.tools.Position;
import plan.tools.Time;

abstract public class Planet {

	protected String name;

	protected int index;
	protected int velocity;
	protected int laps;

	protected Time time;
	protected Position position;

	public Planet(String name, int index, int initialVelocity, double instantDuration) {
		this.name = name;
		this.index = index;
		this.velocity = initialVelocity;

		int initialX = 8 + index;
		int initialY = 8;

		this.position = new Position(initialX, initialY);
		this.time = new Time(instantDuration);
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public int getVelocity() {
		return velocity;
	}

	public void changeVelocity(int value) {
		this.velocity = velocity + value;
	}

	public Time getTime() {
		return time;
	}

	public void showPlanet() {
		System.out.println("Planeta " + this.name);
		System.out
				.println("Tempo atual, Horas: " + this.time.getPassedHours() + ", Dias: " + this.time.getPassedDays());
		System.out.println("Posição atual: (" + this.position.getX() + "," + this.position.getY() + ")\n");
	}

	public void moveOnePositionPlanet() {
		if (this.position.getY() > (7 - index) && this.position.getX() == (8 + index))

			this.position.decrementY();

		else if ((this.position.getX() > (7 - index)) && (this.position.getY() == (7 - index)))

			this.position.decrementX();

		else if (this.position.getY() < (9 + index))

			this.position.incrementY();

		else if (this.position.getX() < (9 + index))

			this.position.incrementX();
	}

	public void movePlanet(int numberOfInstant) {
		for (int i = 0; i < velocity * numberOfInstant; i++) {
			moveOnePositionPlanet();
		}

		this.time.incrementHours(numberOfInstant);

	}

}
