package controller.entities.plan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.files.InstantFileManager;

public class Instant {

  private InstantFileManager fileManager = new InstantFileManager();

  private ArrayList<String[]> listOfInstants = new ArrayList<>();

  private int currentInstant = 0;

  private int amountOfBugsToCreate = 0;
  private int amountOfDevelopersToCreate = 0;

  private int[] amountOfInstants = new int[7];

  public void convertInstants() {
    currentInstant++;

    String[] array = listOfInstants.get(currentInstant - 1);
    int[] parsedArray = new int[array.length - 2];

    for (int i = 0; i < array.length - 2; i++) {
      parsedArray[i] = Integer.parseInt(array[i]);
    }

    amountOfBugsToCreate = parsedArray[parsedArray.length - 2];
    amountOfDevelopersToCreate = parsedArray[parsedArray.length - 1];

    System.arraycopy(parsedArray, 1, amountOfInstants, 0, 7);
  }

  public void processInstants() {

    try {
      List<String> lines = fileManager.readFile();
      lines.remove(0);

      for (String line : lines) {
        String[] lineSplited = line.split(",");
        listOfInstants.add(lineSplited);
      }

    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

  }

  public int getAmountOfBugsToCreate() {
    return amountOfBugsToCreate;
  }

  public int getCurrentInstant() {
    return currentInstant;
  }

  public int getAmountOfDevelopersToCreate() {
    return amountOfDevelopersToCreate;
  }

  public int[] getAmountOfInstants() {
    return amountOfInstants;
  }

  public ArrayList<String[]> getListOfInstants() {
    return listOfInstants;
  }

  public String getFileName() {
    return fileManager.getFileName();
  }

}
