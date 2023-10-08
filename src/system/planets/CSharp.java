package system.planets;

import system.enums.PlanetIndex;

public class CSharp extends Planet {

    private static final String DESCRIPTION = "C#, o planeta orientado a objetos, é uma linguagem de programação de propósito geral e de alto nível. Sua sintaxe limpa e moderna, com forte semelhança com Java, tornam-no uma escolha popular para desenvolvimento de jogos e aplicativos móveis.";

    public CSharp() {
        super("C#", DESCRIPTION, PlanetIndex.C_SHARP, 1, 4.0);
    }
}
