

public class JobCandidatesMain {

	public static void main(String[] args) {

		CleaningUp cleanUp = new CleaningUp();
		cleanUp.cleanUpFile();

		CandidatesToInterview candidate = new CandidatesToInterview();
		candidate.findCandidates();

		candidate.candidatesWithExperience();
	}

}
