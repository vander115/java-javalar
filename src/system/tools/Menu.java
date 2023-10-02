package system.tools;

import system.plan.Plan;

import java.util.Scanner;

public class Menu {
    Plan plan;

    int amountOfInstantes;
    int amountOfBugs;
    int amountOfDevelopers;
    int menuOption;

    Scanner menuScanner = new Scanner(System.in);

    public Menu() {
        this.plan = new Plan();
    }

    public void setInstants() {
        do {

            System.out.println("Digite a quantidade de instantes que deseja simular: ");
            amountOfInstantes = menuScanner.nextInt();
            System.out.println();

            if (amountOfInstantes < 0) {
                System.out.println("A quantidade de instantes deve ser maior que 0!");
                System.out.println();
            }

        } while (amountOfInstantes < 0);
    }

    public void setAmountOfBugs() {
        if (plan.emptyCells == 0) {

            System.out.println("Não há mais células vazias para criar bugs!");
            System.out.println();
            return;

        } else {

            do {

                System.out.println("Digite a quantidade de bugs que deseja simular: ");
                System.out.println("Quantidade de células vazias: " + plan.emptyCells);
                amountOfBugs = menuScanner.nextInt();
                System.out.println();

                if (amountOfBugs < 0) {
                    System.out.println("A quantidade de bugs deve ser maior que 0!");
                    System.out.println();
                }

                if (amountOfBugs > plan.emptyCells) {
                    System.out.println("A quantidade de bugs deve ser menor que a quantidade de células vazias!");
                    System.out.println();
                }

            } while (amountOfBugs < 0 && amountOfBugs > plan.emptyCells);

            plan.createBugs(amountOfBugs);
        }
    }

    public void showOptions() {
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Simular mais uma vez");
            System.out.println("2 - Sair");
            System.out.println();

            menuOption = menuScanner.nextInt();

            if (menuOption != 1 && menuOption != 2) {
                System.out.println("Opção inválida! Tente novamente!");
                System.out.println();
            }

        } while (menuOption != 1 && menuOption != 2);
    }

    public void setAmountOfDevelopers() {
        if (plan.emptyCells == 0) {

            System.out.println("Não há mais células vazias para criar desenvolvedores!");
            System.out.println();
            return;

        } else {

            do {

                System.out.println("Digite a quantidade de desenvolvedores que deseja simular: ");
                System.out.println("Quantidade de células vazias: " + plan.emptyCells);
                amountOfDevelopers = menuScanner.nextInt();
                System.out.println();

                if (amountOfDevelopers < 0) {
                    System.out.println("A quantidade de desenvolvedores deve ser maior que 0!");
                    System.out.println();
                }

                if (amountOfDevelopers > plan.emptyCells) {
                    System.out.println("A quantidade de desenvolvedores deve ser menor que a quantidade de células vazias!");
                    System.out.println();
                }

            } while (amountOfDevelopers < 0 && amountOfDevelopers > plan.emptyCells);

            plan.createDevelopers(amountOfDevelopers);
        }

    }

    public void showMenu() {
        System.out.println("Bem vindos ao sistema JavaLar!");

        do {

            setInstants();
            setAmountOfBugs();
            setAmountOfDevelopers();

            plan.simulate(amountOfInstantes);

            showOptions();

            plan.updateCells();

        } while (menuOption != 2);
    }
}
