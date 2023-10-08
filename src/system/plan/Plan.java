package system.plan;

import java.util.ArrayList;

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
    public Cell[][] cells = new Cell[16][17];

    public Java java = new Java();
    public ArrayList<Planet> planets = new ArrayList<>();
    public ArrayList<Bug> bugs = new ArrayList<>();
    public ArrayList<Developer> developers = new ArrayList<>();

    public int amountOfInstants;
    public int numberOfAlignments;
    public int emptyCells;

    public Plan() {
        setCells();
        setStar();
        setPlanets();
        updateEmptyCellValue();

        amountOfInstants = 0;
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

    public void updateCells() {

        for (Cell[] columnCell : cells)
            for (Cell cell : columnCell)
                for (Planet planet : planets)
                    Satellites.checkCollisionBetweenElements(cell, planet, developers, bugs);

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

    public void movePlanets(int numberOfInstant) {

        for (Planet planet : planets) {
            planet.movePlanet(numberOfInstant);
        }

        amountOfInstants += numberOfInstant;
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

    public void showPlanInformation() {
        Display.showCells(cells);
        Display.showPlanetsInformation(planets);
        Display.showPlanetsOnPoles(planets);
        Display.showAreasAndDistances(planets);
        Display.showAlignments(numberOfAlignments);
        Display.showAmountOfBugs(bugs);
        Display.showAmountOfDevelopers(developers);
    }

    public void showPlanReport() {
        Display.showPlanReport(planets, amountOfInstants);
    }

    private void checkAlignment() {
        if (AligmentsSatellite.checkAlignments(planets)) {
            numberOfAlignments++;
        }
    }
}
