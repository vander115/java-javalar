package system.plan;

import java.util.ArrayList;

import system.enums.ElementType;
import system.modifiers.*;
import system.planets.*;
import system.stars.Java;
import system.tools.Satellites;

public class Plan {
    public Java java = new Java();

    public Cell[][] cells = new Cell[16][17];

    public ArrayList<Planet> planets = new ArrayList<>();
    public ArrayList<Bug> bugs = new ArrayList<>();
    public ArrayList<Developer> developers = new ArrayList<>();

    public int emptyCells;

    public Plan() {
        setCells();
        setStar();
        setPlanets();

        updateEmpytCellValue();
    }

    public void simulate(int instantes) {
        movePlanets(instantes);
        updateCells();
        showCells();
        showPlanInformations();
        showAreasAndDistances();
    }

    private void updateEmpytCellValue() {
        this.emptyCells = (17 * 16);

        for (Cell[] columnCells : cells) {
            for (Cell cell : columnCells) {
                if (cell.isOcuppied()) {
                    this.emptyCells--;
                }
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

    public void setCells() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 17; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
    }

    public void updateCells() {
        for (Cell[] columnCell : cells) {
            for (Cell cell : columnCell) {
                for (Planet planet : planets) {

                    if (Satellites.isPositionsEqual(cell.getPosition(), planet.getPreviousPosition()))
                        cell.deleteElement();

                    if (Satellites.isPositionsEqual(cell.getPosition(), planet.getPosition())) {

                        if (cell.isOcuppied()) {

                            ElementType elementType = cell.getElement().verifyElementType();

                            if (elementType == ElementType.DEVELOPER) {

                                planet.increaseVelocity();
                                developers.remove(cell.getElement());

                            } else if (elementType == ElementType.BUG) {

                                planet.decreaseVelocity();
                                bugs.remove(cell.getElement());
                            }
                        }

                        if (planet.getVelocity() > 0) {
                            cell.setElement(planet);
                        } else {
                            cell.deleteElement();
                        }
                    }
                }
            }
        }
        updateEmpytCellValue();
    }

    public void movePlanets(int numberOfInstant) {
        for (Planet planet : planets) {
            planet.movePlanet(numberOfInstant);
        }
        updateCells();
    }

    public void createBugs(int amountOfBugs) {
        for (int i = 0; i < amountOfBugs && bugs.size() < emptyCells; i++) {

            Position randomPosition = new Position();

            Cell randomCell = cells[randomPosition.getX()][randomPosition.getY()];

            while (randomCell.isOcuppied()) {
                randomPosition = new Position();
                randomCell = cells[randomPosition.getX()][randomPosition.getY()];
            }

            Bug bug = new Bug(randomPosition);
            bugs.add(bug);
            randomCell.setElement(bug);
        }

        updateCells();
    }

    public void createDevelopers(int amountOfDevelopers) {
        for (int i = 0; i < amountOfDevelopers && developers.size() < emptyCells; i++) {
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
        updateCells();
    }

    public void showCells() {
        for (int i = 15; i >= 0; i--) {

            for (int j = 0; j < 17; j++) {

                if (cells[i][j].getElement() == null) {

                    System.out
                            .print(" * ");

                } else if (cells[i][j].getElement().verifyElementType() == ElementType.DEVELOPER) {

                    System.out
                            .print("\u001B[32m / \u001B[0m");

                } else if (cells[i][j].getElement().verifyElementType() == ElementType.STAR) {

                    System.out
                            .print("\u001B[31m 0 \u001B[0m");

                } else if (cells[i][j].getElement().verifyElementType() == ElementType.PLANET) {

                    System.out
                            .print("\u001B[33m x \u001B[0m");

                } else if (cells[i][j].getElement().verifyElementType() == ElementType.BUG) {

                    System.out.print("\u001B[35m o \u001B[0m");

                }
            }

            System.out.println();

        }

    }

    public void showPlanInformations() {
        showAmountOfBugs();
        showAmountOfDevelopers();
        showPlanetsInformations();
    }

    public void showAmountOfBugs() {
        System.out.println("Quantidade de bugs: " + bugs.size());
    }

    public void showAmountOfDevelopers() {
        System.out.println("Quantidade de desenvolvedores: " + developers.size());
    }

    public void showPlanetsInformations() {
        System.out.println("\n INFORMAÇÕES DOS PLANETAS \n");
        for (Planet planet : planets) {
            planet.showPlanet();
        }
    }

    public void showAreasAndDistances() {
        System.out.println("\n ÁREA E DISTÂNCIA ENTRE OS PLANETAS \n");
        Satellites.calculeAreaAndDistanceBetweenPositions(planets);
    }
}
