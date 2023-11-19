package controller.entities.planets;

import controller.enums.PlanetIndex;

public class JavaScript extends Planet {

    private static final String DESCRIPTION = "JavaScript, o planeta dinâmico da web, é essencial para a criação de interatividade em páginas da web. Ele permite o desenvolvimento de aplicativos front-end e back-end, tornando-o crucial para o desenvolvimento web moderno. Bibliotecas populares como React e frameworks como Node.js aumentam ainda mais sua utilidade.";

    public JavaScript() {
        super("JavaScript", DESCRIPTION, PlanetIndex.JAVASCRIPT, 3, 10.0, "javascript.png");
    }
}
