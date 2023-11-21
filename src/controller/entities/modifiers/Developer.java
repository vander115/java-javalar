package controller.entities.modifiers;

import controller.entities.plan.Position;
import controller.enums.ElementType;

public class Developer extends Modifier {
    public Developer(Position position) {
        super(position, 1, "dev.png");
        this.name = "Desenvolvedor";
    }

    public ElementType getElementType() {
        return ElementType.DEVELOPER;
    }
}
