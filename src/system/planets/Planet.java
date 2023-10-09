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
	
	public Time getTime() {
		return time;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getNumberOfTranslations() {
		return numberOfTranslations;
	}
	
	public int getNumberOfBugsCollisions() {
		return numberOfBugsCollisions;
	}
	
	public int getNumberOfDevsCollisions() {
		return numberOfDevsCollisions;
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

	
	public ElementType getElementType() {
		return ElementType.PLANET;
	}

}
