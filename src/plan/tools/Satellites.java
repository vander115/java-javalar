package plan.tools;

import java.util.List;

import plan.modifiers.Bug;
import plan.planets.Planet;

public class Satellites {

	public static boolean isPositionsEqual(Position position01, Position position02) {

		if (position01.getX() == position02.getX() && position01.getY() == position02.getY()) {

			return true;
		}

		return false;
	}

	public static boolean checkPositionOccupied(Position position, List<Position> ocupiedPositionList) {

		for (Position ocupiedPosition : ocupiedPositionList) {

			if (isPositionsEqual(ocupiedPosition, position)) {
				return true;
			}
		}

		return false;
	}

	public static void checkCollision(List<Bug> bugs, List<Planet> planets) {

		for (Planet planet : planets) {

			for (int i = 0; i < bugs.size(); i++) {

				if (isPositionsEqual(planet.getPosition(), bugs.get(i).getPosition())) {
					planet.changeVelocity(bugs.get(i).getModifierValue());
					bugs.remove(i);
				}

			}
		}
	}

}
