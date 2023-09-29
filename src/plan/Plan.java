package plan;

import plan.modifiers.Bug;
import plan.modifiers.Developer;
import plan.planets.*;

import plan.tools.Position;
import plan.tools.Satellites;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plan {

    public static List<Planet> planets = new ArrayList<>();
    public static Java java = new Java();

    public static List<Position> occupiedPositions = new ArrayList<>();
    public static List<Bug> bugs = new ArrayList<>();
    public static List<Developer> developers = new ArrayList<>();

    public static void createPlanets() {

        Planet[] planetsArray = {

                new Python(),
                new JavaScript(),
                new RubyOnRails(),
                new PHP(),
                new CCharp(),
                new CPlusPlus(),
                new C(),

        };

        planets.addAll(List.of(planetsArray));

    }

    public static void createBugs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos bugs você quer?");
        int amount = scanner.nextInt();

        while (bugs.size() < amount && bugs.size() < 259) {
            Position newPosition = new Position();

            if (Satellites.checkPositionOccupied(newPosition, occupiedPositions)) {
                // Se a posição não estiver ocupada, adiciona o bug
                bugs.add(new Bug(newPosition));
                occupiedPositions.add(newPosition);
            }
        }
        scanner.close();
    }

    public static void createDevelopers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos desenvolvedores você quer?");
        int amount = scanner.nextInt();

        while (bugs.size() < amount && bugs.size() < 259) {
            Position newPosition = new Position();

            if (Satellites.checkPositionOccupied(newPosition, occupiedPositions)) {
                // Se a posição não estiver ocupada, adiciona o bug
                bugs.add(new Bug(newPosition));
                occupiedPositions.add(newPosition);
            }
        }
        scanner.close();
    }

    public static void executeInstants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos instantes de tempo você quer passar?");
        int amount = scanner.nextInt();

        for (Planet planet : planets) {
            planet.showPlanet();
            planet.movePlanet(amount);
            planet.showPlanet();
        }

        for (Planet planet : planets) {
            occupiedPositions.add(planet.getPosition());
        }
    }

    public static void main(String[] args) {

        createPlanets();

        createBugs();

        System.out.println("Posições dos planetas");
        for (Planet planet : planets) {
            System.out.println(planet.getPosition().getX() + ", " + planet.getPosition().getY());
        }

        System.out.println("Posições dos bugs");
        for (Bug bug : bugs) {
            System.out.println(bug.getPosition().getX() + ", " + bug.getPosition().getY());
        }

    }

}
