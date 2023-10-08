package system.tools;

import java.util.ArrayList;

import system.enums.ElementType;
import system.planets.Planet;
import system.plan.Cell;
import system.modifiers.*;

public class Radar {
  public static void showCells(Cell[][] cells) {
    System.out.println("\u001B[1m-- PLANO --\u001B[0m");
    for (int i = 15; i >= 0; i--) {
      for (int j = 0; j < 17; j++) {
        ElementType type = cells[i][j].getElementType();

        switch (type) {
          case EMPTY:
            System.out.print(" * ");
            break;
          case DEVELOPER:
            System.out.print("\u001B[32m / \u001B[0m");
            break;
          case STAR:
            System.out.print("\u001B[31m 0 \u001B[0m");
            break;
          case PLANET:
            System.out.print("\u001B[33m x \u001B[0m");
            break;
          case BUG:
            System.out.print("\u001B[35m o \u001B[0m");
            break;
        }
      }
      System.out.println();
    }
  }

  public static void showAmountOfBugs(ArrayList<Bug> bugs) {

    System.out.println("\u001B[1m-- INFORMAÇÕES DOS BUGS --\u001B[0m");
    System.out.println("- Quantidade: " + bugs.size());
    System.out.println("- Posições: ");
    for (Bug bug : bugs) {
      System.out.print("(" + bug.getPosition().getX() + ", " + bug.getPosition().getY() + ") ");
    }
    System.out.println();
  }

  public static void showAmountOfDevelopers(ArrayList<Developer> developers) {
    System.out.println();
    System.out.println("\u001B[1m-- INFORMAÇÕES DOS DESENVOLVEDORES --\u001B[0m");
    System.out.println("- Quantidade: " + developers.size());
    System.out.println("- Posições: ");
    for (Developer developer : developers) {
      System.out.print("(" + developer.getPosition().getX() + ", " + developer.getPosition().getY() + ") ");
    }
    System.out.println("\n");
  }

  public static void showPlanetsInformation(ArrayList<Planet> planets) {
    System.out.println();
    System.out.println("\u001B[1m-- INFORMAÇÕES DOS PLANETAS --\u001B[0m");
    for (Planet planet : planets) {
      planet.showPlanet();
    }
    System.out.println();
  }

  public static void showAreasAndDistances(ArrayList<Planet> planets) {
    System.out.println();
    System.out.println("\u001B[1m--ÁREA E DISTÂNCIA ENTRE OS PLANETAS--\u001B[0m");
    Satellite.calculeAreaAndDistanceBetweenPositions(planets);
    System.out.println();
  }

  public static void showPlanetsOnPoles(ArrayList<Planet> planets) {
    int planetOnNorth = Satellite.checkNorthPole(planets);
    int planetOnSouth = Satellite.checkSouthPole(planets);

    System.out.println();
    System.out.println("\u001B[1m-- NORTE / SUL --\u001B[0m");
    System.out.println("- Planetas no Norte: " + planetOnNorth);
    System.out.println("- Planetas no Sul: " + planetOnSouth);
    System.out.println();
  }

  public static void showAlignments(int numberOfAlignments) {
    System.out.println();
    System.out.println("\u001B[1m-- ALINHAMENTOS --\u001B[0m");
    System.out.println("Quantidade de alinhamentos: " + numberOfAlignments);
    System.out.println();
  }

  public static void showPlanReport(ArrayList<Planet> planets, int amountOfInstants) {
    System.out.println();
    System.out.println("\u001B[1m-- RELATÓRIO DO SISTEMA --\u001B[0m");
    System.out.println("Total de Instantes: " + amountOfInstants + "\n");
    for (Planet planet : planets) {
      planet.showPlanetReport();
    }
    System.out.println("Área total entre os planetas: " + Satellite.calculateTotalArea(planets) + " unidades de área");
    System.out.println();
  }
}