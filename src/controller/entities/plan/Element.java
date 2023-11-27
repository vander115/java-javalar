package controller.entities.plan;

import javax.swing.ImageIcon;

import controller.enums.ElementType;
import controller.interfaces.IGetElementType;

abstract public class Element implements IGetElementType {
	protected ImageIcon icon;
	protected String description;
	protected String name;

	public Element(String name, ImageIcon icon, String description) {
		this.name = name;
		this.icon = icon;
		this.description = description;
	}

	public abstract ElementType getElementType();

	public ImageIcon getIcon() {
		return icon;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}
}
