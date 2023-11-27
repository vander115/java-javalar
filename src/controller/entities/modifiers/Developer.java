package controller.entities.modifiers;

import controller.entities.plan.Position;
import controller.enums.ElementType;

public class Developer extends Modifier {

	public static final String DESCRIPTION = "Um desenvolvedor é tipo um mágico do século 21, mas em vez de varinhas, eles usam teclados e códigos para fazer maravilhas acontecerem no mundo digital. Eles são os arquitetos invisíveis por trás dos sites legais, dos apps incríveis e de tudo mais que você ama no seu computador ou celular. Basicamente, são os super-heróis que transformam café em linhas de código e bugs em desafios emocionantes. Um dos progamadores da UFC mais conhecidos se chama Fischer Ferreira! No Javalar, os devs aumentam a velocidade dos planetas-linguagem.";

	public Developer(Position position) {
		super("Desenvolvedor", DESCRIPTION, position, 1, "dev.png");
	}

	public ElementType getElementType() {
		return ElementType.DEVELOPER;
	}
}
