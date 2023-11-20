package controller.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ReportFileManager {
  public void createReportFile(String content) {
    String directoryPath = "src/output/";
    String fileName = "report.txt";

    File file = new File(directoryPath, fileName);

    try {
      if (!file.exists()) {
        file.createNewFile();
      }

      BufferedWriter writer = new BufferedWriter(new FileWriter(file));

      writer.write(content);

      writer.close();

      System.out.println("Arquivo criado com sucesso!" + file.getAbsolutePath());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
