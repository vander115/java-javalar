package system.planets;

import system.enums.ElementType;
import system.enums.PlanetIndex;
import system.plan.Element;
import system.plan.Position;
import system.tools.Satellite;

abstract public class Planet extends Element {

	protected String name;
	protected String description;
	protected PlanetIndex index;
	protected int velocity;
	public Time time;

	protected int numberOfTranslations;
	protected int numberOfBugsCollisions;
	protected int numberOfDevsCollisions;

	public Position initialPosition;
	public Position position;
	public Position previousPosition;

	public Planet(String name, String description, PlanetIndex index, int initialVelocity, double instantDuration) {
		this.name = name;
		this.description = description;
		this.index = index;
		this.velocity = initialVelocity;

		int initialX = 8 + index.getValue();
		int initialY = 8;

		this.previousPosition = new Position(initialX, initialY);
		this.position = new Position(initialX, initialY);
		this.initialPosition = new Position(initialX, initialY);

		this.time = new Time(instantDuration);
	}

	public PlanetIndex getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

	public Position getPreviousPosition() {
		return previousPosition;
	}

	public int getVelocity() {
		return velocity;
	}

	public Position getPosition() {
		return position;
	}

	public void setPreviousPosition() {
		previousPosition = new Position(position.getX(), position.getY());
	}

	private void moveOnePositionPlanet() {

		int index = this.index.getValue();
		int x = position.getX();
		int y = position.getY();

		if (y > (7 - index) && x == (8 + index)) {

			position.decrementY();

		} else if ((x > (7 - index)) && (y == (7 - index))) {

			position.decrementX();

		} else if (y < (9 + index)) {

			position.incrementY();

		} else if (x < (9 + index)) {

			position.incrementX();
		}

		if (Satellite.isPositionsEqual(this.position, this.initialPosition))
			numberOfTranslations++;

	}

	public void movePlanet(int numberOfInstant) {
		setPreviousPosition();

		for (int i = 0; i < velocity * numberOfInstant; i++) {
			moveOnePositionPlanet();
			checkTranslation();
		}

		time.incrementHours(numberOfInstant);
	}

	public void collideIntoBug() {
		velocity--;
		numberOfBugsCollisions++;
	}

	public void collideIntoDev() {
		velocity++;
		numberOfDevsCollisions++;
	}

	private void checkTranslation() {
		if (Satellite.isPositionsEqual(position, initialPosition)) {
			numberOfTranslations++;
		}
	}

	public void showPlanet() {

		String formatedDays = String.format("%.2f", time.getPassedDays());

		System.out.println();
		System.out.println("\u001B[1mPlaneta " + name.toUpperCase() + "\u001B[0m");
		System.out.println("- Voltas: " + numberOfTranslations);
		System.out.println("- Velocidade: " + velocity);
		System.out.println("- Posição atual: (" + position.getX() + "," + position.getY() + ")");
		System.out.println("- Tempo: " + time.getPassedHours() + " horas, " + formatedDays + " dias");
		if (velocity == 0) {
			System.out.println("\u001B[1mO planeta " + name + " EXPLODIU.\u001B[0m");
		}
	}

	public void showPlanetReport() {
		showPlanet();

		System.out.println("- Colisões com bugs: " + numberOfBugsCollisions);
		System.out.println("- Colisões com devs: " + numberOfDevsCollisions);
		System.out.println("- Descrição: " + description + "\n");
	}

	public ElementType getElementType() {
		return ElementType.PLANET;
	}

}
