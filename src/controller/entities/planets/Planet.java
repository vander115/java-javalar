package controller.entities.planets;

import javax.swing.ImageIcon;

import controller.entities.plan.Element;
import controller.entities.plan.Position;
import controller.enums.ElementType;
import controller.enums.PlanetIndex;
import controller.tools.Satellite;

abstract public class Planet extends Element {

	protected String slug;
	protected PlanetIndex index;
	protected int velocity;
	public Time time;

	protected int numberOfTranslations;
	protected int numberOfBugsCollisions;
	protected int numberOfDevsCollisions;

	public Position initialPosition;
	public Position position;
	public Position previousPosition;

	public Planet(String name, String slug, String description, PlanetIndex index, int initialVelocity,
			double instantDuration,
			String filename) {
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.index = index;
		this.velocity = initialVelocity;

		int initialX = 7 + index.getValue();
		int initialY = 7;

		this.previousPosition = new Position(initialX, initialY);
		this.position = new Position(initialX, initialY);
		this.initialPosition = new Position(initialX, initialY);

		this.time = new Time(instantDuration);

		this.icon = new ImageIcon("src/view/assets/images/planets/" + filename);
	}

	public PlanetIndex getIndex() {
		return index;
	}

	public String getSlug() {
		return slug;
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

		if (y > (7 - index) && x == (7 + index)) {

			position.decrementY();

		} else if ((x > (7 - index)) && (y == (7 - index))) {

			position.decrementX();

		} else if (y < (7 + index)) {

			position.incrementY();

		} else if (x < (7 + index)) {

			position.incrementX();
		}

		checkTranslation();

	}

	public void movePlanet(int numberOfInstant) {
		setPreviousPosition();

		for (int i = 0; i < velocity * numberOfInstant; i++) {
			moveOnePositionPlanet();
			checkTranslation();
		}
		if (isAlive()) {
			time.incrementHours(numberOfInstant);
		}
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

	public boolean isAlive() {
		return velocity > 0;
	}

	public ElementType getElementType() {
		return ElementType.PLANET;
	}

}
