package system.tools;

import system.plan.Position;
import system.planets.Planet;
import java.util.ArrayList;

public class Satellites {

	public static boolean isPositionsEqual(Position position01, Position position02) {

		if (position01.getX() == position02.getX() && position01.getY() == position02.getY()) {

			return true;
		}

		return false;
	}

	public static void calculeAreaAndDistanceBetweenPositions(ArrayList<Planet> planets) {

		for (int i = 0; i < planets.size() - 1; i++) {
			for (int j = i + 1; j < planets.size(); j++) {
				Planet planet01 = planets.get(i);
				Planet planet02 = planets.get(j);

				if (planet01.getVelocity() > 0 && planet02.getVelocity() > 0 && !planet01.equals(planet02)) {
					Position position01 = planet01.getPosition();
					Position position02 = planet02.getPosition();

					int area = calculateArea(position01, position02);
					double distance = calculateEuclideanDistance(position01, position02);

					String formatedDistance = String.format("%.2f", distance);

					System.out.println(planet01.getName() + " e " + planet02.getName());
					System.out.println("Área: " + area + " unidades de área");
					System.out.println("Distância: " + formatedDistance + " unidades de distância");
					System.out.println();
				}
			}
		}
	}

	private static double calculateEuclideanDistance(Position position1, Position position2) {
		return Math
				.sqrt(Math.pow(position1.getX() - position2.getX(), 2) + Math.pow(position1.getY() - position2.getY(), 2));
	}

	private static int calculateArea(Position position1, Position position2) {
		return Math.abs((position1.getX() - position2.getX()) * (position1.getY() - position2.getY()));
	}

}
