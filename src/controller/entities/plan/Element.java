package controller.entities.plan;

import javax.swing.ImageIcon;

import controller.enums.ElementType;
import controller.interfaces.IGetElementType;

abstract public class Element implements IGetElementType {
	protected ImageIcon icon;

	public abstract ElementType getElementType();

	public ImageIcon getIcon() {
		return icon;
	}
}
