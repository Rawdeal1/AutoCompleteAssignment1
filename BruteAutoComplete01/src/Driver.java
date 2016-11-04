/*
 * this is the main driver class
 */

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;



public class Driver {
	
	private BruteAutoComplete1 auto;
	private Scanner input;
	private Stopwatch stopwatch;
	
	public static void main(String[] arg)
	{
		new Driver();
	}
	
	public Driver()
	{
		input = new Scanner(System.in);
		try {
			auto = new BruteAutoComplete1();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		mainMenu();
	}
	
	private int displayMenu()
	{
		System.out.println("1) Weight Of Term");
		System.out.println("2) Best Match");
		System.out.println("3) Specify how many Matches");
		System.out.println("0) Exit");
		
		System.out.print(">>");
		return input.nextInt();
	}
	
	void mainMenu()
	{
		//asks the user for input and sends it to the bestMatch method
		
		int option = displayMenu();
		
		while (option != 0 )
		{
			switch(option)
			{
			case 1:
				System.out.print("Term >>");
				String term = input.next().trim().toLowerCase();
				stopwatch = new Stopwatch();
				System.out.println(auto.weightOf(term.trim().toLowerCase()));
				System.out.println("Time: "+stopwatch.elapsedTime());
				break;
			case 2:
				System.out.print("Prefix >>");
				String prefix = input.next().trim().toLowerCase();
				stopwatch = new Stopwatch();
				System.out.println(auto.bestMatch(prefix.trim().toLowerCase()));
				System.out.println("Time: "+stopwatch.elapsedTime());
				break;
			case 3:
				System.out.print("Term >>");
				String prefix1 = input.next().trim().toLowerCase();
				System.out.println("k times >>");
				int k = input.nextInt();
				
				Iterator<String> it = auto.matches(prefix1,k).iterator();
				stopwatch = new Stopwatch();
				while(it.hasNext())
						{
							System.out.println(it.next() + " \n ");
						}
				System.out.println("Time: "+stopwatch.elapsedTime());
				break;
			default:
					System.out.println("ERROR WRONG COMMAND");
				break;
			}
			
			//Scanner fix Buffer clear
			input.nextLine();
			
			option = displayMenu();
		}
		
		System.out.println("Goodbye!");
		System.exit(0);
	}
}
