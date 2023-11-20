package controller.entities.planets;

import controller.enums.PlanetIndex;

public class Python extends Planet {

    private static final String DESCRIPTION = "Python, conhecido por sua legibilidade e simplicidade, é um planeta-linguagem poderoso e versátil. Ele é amplamente utilizado em desenvolvimento web, automação, inteligência artificial e muito mais. Sua sintaxe limpa e vasta comunidade de apoio tornam-no uma escolha popular para iniciantes e especialistas.";

    public Python() {
        super("Python", "python", DESCRIPTION, PlanetIndex.PYTHON, 4, 24.0, "python.png");
    }
}
