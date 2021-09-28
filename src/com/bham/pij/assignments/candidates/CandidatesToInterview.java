package com.bham.pij.assignments.candidates;
//Oliver Shooter 2244190

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CandidatesToInterview {

	private static final String[] keywordsDegree = { "Degree in Computer Science", "Masters in Computer Science" };
	private static final String[] keywordsExperience = { "Data Analyst", "Programmer", "Computer programmer",
			"Operator" };

	public void findCandidates() {

		try {
			File cleanCVFile = new File("cleancv.txt");
			Scanner cleanCVReader = new Scanner(cleanCVFile);
			File toInterviewFile = new File("to-interview.txt");
			FileWriter toInterviewWriter = new FileWriter(toInterviewFile);

			if (toInterviewFile.exists()) {
				toInterviewFile.delete();
			}

			toInterviewFile.createNewFile();

			while (cleanCVReader.hasNextLine()) {
				String candidate = cleanCVReader.nextLine();
				boolean hasDegree = false;
				boolean hasExperience = false;

				for (int i = 0; i < keywordsDegree.length; i++)
					hasDegree = hasDegree || (candidate.contains(keywordsDegree[i]));
				for (int i = 0; i < keywordsExperience.length; i++)
					hasExperience = hasExperience || (candidate.contains(keywordsExperience[i]));

				if (hasDegree && hasExperience) {
					String[] tokens = candidate.split(",");
					toInterviewWriter.write(tokens[0] + " ");
					for (int i = 3; i < tokens.length; i++)
						toInterviewWriter.write(tokens[i] + " ");
					toInterviewWriter.write("\n");
				}
			}
			cleanCVReader.close();
			toInterviewWriter.close();
		}

		catch (

		IOException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}

	}

	public void candidatesWithExperience() {

		try {
			File toInterviewFile = new File("to-interview.txt");
			Scanner toInterviewReader = new Scanner(toInterviewFile);
			File toInterviewExperienceFile = new File("to-interview-experience.txt");
			FileWriter toInterviewExperienceWriter = new FileWriter(toInterviewExperienceFile);

			if (toInterviewExperienceFile.exists()) {
				toInterviewExperienceFile.delete();
			}

			toInterviewExperienceFile.createNewFile();

			while (toInterviewReader.hasNextLine()) {
				String[] tokens = toInterviewReader.nextLine().split(" ");
				for (int i = 1; i < tokens.length; i++) {
					if (isNumeric(tokens[i])) {
						if (Integer.parseInt(tokens[i]) > 5) {
							toInterviewExperienceWriter.write(tokens[0] + " " + tokens[i] + "\n");
						}

						break;
					}

				}
			}

			toInterviewReader.close();
			toInterviewExperienceWriter.close();

		} catch (

		IOException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}
	}

	private static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
