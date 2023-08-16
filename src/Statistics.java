public class Statistics {
	
	private int totalGames;
	private int victories;
	private int defeats;
	
	public Statistics() {
	
		totalGames = 0;
		victories = 0;
		defeats = 0;
	}
	
	public void addResult(char result) {
	
		if(result == 'V') victories++;
		else if(result == 'D') defeats++;
		
		totalGames++;
	}
	
	public void printStatistics() {
	
		System.out.println("You have played so far " + totalGames 
						+ " games. You won "+ victories 
						+ " times and lost " + defeats +" times.");
	}
}
