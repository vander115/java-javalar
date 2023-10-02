package system.modifiers;

import system.enums.ElementType;
import system.plan.Position;

public class Bug extends Modifier {
    public Bug(Position position) {
        super(position, -1);
    }

    public ElementType verifyElementType() {
        return ElementType.BUG;
    }
}
