package controller.entities.plan;

import controller.enums.ElementType;
import controller.interfaces.IGetElementType;

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

	public Element getElement() {
		return this.element;
	}

	public void deleteElement() {
		this.element = null;
	}

	public boolean checkIsOcuppied() {
		return this.element != null;
	}

	public ElementType getElementType() {
		if (element != null) {
			return element.getElementType();
		} else {
			return ElementType.EMPTY;
		}
	}
}
