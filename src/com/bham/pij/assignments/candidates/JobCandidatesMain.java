package com.bham.pij.assignments.candidates;
//Oliver Shooter 2244190

public class JobCandidatesMain {

	public static void main(String[] args) {

		CleaningUp cleanUp = new CleaningUp();
		cleanUp.cleanUpFile();

		CandidatesToInterview candidate = new CandidatesToInterview();
		candidate.findCandidates();

		candidate.candidatesWithExperience();
	}

}
