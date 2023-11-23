package controller.entities.stars;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.entities.plan.Element;
import controller.entities.plan.Position;
import controller.enums.ElementType;

public abstract class Star extends Element {
    protected ArrayList<Position> positions = new ArrayList<>();

    public Star(String name, String filename) {
        this.name = name;
        this.icon = new ImageIcon("src/view/assets/images/stars/" + filename);
    }

    public ArrayList<Position> getPositions() {
        return this.positions;
    }

    public ElementType getElementType() {
        return ElementType.STAR;
    }
}
