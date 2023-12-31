package controller.entities.plan;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
import controller.tools.Report;
import controller.tools.Satellite;
import controller.tools.Telescope;
import model.entities.PlanDAO;

public class Plan implements Runnable {

	private PlanDAO planDAO = new PlanDAO();
	private Report report = new Report();

	private Cell[][] cells = new Cell[15][15];

	private Java java = new Java();

	private ArrayList<Planet> planets = new ArrayList<>();
	private ArrayList<Planet> diedPlanets = new ArrayList<>();
	private ArrayList<Bug> bugs = new ArrayList<>();
	private ArrayList<Developer> developers = new ArrayList<>();

	private Instant instant = new Instant();

	private ArrayList<Position> emptyPositions = new ArrayList<Position>();

	public Plan() {
		setCells();
		setStar();
		setPlanets();
		updateEmptyCellValue();
	}

	public void simulate() {
		instant.convertInstants();
		createBugs(instant.getAmountOfBugsToCreate());
		createDevelopers(instant.getAmountOfDevelopersToCreate());
		movePlanets();
		updateCells();
		updateEmptyCellValue();
	}

	public Instant getInstant() {
		return instant;
	}

	public Report getReport() {
		return report;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public ArrayList<Developer> getDevelopers() {
		return developers;
	}

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public ArrayList<Planet> getDiedPlanets() {
		return diedPlanets;
	}

	public boolean isValuesEmpty() {
		return instant.getListOfInstants().isEmpty();
	}

	private void setCells() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				Position newPosition = new Position(i, j);
				cells[i][j] = new Cell(newPosition);
				emptyPositions.add(newPosition);
			}
		}
	}

	private void setStar() {
		for (Position position : java.getPositions()) {
			cells[position.getX()][position.getY()].setElement(java);
		}
	}

	private void setPlanets() {
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

	private void createBugs(int amountOfBugs) {
		for (int i = 0; (i < amountOfBugs) && (emptyPositions.size() > 0); i++) {
			Position randomPosition = getRamdomPositionFromCells();

			Bug bug = new Bug(randomPosition);
			bugs.add(bug);
			cells[randomPosition.getX()][randomPosition.getY()].setElement(bug);

			updateEmptyCellValue();
		}
	}

	private void createDevelopers(int amountOfDevelopers) {
		for (int i = 0; (i < amountOfDevelopers) && (emptyPositions.size() > 0); i++) {
			Position randomPosition = getRamdomPositionFromCells();

			Developer developer = new Developer(randomPosition);
			developers.add(developer);
			cells[randomPosition.getX()][randomPosition.getY()].setElement(developer);

			updateEmptyCellValue();
		}
	}

	private void movePlanets() {
		for (int i = 1; i <= 7; i++) {
			for (Planet planet : planets) {
				if (planet.getIndex().getValue() == i) {
					planet.movePlanet(instant.getAmountOfInstants()[i - 1]);
				}
			}
		}
	}

	private void updateCells() {

		for (Cell[] columnCell : cells)
			for (Cell cell : columnCell)
				for (Planet planet : planets)
					Satellite.checkCollisionBetweenElements(cell, planet, developers, bugs);
		setDiedPlanets();
		updateEmptyCellValue();
	}

	public Position getRamdomPositionFromCells() {
		int randomPositionIndex = (int) (Math.random() * emptyPositions.size());

		return emptyPositions.get(randomPositionIndex);
	}

	public void setDiedPlanets() {
		for (Planet planet : planets) {
			if (!planet.isAlive() && !diedPlanets.contains(planet)) {
				diedPlanets.add(planet);
			}
		}
	}

	private void updateEmptyCellValue() {
		for (Cell[] columnCells : cells) {
			for (Cell cell : columnCells) {
				if (cell.checkIsOcuppied()) {
					emptyPositions.remove(cell.getPosition());
				} else {
					if (!emptyPositions.contains(cell.getPosition())) {
						emptyPositions.add(cell.getPosition());
					}
				}
			}
		}

	}

	public void insertPlan() {
		planDAO.insertPlan(this);
	}

	public int getNumberOfBugsInQuadrant(int quadrant) {
		return Telescope.countBugsInQuadrant(bugs, quadrant);
	}

	public int getNumberOfDevelopersInQuadrant(int quadrant) {
		return Telescope.countDevsInQuadrant(developers, quadrant);
	}

	public void resetPlan() {
		planets = new ArrayList<>();
		diedPlanets = new ArrayList<>();
		bugs = new ArrayList<>();
		developers = new ArrayList<>();
		emptyPositions = new ArrayList<Position>();
		instant = new Instant();
		cells = new Cell[15][15];
		report = new Report();

		setCells();
		setStar();
		setPlanets();
		updateEmptyCellValue();
	}

	@Override
	public void run() {
		try {
			insertPlan();
			JOptionPane.showMessageDialog(null, "Relatório inserido com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível salvar o plano!", "Erro",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
