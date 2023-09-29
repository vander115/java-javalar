package plan;

import plan.tools.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java {
    private List<Position> position = new ArrayList<>();

    public Java() {
        Position[] positions = {
                new Position(8, 7),
                new Position(8, 8),
                new Position(8, 9),
                new Position(7, 7),
                new Position(7, 8),
                new Position(7, 9)
        };

        this.position.addAll(List.of(positions));
    }

    List<Position> getPositions() {
        return this.position;
    }
}
