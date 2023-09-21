package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Planet[] createPlanets() {

		Planet python = new Planet("Python", 1, 4, 24.0);
		Planet javaScript = new Planet("JavaScript", 2, 3, 10.0);
		Planet rubyOnRails = new Planet("Ruby on Rails", 3, 2, 48.0);
		Planet php = new Planet("PHP", 4, 2, 60.0);
		Planet ccharp = new Planet("C#", 5, 1, 4.0);
		Planet cpp = new Planet("C++", 6, 2, 0.5);
		Planet c = new Planet("C", 7, 10, 0.1);

		Planet planets[] = { python, javaScript, rubyOnRails, php, ccharp, cpp, c };

		return planets;
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
