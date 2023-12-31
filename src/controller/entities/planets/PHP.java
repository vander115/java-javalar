package controller.entities.planets;

import controller.enums.PlanetIndex;

public class PHP extends Planet {

    private static final String DESCRIPTION = "PHP é um planeta-linguagem amplamente utilizado para o desenvolvimento web server-side. Com sua capacidade de incorporar código diretamente em HTML, é uma escolha eficiente para construir páginas dinâmicas. WordPress, um dos sistemas de gerenciamento de conteúdo mais populares, é construído em PHP.";

    public PHP() {
        super("PHP", "php", DESCRIPTION, PlanetIndex.PHP, 2, 60.0, "php.png");
    }
}
