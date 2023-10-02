package system.modifiers;

import system.enums.ElementType;
import system.plan.Position;

public class Developer extends Modifier {
    public Developer(Position position) {
        super(position, 1);
    }

    public ElementType verifyElementType() {
        return ElementType.DEVELOPER;
    }
}
