package plan.modifiers;

import plan.tools.Position;

abstract public class Modifier {
    protected Position position;
    protected int points;

    public Modifier(int x, int y, int points) {
        this.position = new Position(x, y);
        this.points = points;
    }

    public Position getPosition() {
        return position;
    }
}
