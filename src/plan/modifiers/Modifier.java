package plan.modifiers;

import plan.tools.Position;

abstract public class Modifier {
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
