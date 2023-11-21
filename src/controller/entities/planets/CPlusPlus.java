package controller.entities.planets;

import controller.enums.PlanetIndex;

public class CPlusPlus extends Planet {

    private static final String DESCRIPTION = "C++, o planeta de alto desempenho, é uma linguagem de programação de alto nível e de propósito geral. Sua sintaxe poderosa e eficiência tornam-no uma escolha popular para desenvolvedores de todos os tipos.";

    public CPlusPlus() {
        super("C++", "cmais", DESCRIPTION, PlanetIndex.C_PLUS_PLUS, 2, 0.5, "cmais.png");
    }
}
