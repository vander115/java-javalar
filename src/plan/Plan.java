package plan;

import plan.modifiers.Bug;
import plan.planets.*;

import plan.tools.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plan {

    public static Planet[] createPlanets() {

        return new Planet[]{

                new Python(),
                new JavaScript(),
                new RubyOnRails(),
                new PHP(),
                new CCharp(),
                new CPlusPlus(),
                new C()

        };

    }

    public static void createBugs() {

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Planet[] planets = createPlanets();

        System.out.println("Quantos instantes de tempo você quer passar?");
        int amount = scanner.nextInt();

        for (Planet planet : planets) {
            planet.showPlanet();
            planet.movePlanet(amount);
            planet.showPlanet();
        }

        List<Position> positions = new ArrayList<>();
        List<Bug> bugs = new ArrayList<>();

        for (Planet planet : planets) {
            positions.add(planet.getPosition());
        }

        System.out.println("Quantos bugs você quer?");
        amount = scanner.nextInt();
        int i = 0;
        while (i < amount) {
            int randomX = (int) (Math.random() * 16);
            int randomY = (int) (Math.random() * 17);

            for (int j = 0; j < positions.size(); j++) {
                if (!(positions.get(j).getX() == randomX && positions.get(j).getY() == randomY)) {
                    bugs.add(new Bug(randomX, randomY));
                    positions.add(new Position(randomX, randomY));
                    i++;
                    break;
                }
            }
        }

        System.out.println("Posições dos planetas");
        for (Planet planet : planets) {
            System.out.println(planet.getPosition().getX() + ", " + planet.getPosition().getY());
        }

        System.out.println("Posições dos bugs");
        for (Bug bug : bugs) {
            System.out.println(bug.getPosition().getX() + ", " + bug.getPosition().getY());
        }

        scanner.close();
    }

}
