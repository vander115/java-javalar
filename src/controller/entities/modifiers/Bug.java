package controller.entities.modifiers;

import controller.entities.plan.Position;
import controller.enums.ElementType;

public class Bug extends Modifier {
    public Bug(Position position) {
        super(position, -1, "bug.png");
        this.name = "Bug";
        this.description = "Um bug é basicamente um erro no código que faz o programa se comportar de maneira estranha. Pode ser um erro de digitação, uma lógica confusa ou até mesmo uma conspiração intergaláctica dos bits e bytes. No Javalar, os bugs reduzem a velocidade dos planetas-linguagem.";
    }

    public ElementType getElementType() {
        return ElementType.BUG;
    }
}
