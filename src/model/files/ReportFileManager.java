package model.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;

public class ReportFileManager {

	File file;
	String directoryPath = "src/output/";
	String fileName = "Relatório Javalar.txt";

	public void createReportFile(String content) {

		file = new File(directoryPath, fileName);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(content);

			writer.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void saveReportFile() {
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setDialogTitle("Escolher diretório de saída");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int option = fileChooser.showSaveDialog(null);

		if (option == JFileChooser.APPROVE_OPTION) {
			File destinationDirectory = fileChooser.getSelectedFile();

			File destinationFile = new File(destinationDirectory, file.getName());

			try {
				Files.move(file.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				file = null;
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public boolean isFileExists() {
		return file != null && file.exists();
	}
}
