package controller.tools;

public class Utils {

  public static String getPlanetName(int index) {
    switch (index) {
      case 1:
        return "Python";
      case 2:
        return "JavaScript";
      case 3:
        return "Ruby On Rails";
      case 4:
        return "PHP";
      case 5:
        return "C#";
      case 6:
        return "C++";
      case 7:
        return "C";
      default:
        return null;
    }
  }
}