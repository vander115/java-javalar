package controller.entities.modifiers;

import controller.entities.plan.Position;
import controller.enums.ElementType;

public class Bug extends Modifier {
    public Bug(Position position) {
        super(position, -1, "bug.png");
    }

    public ElementType getElementType() {
        return ElementType.BUG;
    }
}
