import java.util.Scanner;
import java.util.Random;

public class Game {

	private String Word;
	private char[] guesses; //The array of user's guesses.
	private Dictionary dict;
	private int attempts;
	private char letter; 
	private int correctGuesses;
	private int wrongGuesses;
	private char result;
 
	
	public Game() {
		
		Word = "";
		
		dict = new Dictionary();
		selectWord();
		
		letter = ' ';
		
		//Initialization of guesses array.
		guesses = new char[Word.length()];
		for(int i=0;i<Word.length();i++) guesses[i] = '-';
		
		correctGuesses = 0;
		wrongGuesses = 0;
		
		result = ' ';
		
	}
	
	public void selectWord() {	
		
		Random rnd = new Random();
		
		int num = rnd.nextInt(50);
		Word = dict.getWord(num);

	}
	
	public void Guesses(Scanner in) {
		
		for(attempts=8;attempts>0;attempts--)
		{	

			System.out.print("The random word is now: ");
			for(int j=0;j<Word.length();j++) System.out.print(guesses[j]);
				 
			System.out.println("\nYou have " + attempts + " guesses left.");
			System.out.print("Your guess: ");
			while(true)
			{
				letter = in.next().charAt(0);
				if(Character.isLetter(letter)) break;
				else System.out.print("Please insert letter: ");
			}
			letter = Character.toUpperCase(letter);
			
			if(Word.indexOf(letter) == -1)
			{
				System.out.println("There are no " +  letter + "’s in the word.");
				wrongGuesses++;
			}
			else 
			{
				System.out.println("The guess is CORRECT!");
				correctGuesses++;
				attempts++;
				addGuessedLetter();
			
				if(scanForWin()) 
					{	
						System.out.println("Congratulations! You guessed the word: " + Word);
						System.out.println("You made " + correctGuesses + " correct guesses and " + wrongGuesses + " wrong guesses.");
						result = 'V';
						break;
					}
			}	
		}
		if(attempts == 0) 
			{	
				System.out.println("You ran out of attempts! Game over!");
				System.out.println("You made " + correctGuesses + " correct guesses and " + wrongGuesses + " wrong guesses.");
				result = 'D';
			}
	}
	
	public boolean scanForWin() {
	//Checks if user guessed the word.
	
		char[] word = Word.toCharArray();

		if(word.length != guesses.length) return false;
		else
		{	for(int i=0;i<word.length;i++) 
				{ if(word[i] != guesses[i]) return false; }
		}
		
		return true;
	}
	
	public void addGuessedLetter() {
	//Adds a correct guessed character in the array of guesses.
	
		int pos = Word.indexOf(letter);
		while(pos != -1) 		//Checks if a character appears more than once.
		{
			guesses[pos] = letter;
			pos++;
			pos = Word.indexOf(letter,pos); 
		}
	}	
	
	public char returnResult() { 
	
		return result;
	}
}
