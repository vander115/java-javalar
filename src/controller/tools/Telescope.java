package controller.tools;

import java.util.ArrayList;

import controller.entities.modifiers.Bug;
import controller.entities.modifiers.Developer;
import controller.entities.plan.Position;

public class Telescope {
  private int bugsInFirstQuadrant;
  private int bugsInSecondQuadrant;
  private int bugsInThirdQuadrant;
  private int bugsInFourthQuadrant;

  private int devsInFirstQuadrant;
  private int devsInSecondQuadrant;
  private int devsInThirdQuadrant;
  private int devsInFourthQuadrant;

  public Telescope() {
    bugsInFirstQuadrant = 0;
    bugsInSecondQuadrant = 0;
    bugsInThirdQuadrant = 0;
    bugsInFourthQuadrant = 0;

    devsInFirstQuadrant = 0;
    devsInSecondQuadrant = 0;
    devsInThirdQuadrant = 0;
    devsInFourthQuadrant = 0;
  }

  public void observeAlignements(ArrayList<Bug> bugs, ArrayList<Developer> devs) {
    countBugsInQuadrant(bugs);
    countDevsInQuadrant(devs);
  }

  public void countBugsInQuadrant(ArrayList<Bug> bugs) {

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
  }

  public void countDevsInQuadrant(ArrayList<Developer> devs) {

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
  }

  public int getBugsInFirstQuadrant() {
    return bugsInFirstQuadrant;
  }

  public int getBugsInSecondQuadrant() {
    return bugsInSecondQuadrant;
  }

  public int getBugsInThirdQuadrant() {
    return bugsInThirdQuadrant;
  }

  public int getBugsInFourthQuadrant() {
    return bugsInFourthQuadrant;
  }

  public int getDevsInFirstQuadrant() {
    return devsInFirstQuadrant;
  }

  public int getDevsInSecondQuadrant() {
    return devsInSecondQuadrant;
  }

  public int getDevsInThirdQuadrant() {
    return devsInThirdQuadrant;
  }

  public int getDevsInFourthQuadrant() {
    return devsInFourthQuadrant;
  }

}
