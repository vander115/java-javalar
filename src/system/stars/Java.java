package system.stars;

import system.plan.Position;

public class Java extends Star {

    public Java() {
        super("Java");
        this.positions.add(new Position(8, 7));
        this.positions.add(new Position(8, 8));
        this.positions.add(new Position(8, 9));
        this.positions.add(new Position(7, 7));
        this.positions.add(new Position(7, 8));
        this.positions.add(new Position(7, 9));
    }

}
