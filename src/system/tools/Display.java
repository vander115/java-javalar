package system.tools;

import java.util.ArrayList;

import system.enums.ElementType;
import system.planets.Planet;
import system.plan.Cell;
import system.modifiers.*;

public class Display {
  public static void showCells(Cell[][] cells) {
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
    System.out.println();
    System.out.println("INFORMAÇÕES DOS BUGS");
    System.out.println("Quantidade: " + bugs.size());
    System.out.println("Posições: ");
    for (Bug bug : bugs) {
      System.out.print("(" + bug.getPosition().getX() + ", " + bug.getPosition().getY() + ") ");
    }
  }

  public static void showAmountOfDevelopers(ArrayList<Developer> developers) {
    System.out.println();
    System.out.println("INFORMAÇÕES DOS DESENVOLVEDORES");
    System.out.println("Quantidade: " + developers.size());
    System.out.println("Posições: ");
    for (Developer developer : developers) {
      System.out.print("(" + developer.getPosition().getX() + ", " + developer.getPosition().getY() + ") ");
    }
  }

  public static void showPlanetsInformation(ArrayList<Planet> planets) {
    System.out.println("\nINFORMAÇÕES DOS PLANETAS \n");
    for (Planet planet : planets) {
      planet.showPlanet();
    }
  }

  public static void showAreasAndDistances(ArrayList<Planet> planets) {
    System.out.println("\nÁREA E DISTÂNCIA ENTRE OS PLANETAS \n");
    Satellites.calculeAreaAndDistanceBetweenPositions(planets);
  }

  public static void showPlanetsOnPoles(ArrayList<Planet> planets) {
    int planetOnNorth = Satellites.checkNorthPole(planets);
    int planetOnSouth = Satellites.checkSouthPole(planets);

    System.out.println("\nNORTE / SUL \n");
    System.out.println("Planetas no Norte: " + planetOnNorth);
    System.out.println("Planetas no Sul: " + planetOnSouth);
  }

  public static void showAlignments(int numberOfAlignments) {
    System.out.println("\nALINHAMENTOS \n");
    System.out.println("Quantidade de alinhamentos: " + numberOfAlignments);
  }

  public static void showPlanReport(ArrayList<Planet> planets, int amountOfInstants) {
    System.out.println("\nRELATÓRIO DO SISTEMA \n");
    System.out.println("Total de Instantes: " + amountOfInstants + "\n");
    for (Planet planet : planets) {
      planet.showPlanetReport();
    }
    System.out.println("Área total entre os planetas: " + Satellites.calculateTotalArea(planets) + " unidades de área");
  }
}
