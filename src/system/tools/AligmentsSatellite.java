package system.tools;

import system.planets.Planet;
import java.util.ArrayList;

public class AligmentsSatellite {

  public static boolean checkNorthAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {
      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 8 + index || y != 8) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkSouthAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {

      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 7 - index || y != 8) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkNorthWestAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {

      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 8 + index || y != 7 - index) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkSouthWestAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {

      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 7 - index || y != 7 - index) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkNorthEastAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {

      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 8 + index || y != 9 + index) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkSouthEastAlignment(ArrayList<Planet> planets) {

    for (Planet planet : planets) {

      int x = planet.getPosition().getX();
      int y = planet.getPosition().getY();
      int index = planet.getIndex().getValue();

      if (x != 7 - index || y != 9 + index) {
        return false;
      }
    }

    return true;
  }

  public static boolean checkAlignments(ArrayList<Planet> planets) {

    if (checkNorthAlignment(planets)) {
      return true;
    }

    if (checkSouthAlignment(planets)) {
      return true;
    }

    if (checkNorthWestAlignment(planets)) {
      return true;
    }

    if (checkSouthWestAlignment(planets)) {
      return true;
    }

    if (checkNorthEastAlignment(planets)) {
      return true;
    }

    if (checkSouthEastAlignment(planets)) {
      return true;
    }

    return false;
  }

}