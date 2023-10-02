package system.planets;

import system.enums.ElementType;
import system.enums.PlanetIndex;
import system.plan.Element;
import system.plan.Position;
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

        int initialX = 8 + index.getIndexValue();
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
        this.previousPosition = new Position(this.position.getX(), this.position.getY());
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

        String formattedDays = String.format("%.2f", this.time.getPassedDays());

        System.out.println("Planeta " + this.name);
        System.out.println("Voltas: " + this.numberOfTranslations + ", Colisões: " + this.numberOfCollisions);
        System.out.println("Índice: " + this.index.getIndexValue() + ", Velocidade: " + this.velocity);
        System.out
                .println("Tempo atual, Horas: " + this.time.getPassedHours() + ", Dias: " + formattedDays);
        System.out.println("Posição atual: (" + this.position.getX() + "," + this.position.getY() + ")\n");

        if (this.velocity == 0) {
            System.out.println("O planeta " + this.name + " EXPLODIU.\n");
        }
    }

    public void moveOnePositionPlanet() {
        int index = this.index.getIndexValue();
        if (this.position.getY() > (7 - index) && this.position.getX() == (8 + index))

            this.position.decrementY();

        else if ((this.position.getX() > (7 - index)) && (this.position.getY() == (7 - index)))

            this.position.decrementX();

        else if (this.position.getY() < (9 + index))

            this.position.incrementY();

        else if (this.position.getX() < (9 + index))

            this.position.incrementX();

        if (Satellites.isPositionsEqual(this.position, this.initialPosition)) {
            this.numberOfTranslations++;
        }
    }

    public void movePlanet(int numberOfInstant) {
        setPreviousPosition();
        for (int i = 0; i < velocity * numberOfInstant; i++) {
            moveOnePositionPlanet();
        }
        this.time.incrementHours(numberOfInstant);

    }

    public void decreaseVelocity() {
        this.velocity--;
        collide();
    }

    public void increaseVelocity() {
        this.velocity++;
        collide();
    }

    public void collide() {
        this.numberOfCollisions++;
    }

    public ElementType verifyElementType() {
        return ElementType.PLANET;
    }

}
