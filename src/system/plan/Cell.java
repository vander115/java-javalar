package system.plan;

import system.enums.ElementType;
import system.interfaces.IGetElementType;

public class Cell implements IGetElementType {

    public Position position;

    public Element element;

    public Cell(Position position) {
        this.position = position;
        this.element = null;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Position getPosition() {
        return this.position;
    }

    public boolean isOcuppied() {
        return this.element != null;
    }

    public Element getElement() {
        return this.element;
    }

    public void deleteElement() {
        this.element = null;
    }

    public ElementType getElementType() {
        if (element != null) {
            return element.getElementType();
        } else {
            return ElementType.EMPTY;
        }
    }
}
