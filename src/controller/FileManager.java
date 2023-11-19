package controller;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManager {

  File file;

  public FileManager() {

  }

  public void openFile() throws IOException {
    JFileChooser fileChooser = new JFileChooser();

    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
    fileChooser.setFileFilter(filter);

    int response = fileChooser.showOpenDialog(null);

    if (response == JFileChooser.APPROVE_OPTION) {
      file = fileChooser.getSelectedFile();
    }
  }

  public List<String> readFile() throws IOException {
    try {
      openFile();
      List<String> lines = Files.readAllLines(file.toPath());
      return lines;
    } catch (IOException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
