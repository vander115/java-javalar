package controller.entities.plan;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import controller.FileManager;
import controller.entities.modifiers.Bug;
import controller.entities.modifiers.Developer;
import controller.entities.planets.C;
import controller.entities.planets.CPlusPlus;
import controller.entities.planets.CSharp;
import controller.entities.planets.JavaScript;
import controller.entities.planets.PHP;
import controller.entities.planets.Planet;
import controller.entities.planets.Python;
import controller.entities.planets.RubyOnRails;
import controller.entities.stars.Java;
import controller.tools.Satellite;

public class Plan {
	public Cell[][] cells = new Cell[15][15];

	public Java java = new Java();
	public ArrayList<Planet> planets = new ArrayList<>();
	public ArrayList<Bug> bugs = new ArrayList<>();
	public ArrayList<Developer> developers = new ArrayList<>();

	public Instant instant = new Instant();

	public int emptyCells;

	public Plan() {
		setCells();
		setStar();
		setPlanets();
		updateEmptyCellValue();
	}

	public void simulate() {
		convertInstants();
		createBugs(amountOfBugs);
		createDevelopers(amountOfDevelopers);
		movePlanets();
		updateCells();
		updateEmptyCellValue();
	}

	public void setCells() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				cells[i][j] = new Cell(new Position(i, j));
			}
		}
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

	public void createBugs(int amountOfBugs) {
		for (int i = 0; i < amountOfBugs; i++) {
			Position randomPosition = new Position();

			while (cells[randomPosition.getX()][randomPosition.getY()].checkIsOcuppied()) {
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

			while (cells[randomPosition.getX()][randomPosition.getY()].checkIsOcuppied()) {
				randomPosition = new Position();
			}

			Developer developer = new Developer(randomPosition);
			developers.add(developer);
			cells[randomPosition.getX()][randomPosition.getY()].setElement(developer);
		}
		updateEmptyCellValue();
	}

	public void movePlanets() {

		for (int i = 0; i < 7; i++) {
			for (Planet planet : planets) {
				if (planet.getIndex().getValue() == i) {
					planet.movePlanet(instant.getAmountOfInstants()[i]);
				}
			}
		}

	}

	public void updateCells() {

		for (Cell[] columnCell : cells)
			for (Cell cell : columnCell)
				for (Planet planet : planets)
					Satellite.checkCollisionBetweenElements(cell, planet, developers, bugs);

		updateEmptyCellValue();
	}

	public void updateEmptyCellValue() {
		this.emptyCells = (17 * 16);

		for (Cell[] columnCells : cells) {
			for (Cell cell : columnCells) {
				if (cell.checkIsOcuppied()) {
					this.emptyCells--;
				}
			}
		}
	}

	public Cell[][] getCells() {
		return cells;
	}

	public boolean isValuesEmpty() {
		return instant.getListOfInstants().isEmpty();
	}
}
