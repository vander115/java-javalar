package system.tools;

import system.plan.Position;
import system.planets.Planet;
import system.enums.ElementType;
import system.plan.Cell;
import system.modifiers.*;

import java.util.ArrayList;

public class Satellite {

	public static boolean isPositionsEqual(Position position01, Position position02) {

		return position01.getX() == position02.getX() && position01.getY() == position02.getY();
	}


	public static double calculateEuclideanDistance(Position position1, Position position2) {
		return Math.sqrt(
				Math.pow(position1.getX() - position2.getX(), 2) + Math.pow(position1.getY() - position2.getY(), 2));
	}

	public static int calculateArea(Position position1, Position position2) {
		return Math.abs((position1.getX() - position2.getX()) * (position1.getY() - position2.getY()));
	}

	public static int checkNorthPole(ArrayList<Planet> planets) {
		int count = 0;

		for (Planet planet : planets) {
			if (planet.getPosition().getY() >= 8) {
				count++;
			}
		}

		return count;
	}

	public static int checkSouthPole(ArrayList<Planet> planets) {
		int count = 0;

		for (Planet planet : planets) {
			if (planet.getPosition().getY() <= 7) {
				count++;
			}
		}

		return count;
	}

	public static void checkPlanetExploded(Planet planet, Cell cell) {
		if (planet.getVelocity() > 0) {
			cell.setElement(planet);
		} else {
			cell.deleteElement();
		}
	}

	public static void checkCollisionBetweenElements(Cell cell, Planet planet, ArrayList<Developer> developers,
			ArrayList<Bug> bugs) {
		ElementType elementType = cell.getElementType();

		if (Satellite.isPositionsEqual(cell.getPosition(), planet.getPreviousPosition()) && cell.checkIsOcuppied()
				&& elementType == ElementType.PLANET)
			cell.deleteElement();

		if (Satellite.isPositionsEqual(cell.getPosition(), planet.getPosition()) && planet.getVelocity() > 0) {
			if (cell.checkIsOcuppied()) {

				if (elementType == ElementType.DEVELOPER) {
					planet.collideIntoDev();
					developers.remove(cell.getElement());
				} else if (elementType == ElementType.BUG) {
					planet.collideIntoBug();
					bugs.remove(cell.getElement());
				}
			}

			Satellite.checkPlanetExploded(planet, cell);
		}
	}

	public static double calculateTotalArea(ArrayList<Planet> planets) {

		ArrayList<Position> planetsPositions = new ArrayList<>();

		for (Planet planet : planets) {
			planetsPositions.add(planet.getPosition());
		}

		int size = planetsPositions.size();
		double sum = 0;

		for (int i = 0; i < size - 1; i++) {
			sum += planetsPositions.get(i).getX() * planetsPositions.get(i + 1).getY()
					- planetsPositions.get(i + 1).getX() * planetsPositions.get(i).getY();
		}

		sum += planetsPositions.get(size - 1).getX() * planetsPositions.get(0).getY()
				- planetsPositions.get(0).getX() * planetsPositions.get(size - 1).getY();

		return Math.abs(sum) / 2.0;
	}
}
