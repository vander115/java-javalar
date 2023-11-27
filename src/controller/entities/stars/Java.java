package controller.entities.stars;

import controller.entities.plan.Position;

public class Java extends Star {

    public Java() {
        super("Java", "java.png");
        this.positions.add(new Position(7, 7));
        this.description = "Java é como o canivete suíço da programação. É uma linguagem de programação versátil que pode fazer de tudo, desde aplicativos móveis até sistemas de gerenciamento de bancos de dados. Então, se você quer escrever código que funcione em praticamente qualquer lugar, do seu laptop ao seu torradeira (quem sabe?), o Java é o cara para o trabalho! O Java é a estrela do sistema Javalar!";
    }

}
