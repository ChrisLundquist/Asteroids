
public class HighScoreTester {
	public static void main(String[] args) {
		


		HighScores hs = new HighScores(); // This will load the high score file and give us a highscore object
		hs.printScores();
		
		int score = 1000000;
		

		hs.newScore(score);
		
		hs.printScores();
		
		
		hs.displayScoreDialog(); // Show high score list
		
		hs.printScores();
		hs.writeScoreFile();



	}
}