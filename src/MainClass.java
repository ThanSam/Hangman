import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Menu menu = new Menu();
		Game Hangman;
		Statistics Stats = new Statistics();
		char choice;
		
		
		while(true)
		{	
			menu.viewMenu();
			
			choice = menu.selectChoice(in);
			if(choice=='N')
			{
				Hangman = new Game();
				Hangman.Guesses(in);
				
				Stats.addResult(Hangman.returnResult());
				
			}
			else if(choice=='S')
			{
				Stats.printStatistics();
			}
			else if(choice=='E') break;
		}	
		
		in.close();
	}
}
