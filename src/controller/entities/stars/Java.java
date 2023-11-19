package controller.entities.stars;

import controller.entities.plan.Position;

public class Java extends Star {

    public Java() {
        super("Java", "java.png");
        this.positions.add(new Position(7, 7));
    }

}
