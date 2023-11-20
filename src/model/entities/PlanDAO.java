package model.entities;

import java.sql.Connection;

import controller.entities.plan.Plan;
import controller.entities.planets.Planet;

import model.Connector;

public class PlanDAO {

  public void insertPlan(Plan plan) {

    try {
      Connection connection = new Connector().getConnection();
      StringBuilder bugString = new StringBuilder();
      StringBuilder devString = new StringBuilder();
      StringBuilder velocityString = new StringBuilder();
      StringBuilder daysString = new StringBuilder();
      StringBuilder yearsString = new StringBuilder();

      StringBuilder bugValues = new StringBuilder();
      StringBuilder devValues = new StringBuilder();
      StringBuilder velocityValues = new StringBuilder();
      StringBuilder daysValues = new StringBuilder();
      StringBuilder yearsValues = new StringBuilder();

      String bugsInQuadrantsString = "bug_q1, bug_q2, bug_q3, bug_q4";
      String devsInQuadrantsString = "dev_q1, dev_q2, dev_q3, dev_q4";

      StringBuilder bugsInQuadrantsValues = new StringBuilder();
      StringBuilder devsInQuadrantsValues = new StringBuilder();

      for (int i = 0; i < plan.getPlanets().size(); i++) {

        Planet planet = plan.getPlanets().get(i);

        if (i == 0) {
          bugString.append("bug_" + planet.getSlug());
          devString.append("dev_" + planet.getSlug());
          velocityString.append("v_" + planet.getSlug());
          daysString.append("d_" + planet.getSlug());
          yearsString.append("a_" + planet.getSlug());

          bugValues.append(planet.getNumberOfBugsCollisions());
          devValues.append(planet.getNumberOfDevsCollisions());
          velocityValues.append(planet.getVelocity());
          daysValues.append(planet.getTime().getPassedHours());
          yearsValues.append(planet.getNumberOfTranslations());
        } else {
          bugString.append(", bug_" + planet.getSlug());
          devString.append(", dev_" + planet.getSlug());
          velocityString.append(", v_" + planet.getSlug());
          daysString.append(", d_" + planet.getSlug());
          yearsString.append(", a_" + planet.getSlug());

          bugValues.append(", " + planet.getNumberOfBugsCollisions());
          devValues.append(", " + planet.getNumberOfDevsCollisions());
          velocityValues.append(", " + planet.getVelocity());
          daysValues.append(", " + planet.getTime().getPassedHours());
          yearsValues.append(", " + planet.getNumberOfTranslations());
        }
      }

      plan.getTelescope().observeAlignements(plan.getBugs(), plan.getDevelopers());

      bugsInQuadrantsValues.append(plan.getTelescope().getBugsInFirstQuadrant() + ", ");
      bugsInQuadrantsValues.append(plan.getTelescope().getBugsInSecondQuadrant() + ", ");
      bugsInQuadrantsValues.append(plan.getTelescope().getBugsInThirdQuadrant() + ", ");
      bugsInQuadrantsValues.append(plan.getTelescope().getBugsInFourthQuadrant());

      devsInQuadrantsValues.append(plan.getTelescope().getDevsInFirstQuadrant() + ", ");
      devsInQuadrantsValues.append(plan.getTelescope().getDevsInSecondQuadrant() + ", ");
      devsInQuadrantsValues.append(plan.getTelescope().getDevsInThirdQuadrant() + ", ");
      devsInQuadrantsValues.append(plan.getTelescope().getDevsInFourthQuadrant());

      String sql = "INSERT INTO javalar (nome, matricula, nome_arquivo, " + bugString + ", " + devString + ", "
          + velocityString
          + ", "
          + daysString + ", " + yearsString + ", " + bugsInQuadrantsString + ", " + devsInQuadrantsString + ") "
          + "VALUES ('José Vanderlei Furtuna Tomé', 554397, '" + plan.getInstant().getFileName() + "', " + bugValues
          + ", "
          + devValues + ", " + velocityValues
          + ", " + daysValues + ", " + yearsValues
          + ", " + bugsInQuadrantsValues + ", " + devsInQuadrantsValues + ")";

      connection.prepareStatement(sql).execute();

      // JOptionPane.showMessageDialog(null, "Relatório inserido com sucesso!",
      // "Sucesso",
      // JOptionPane.INFORMATION_MESSAGE);

      System.out.println("Requesição realizada com sucesso!");

      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}