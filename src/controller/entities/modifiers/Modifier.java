package controller.entities.modifiers;

import javax.swing.ImageIcon;

import controller.entities.plan.Element;
import controller.entities.plan.Position;

abstract public class Modifier extends Element {

    protected int modifierValue;
    protected Position position;

    public Modifier(Position position, int modifierValue, String filename) {
        this.modifierValue = modifierValue;
        this.position = position;
        this.icon = new ImageIcon("src/view/assets/images/modifiers/" + filename);
    }

    public Position getPosition() {
        return position;
    }

    public int getModifierValue() {
        return modifierValue;
    }
}
