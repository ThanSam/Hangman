import java.util.Scanner;

public class Menu {
		
	public void viewMenu() {  
	
		System.out.print("\nMAIN MENU\n" + 
		"- Start a new Game (N)\n" + 
		"- Statistics (S)\n" + 
		"- Exit (E)\n" + 
		"Please enter your choice: ");
	}
	
	public char selectChoice(Scanner in) { 
		
		char Choice = Character.toUpperCase(in.next().charAt(0));
		return(Choice);
	}	
}
