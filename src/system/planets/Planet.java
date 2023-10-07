package system.planets;

import system.enums.ElementType;
import system.enums.PlanetIndex;
import system.plan.Element;
import system.plan.Position;
import system.tools.AligmentsSatellite;
import system.tools.Satellites;

abstract public class Planet extends Element {

    protected String name;

    protected PlanetIndex index;
    protected int velocity;
    protected int numberOfTranslations;
    protected int numberOfCollisions;

    public Time time;

    public Position initialPosition;
    public Position position;
    public Position previousPosition;

    public Planet(String name, PlanetIndex index, int initialVelocity, double instantDuration) {
        this.name = name;
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

    public Position getPosition() {
        return position;
    }

    public Position getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition() {
        previousPosition = new Position(position.getX(), position.getY());
    }

    public int getVelocity() {
        return velocity;
    }

    public void changeVelocity(int value) {
        velocity = velocity + value;
    }

    public Time getTime() {
        return time;
    }

    public void showPlanet() {

        String formattedDays = String.format("%.2f", time.getPassedDays());

        System.out.println("Planeta " + name);
        System.out.println("Voltas: " + numberOfTranslations);
        System.out.println("Velocidade: " + velocity);
        System.out
                .println("Tempo atual, Horas: " + time.getPassedHours() + ", Dias: " + formattedDays);
        System.out.println("Posição atual: (" + position.getX() + "," + position.getY() + ")\n");

        if (velocity == 0) {
            System.out.println("O planeta " + name + " EXPLODIU.\n");
        }
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

        if (Satellites.isPositionsEqual(this.position, this.initialPosition))
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

    public void decreaseVelocity() {
        velocity--;
        collide();
    }

    public void increaseVelocity() {
        velocity++;
        collide();
    }

    private void collide() {
        numberOfCollisions++;
    }

    private void checkTranslation() {
        if (Satellites.isPositionsEqual(position, initialPosition)) {
            numberOfTranslations++;
        }
    }

    public ElementType getElementType() {
        return ElementType.PLANET;
    }

}
