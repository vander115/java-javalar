package principal;

import principal.planets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Planet planets[] = createPlanets();

        System.out.println("Quantos instantes de tempo você quer passar?");
        int amount = scanner.nextInt();

        for (int i = 0; i < planets.length; i++) {
            planets[i].showPlanet();
            planets[i].movePlanet(amount);
            planets[i].showPlanet();
        }

        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < planets.length; i++) {
            positions.add(planets[i].getPosition());
        }

        System.out.println("Quantos bugs você quer?");
        amount = scanner.nextInt();
        int i = 0;
        while (i < amount) {
            int randomX = (int) Math.random() * 16;
            int randomY = (int) Math.random() * 17;

            for (int j = 0; j < positions.size(); j++) {

            }
        }

        scanner.close();
    }

}
