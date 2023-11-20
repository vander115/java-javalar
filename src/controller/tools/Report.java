package controller.tools;

import controller.entities.Student;
import controller.files.ReportFileManager;
import model.entities.ReportDAO;

public class Report {
  private ReportDAO reportDAO = new ReportDAO();
  private ReportFileManager fileManager = new ReportFileManager();

  public Student getStudentProcessedMostInstants() {
    return reportDAO.getStudentProcessedMostInstants();
  }

  public String getPlanetDiedMost() {
    return reportDAO.getPlanetDiedMost();
  }

  public int getQuadrantWhereBugsMostConcentrated() {
    return reportDAO.getQuadrantWhereBugsMostConcentrated();
  }

  public int getQuadrantWhereDevsMostConcentrated() {
    return reportDAO.getQuadrantWhereDevsMostConcentrated();
  }

  public int getAmountOfInstantsAnalyzed() {
    return reportDAO.getAmountOfInstantsAnalyzed();
  }

  public int getAmountOfHoursPassed() {
    return reportDAO.getAmountOfHoursPassed();
  }

  public int getAmountOfYearsPassed() {
    return reportDAO.getAmountOfYearsPassed();
  }

  public int getAmoutOfBugsOccurrences() {
    return reportDAO.getAmoutOfBugsOccurrences();
  }

  public int getAmoutOfDevsOccurrences() {
    return reportDAO.getAmoutOfDevsOccurrences();
  }

  public double[] getAvarageVelocityOfPlanets() {
    return reportDAO.getAvarageVelocityOfPlanets();
  }

  public String getPlanetThatHasMoreLife() {
    return reportDAO.getPlanetThatHasMoreLife();
  }

  public void registerReport() {
    StringBuilder content = new StringBuilder();

    Student student = getStudentProcessedMostInstants();

    content.append(student.getEnrollment() + " - " + student.getName());
    content.append(", " + getPlanetDiedMost());
    content.append(", " + getPlanetThatHasMoreLife());
    content.append(", " + getQuadrantWhereBugsMostConcentrated());
    content.append(", " + getQuadrantWhereDevsMostConcentrated());
    content.append(", " + getAmountOfInstantsAnalyzed());

    double[] avarageVelocity = getAvarageVelocityOfPlanets();

    for (int i = 0; i < avarageVelocity.length; i++) {
      String planetName = Utils.getPlanetName(i + 1);
      String expression = planetName + ": " + String.format("%.2f", avarageVelocity[i]);
      if (i == 0) {
        content.append(", " + expression);
      } else {
        content.append(" - " + expression);
      }
    }

    content.append(", " + getAmoutOfBugsOccurrences());
    content.append(", " + getAmoutOfDevsOccurrences());
    content.append(", " + getAmountOfHoursPassed());
    content.append(", " + getAmountOfYearsPassed());

    fileManager.createReportFile(content.toString());
  }

}
