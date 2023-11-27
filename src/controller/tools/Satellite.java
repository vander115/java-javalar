package controller.tools;

import java.util.ArrayList;

import controller.entities.modifiers.Bug;
import controller.entities.modifiers.Developer;
import controller.entities.plan.Cell;
import controller.entities.plan.Position;
import controller.entities.planets.Planet;
import controller.enums.ElementType;

public class Satellite {

	public static boolean isPositionsEqual(Position position01, Position position02) {
		return position01.getX() == position02.getX() && position01.getY() == position02.getY();
	}

	public static void checkPlanetExploded(Planet planet, Cell cell) {
		if (planet.isAlive()) {
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

		if (Satellite.isPositionsEqual(cell.getPosition(), planet.getPosition()) && planet.isAlive()) {
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
}
