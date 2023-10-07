package system.plan;

import java.util.ArrayList;

import system.enums.ElementType;
import system.modifiers.Bug;
import system.modifiers.Developer;
import system.planets.C;
import system.planets.CPlusPlus;
import system.planets.CSharp;
import system.planets.JavaScript;
import system.planets.PHP;
import system.planets.Planet;
import system.planets.Python;
import system.planets.RubyOnRails;
import system.stars.Java;
import system.tools.AligmentsSatellite;
import system.tools.Display;
import system.tools.Satellites;

public class Plan {
	public Java java = new Java();

	public Cell[][] cells = new Cell[16][17];

	public ArrayList<Planet> planets = new ArrayList<>();
	public ArrayList<Bug> bugs = new ArrayList<>();
	public ArrayList<Developer> developers = new ArrayList<>();
	public int numberOfAlignments;

	public int emptyCells;

	public Plan() {
		setCells();
		setStar();
		setPlanets();
		updateEmptyCellValue();
	}

	public void simulate(int instantes) {
		movePlanets(instantes);
		checkAlignment();
		updateCells();
		showPlanInformation();
		updateEmptyCellValue();
	}

	public void setStar() {

		for (Position position : java.getPositions()) {
			cells[position.getX()][position.getY()].setElement(java);
		}
	}

	public void setPlanets() {
		planets.add(new Python());
		planets.add(new JavaScript());
		planets.add(new RubyOnRails());
		planets.add(new PHP());
		planets.add(new CSharp());
		planets.add(new CPlusPlus());
		planets.add(new C());

		for (Planet planet : planets) {
			cells[planet.getPosition().getX()][planet.getPosition().getY()].setElement(planet);
		}
	}

	public void setCells() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 17; j++) {
				cells[i][j] = new Cell(new Position(i, j));
			}
		}
	}

	// public void updateCells() {
	// for (Cell[] columnCell : cells) {
	// for (Cell cell : columnCell) {
	// for (Planet planet : planets) {

	// if (Satellites.isPositionsEqual(cell.getPosition(),
	// planet.getPreviousPosition())) {
	// if (cell.isOcuppied() && cell.getElementType() == ElementType.PLANET) {
	// cell.deleteElement();
	// }
	// }

	// if (Satellites.isPositionsEqual(cell.getPosition(), planet.getPosition())) {

	// if (cell.isOcuppied()) {

	// ElementType elementType = cell.getElementType();

	// if (elementType == ElementType.DEVELOPER) {

	// planet.increaseVelocity();
	// developers.remove(cell.getElement());

	// } else if (elementType == ElementType.BUG) {

	// planet.decreaseVelocity();
	// bugs.remove(cell.getElement());
	// }
	// }

	// if (planet.getVelocity() > 0) {
	// cell.setElement(planet);
	// } else {
	// cell.deleteElement();
	// }

	// }
	// }
	// }
	// }
	// updateEmptyCellValue();
	// }

	public void updateCells() {
		for (Cell[] columnCell : cells)
			for (Cell cell : columnCell)
				for (Planet planet : planets) {

					ElementType elementType = cell.getElementType();

					if (Satellites.isPositionsEqual(cell.getPosition(), planet.getPreviousPosition())
							&& cell.isOcuppied() && elementType == ElementType.PLANET)
						cell.deleteElement();

					if (Satellites.isPositionsEqual(cell.getPosition(), planet.getPosition())) {
						if (cell.isOcuppied()) {

							if (elementType == ElementType.DEVELOPER) {
								planet.increaseVelocity();
								developers.remove(cell.getElement());
							} else if (elementType == ElementType.BUG) {
								planet.decreaseVelocity();
								bugs.remove(cell.getElement());
							}
						}
						cell.setElement(planet);
						if (planet.getVelocity() <= 0)
							cell.deleteElement();
					}
				}
		updateEmptyCellValue();
	}

	public void updateEmptyCellValue() {
		this.emptyCells = (17 * 16);

		for (Cell[] columnCells : cells) {
			for (Cell cell : columnCells) {
				if (cell.isOcuppied()) {
					this.emptyCells--;
				}
			}
		}
	}

	public void movePlanets(int numberOfInstant) {
		for (Planet planet : planets) {
			planet.movePlanet(numberOfInstant);
		}
	}

	public void createBugs(int amountOfBugs) {
		for (int i = 0; i < amountOfBugs; i++) {
			Position randomPosition = new Position();

			while (cells[randomPosition.getX()][randomPosition.getY()].getElement() != null) {
				randomPosition = new Position();
			}

			Bug bug = new Bug(randomPosition);
			bugs.add(bug);
			cells[randomPosition.getX()][randomPosition.getY()].setElement(bug);

		}
		updateEmptyCellValue();
	}

	public void createDevelopers(int amountOfDevelopers) {
		for (int i = 0; i < amountOfDevelopers; i++) {
			Position randomPosition = new Position();

			Cell randomCell = cells[randomPosition.getX()][randomPosition.getY()];

			while (randomCell.isOcuppied()) {
				randomPosition = new Position();
				randomCell = cells[randomPosition.getX()][randomPosition.getY()];
			}

			Developer developer = new Developer(randomPosition);
			developers.add(developer);
			randomCell.setElement(developer);
		}
		updateEmptyCellValue();
	}

	public void showPlanInformation() {
		Display.showCells(cells);
		Display.showPlanetsInformation(planets);
		Display.showPlanetsOnPoles(planets);
		Display.showAreasAndDistances(planets);
		Display.showAlignments(numberOfAlignments);
		Display.showAmountOfBugs(bugs);
		Display.showAmountOfDevelopers(developers);
	}

	private void checkAlignment() {
		if (AligmentsSatellite.checkAlignments(planets)) {
			numberOfAlignments++;
		}
	}
}
