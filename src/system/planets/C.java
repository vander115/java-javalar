package system.planets;

import system.enums.PlanetIndex;

public class C extends Planet {
    private static final String DESCRIPTION = "C, o planeta fundamental, é uma linguagem de programação de baixo nível amplamente utilizada para desenvolvimento de sistemas e software de sistema. Sua eficiência e controle direto sobre o hardware tornam-no crucial para tarefas que exigem desempenho máximo.";

    public C() {
        super("C", DESCRIPTION, PlanetIndex.C, 10, 0.1);
    }
}
