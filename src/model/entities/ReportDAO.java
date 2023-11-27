package model.entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controller.entities.Student;
import model.Connector;

public class ReportDAO {

	private ResultSet getData() {
		try {
			Connection connection = new Connector().getConnection();

			String sql = "SELECT * FROM javalar";

			return connection.prepareStatement(sql).executeQuery();
		} catch (SQLException e) {
			System.out.println("Não foi possível realizar conexão com o banco de dados :(");
			e.printStackTrace();
		}

		return null;
	}

	public Student getStudentProcessedMostInstants() {

		ArrayList<Student> students = new ArrayList<Student>();

		try {
			Connection connection = new Connector().getConnection();

			String sql = "SELECT * FROM javalar";

			ResultSet resultSet = connection.prepareStatement(sql).executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("nome");
				int enrollment = resultSet.getInt("matricula");

				students.add(new Student(name, enrollment));
			}

			connection.close();

		} catch (Exception e) {
			System.out.println("Não foi possível realizar conexão com o banco de dados :(");
			e.printStackTrace();
		}

		Map<Student, Integer> countStudent = new HashMap<>();

		for (Student student : students) {
			countStudent.put(student, countStudent.getOrDefault(student, 0) + 1);
		}

		// Encontrar o aluno com maior frequência
		Student mostRepeatedStudent = null;
		int maximunFrequency = 0;

		for (Map.Entry<Student, Integer> entry : countStudent.entrySet()) {
			if (entry.getValue() > maximunFrequency) {
				maximunFrequency = entry.getValue();
				mostRepeatedStudent = entry.getKey();
			}
		}

		return mostRepeatedStudent;
	}

	public String getPlanetDiedMost() {

		ArrayList<String> diedPlanets = new ArrayList<String>();
		try {
			ResultSet results = getData();

			while (results.next()) {

				if (results.getInt("v_python") == 0)
					diedPlanets.add("Python");
				if (results.getInt("v_javascript") == 0)
					diedPlanets.add("JavaScript");
				if (results.getInt("v_ruby") == 0)
					diedPlanets.add("Ruby On Rails");
				if (results.getInt("v_php") == 0)
					diedPlanets.add("PHP");
				if (results.getInt("v_csharp") == 0)
					diedPlanets.add("C#");
				if (results.getInt("v_cmais") == 0)
					diedPlanets.add("C++");
				if (results.getInt("v_c") == 0)
					diedPlanets.add("C");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String planet : diedPlanets) {
			Integer count = map.get(planet);
			map.put(planet, (count == null) ? 1 : count + 1);
		}

		String planetName = "";
		int maxValueInMap = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxValueInMap) {
				maxValueInMap = entry.getValue();
				planetName = entry.getKey();
			}
		}

		return planetName;
	}

	public String getPlanetThatHasMoreLife() {
		try {
			ResultSet results = getData();

			int[] planets = { 0, 0, 0, 0, 0, 0, 0 };

			while (results.next()) {
				planets[0] += results.getInt("v_python");
				planets[1] += results.getInt("v_javascript");
				planets[2] += results.getInt("v_ruby");
				planets[3] += results.getInt("v_php");
				planets[4] += results.getInt("v_csharp");
				planets[5] += results.getInt("v_cmais");
				planets[6] += results.getInt("v_c");
			}

			int maxValue = 0;
			int planet = 0;

			for (int i = 0; i < planets.length; i++) {
				if (planets[i] > maxValue) {
					maxValue = planets[i];
					planet = i + 1;
				}
			}

			switch (planet) {
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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int getQuadrantWhereBugsMostConcentrated() {

		int[] quadrants = { 0, 0, 0, 0 };

		try {

			ResultSet results = getData();
			while (results.next()) {
				quadrants[0] += results.getInt("bug_q1");
				quadrants[1] += results.getInt("bug_q2");
				quadrants[2] += results.getInt("bug_q3");
				quadrants[3] += results.getInt("bug_q4");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int maxValue = 0;
		int quadrant = 0;

		for (int i = 0; i < quadrants.length; i++) {
			if (quadrants[i] > maxValue) {
				maxValue = quadrants[i];
				quadrant = i + 1;
			}
		}

		return quadrant;
	}

	public int getQuadrantWhereDevsMostConcentrated() {

		int[] quadrants = { 0, 0, 0, 0 };

		try {

			ResultSet results = getData();
			while (results.next()) {
				quadrants[0] += results.getInt("dev_q1");
				quadrants[1] += results.getInt("dev_q2");
				quadrants[2] += results.getInt("dev_q3");
				quadrants[3] += results.getInt("dev_q4");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int maxValue = 0;
		int quadrant = 0;

		for (int i = 0; i < quadrants.length; i++) {
			if (quadrants[i] > maxValue) {
				maxValue = quadrants[i];
				quadrant = i + 1;
			}
		}

		return quadrant;
	}

	public int getAmountOfInstantsAnalyzed() {
		try {
			ResultSet results = getData();

			int amountOfInstants = 0;

			while (results.next()) {
				amountOfInstants++;
			}

			return amountOfInstants;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public double[] getAvarageVelocityOfPlanets() {

		int[] amountOfVelocity = { 0, 0, 0, 0, 0, 0, 0 };
		int amountOfOcurrences = getAmountOfInstantsAnalyzed();

		try {
			ResultSet results = getData();

			while (results.next()) {
				amountOfVelocity[0] += results.getInt("v_python");
				amountOfVelocity[1] += results.getInt("v_javascript");
				amountOfVelocity[2] += results.getInt("v_ruby");
				amountOfVelocity[3] += results.getInt("v_php");
				amountOfVelocity[4] += results.getInt("v_csharp");
				amountOfVelocity[5] += results.getInt("v_cmais");
				amountOfVelocity[6] += results.getInt("v_c");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		double[] avarageVelocity = new double[amountOfVelocity.length];

		for (int i = 0; i < amountOfVelocity.length; i++) {
			avarageVelocity[i] = amountOfVelocity[i] / (double) amountOfOcurrences;
		}

		return avarageVelocity;
	}

	public int getAmoutOfBugsOccurrences() {
		try {
			ResultSet results = getData();

			int amountOfBugs = 0;

			while (results.next()) {
				amountOfBugs += results.getInt("bug_python");
				amountOfBugs += results.getInt("bug_javascript");
				amountOfBugs += results.getInt("bug_ruby");
				amountOfBugs += results.getInt("bug_php");
				amountOfBugs += results.getInt("bug_csharp");
				amountOfBugs += results.getInt("bug_cmais");
				amountOfBugs += results.getInt("bug_c");
			}

			return amountOfBugs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int getAmoutOfDevsOccurrences() {
		try {
			ResultSet results = getData();

			int amountOfDevs = 0;

			while (results.next()) {
				amountOfDevs += results.getInt("dev_python");
				amountOfDevs += results.getInt("dev_javascript");
				amountOfDevs += results.getInt("dev_ruby");
				amountOfDevs += results.getInt("dev_php");
				amountOfDevs += results.getInt("dev_csharp");
				amountOfDevs += results.getInt("dev_cmais");
				amountOfDevs += results.getInt("dev_c");
			}

			return amountOfDevs;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int getAmountOfHoursPassed() {
		try {
			ResultSet results = getData();

			int amountOfHours = 0;

			while (results.next()) {
				amountOfHours += results.getInt("d_python");
				amountOfHours += results.getInt("d_javascript");
				amountOfHours += results.getInt("d_ruby");
				amountOfHours += results.getInt("d_php");
				amountOfHours += results.getInt("d_csharp");
				amountOfHours += results.getInt("d_cmais");
				amountOfHours += results.getInt("d_c");
			}

			return amountOfHours;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int getAmountOfYearsPassed() {
		try {
			ResultSet results = getData();

			int amountOfYears = 0;

			while (results.next()) {
				amountOfYears += results.getInt("a_python");
				amountOfYears += results.getInt("a_javascript");
				amountOfYears += results.getInt("a_ruby");
				amountOfYears += results.getInt("a_php");
				amountOfYears += results.getInt("a_csharp");
				amountOfYears += results.getInt("a_cmais");
				amountOfYears += results.getInt("a_c");
			}

			return amountOfYears;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}