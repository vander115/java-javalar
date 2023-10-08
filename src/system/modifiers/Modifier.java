package system.modifiers;

import system.plan.Element;
import system.plan.Position;

abstract public class Modifier extends Element {

    protected int modifierValue;
    protected Position position;

    public Modifier(Position position, int modifierValue) {
        this.modifierValue = modifierValue;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getModifierValue() {
        return modifierValue;
    }
}
