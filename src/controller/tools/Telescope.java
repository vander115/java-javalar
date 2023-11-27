package controller.tools;

import java.util.ArrayList;

import controller.entities.modifiers.Bug;
import controller.entities.modifiers.Developer;
import controller.entities.plan.Position;

public class Telescope {

	public static int countBugsInQuadrant(ArrayList<Bug> bugs, int quadrant) {

		int bugsInFirstQuadrant = 0;
		int bugsInSecondQuadrant = 0;
		int bugsInThirdQuadrant = 0;
		int bugsInFourthQuadrant = 0;

		for (Bug bug : bugs) {

			Position bugPosition = bug.getPosition();

			int x = bugPosition.getX();
			int y = bugPosition.getY();

			if (x >= 8 && y >= 8) {
				bugsInFirstQuadrant++;
			} else if (x >= 8 && y <= 6) {
				bugsInSecondQuadrant++;
			} else if (x >= 6 && y >= 6) {
				bugsInThirdQuadrant++;
			} else if (x <= 6 && y >= 8) {
				bugsInFourthQuadrant++;
			}
		}

		switch (quadrant) {
		case 1:
			return bugsInFirstQuadrant;
		case 2:
			return bugsInSecondQuadrant;
		case 3:
			return bugsInThirdQuadrant;
		case 4:
			return bugsInFourthQuadrant;
		default:
			return 0;
		}
	}

	public static int countDevsInQuadrant(ArrayList<Developer> devs, int quadrant) {

		int devsInFirstQuadrant = 0;
		int devsInSecondQuadrant = 0;
		int devsInThirdQuadrant = 0;
		int devsInFourthQuadrant = 0;

		for (Developer dev : devs) {

			Position devPosition = dev.getPosition();

			int x = devPosition.getX();
			int y = devPosition.getY();

			if (x >= 8 && y >= 8) {
				devsInFirstQuadrant++;
			} else if (x >= 8 && y <= 6) {
				devsInSecondQuadrant++;
			} else if (x >= 6 && y >= 6) {
				devsInThirdQuadrant++;
			} else if (x <= 6 && y >= 8) {
				devsInFourthQuadrant++;
			}
		}

		switch (quadrant) {
		case 1:
			return devsInFirstQuadrant;
		case 2:
			return devsInSecondQuadrant;
		case 3:
			return devsInThirdQuadrant;
		case 4:
			return devsInFourthQuadrant;
		default:
			return 0;
		}
	}

}
