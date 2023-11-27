package controller.entities.modifiers;

import javax.swing.ImageIcon;

import controller.entities.plan.Element;
import controller.entities.plan.Position;

abstract public class Modifier extends Element {

    protected int modifierValue;
    protected Position position;

    public Modifier(String name, String description, Position position, int modifierValue, String filename) {
        super(name, new ImageIcon("src/view/assets/images/modifiers/" + filename), description);
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
