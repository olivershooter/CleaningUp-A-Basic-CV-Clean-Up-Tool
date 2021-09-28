package com.bham.pij.assignments.candidates;
//Oliver Shooter 2244190

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 1) Create cleancv.txt by parsing dirtycv.txt (make sure each field is
// separated via commas)
// 2) cleancv.txt should then provide a file to-interview.txt for the criteria provided
// (^ this isn't separated via commas)
// 3) to-interview-experience.txt then needs to be made from to-interview.txt which determines their individual experience

//submission: provide a zip with java source files and/or txt/csv files

public class CleaningUp {

	public void cleanUpFile() {
		try {
			File dirtyCVFile = new File("dirtycv.txt");
			Scanner dirtyCVScanner = new Scanner(dirtyCVFile);
			File cleanCVFile = new File("cleancv.txt");
			FileWriter cleanCVWriter = new FileWriter(cleanCVFile);
			if (cleanCVFile.exists()) {
				cleanCVFile.delete();
			}
			cleanCVFile.createNewFile();
			int i = 1;
			while (dirtyCVScanner.hasNextLine()) {
				String data = dirtyCVScanner.nextLine();
				if (data.contains(":")) {
					if (data.split(":")[0].equals("Surname")) {
						cleanCVWriter.write(data.split(":")[1] + String.format("%04d", i++) + ",");
					} else {
						cleanCVWriter.write(data.split(":")[1] + ",");
					}
				} else if (data.equals("End") && dirtyCVScanner.hasNextLine()) {
					cleanCVWriter.write("\n");
				}
			}
			dirtyCVScanner.close();
			cleanCVWriter.close();
		} catch (

		IOException e) {
			System.out.println("File is not found");
			e.printStackTrace();
		}

	}
}