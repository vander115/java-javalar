package system.modifiers;

import system.plan.Element;
import system.plan.Position;

abstract public class Modifier extends Element {
    protected Position position;
    protected int modifierValue;

    public Modifier(Position position, int modifierValue) {
        this.position = position;
        this.modifierValue = modifierValue;
    }

    public Position getPosition() {
        return position;
    }

    public int getModifierValue() {
        return modifierValue;
    }
}
