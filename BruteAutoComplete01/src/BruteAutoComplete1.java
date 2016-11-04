import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This class will do the Autocomplete bruteforce methods
 * 
 * @author seankearney
 *
 */
public class BruteAutoComplete1 implements AutoComplete{
	private ArrayList<Term> words;
	private Scanner input;
	private Stopwatch stopwatch;
	

	public BruteAutoComplete1() throws FileNotFoundException
	{
		stopwatch = new Stopwatch();
		//loads the userfile from the location on my computer and adds them to an arraylist using scanner
		input = new Scanner(System.in);
		File usersFile = new File("C:/Users/seankearney/Documents/Workspace/BruteAutoComplete1/data/userdata.txt");
		  Scanner inWords = new Scanner(usersFile);
		  words= new ArrayList<Term>();
		  String delims = "[	]"; //Seperates feilds by tab.
		  while (inWords.hasNextLine()) {
		    // Gets the word from the arraylist
		    String word = inWords.nextLine();
		    //gets the other half of the fields that where seperated
		    String[] termArray = word.split(delims);
		    //assigns the weight and words to a variable
		    if (termArray.length > 1) {
		      double weight = Double.parseDouble(termArray[0]);
		      words.add(new Term(weight,termArray[1]));
		    }
		  }
		  //Sorts the words by weight
		  Collections.sort(words, new Comparator<Term>(){
			@Override
			public int compare(Term t1, Term t2) {
				return (int) (t2.getWeight()-t1.getWeight());
			}});
		  System.out.println("Loading in takes : "+ stopwatch.elapsedTime());		  
	}
	
	
	/**
	 * This method will return the weight of the input term.
	 */
	public double weightOf(String term) {
		//checks arraylist if anything starts with term and returns the weight
		for(Term storeWord:words)
			if(storeWord.getWord().equals(term))
				return storeWord.getWeight();
		return 0;
	}

	public String bestMatch(String prefix) {
		//checks arraylist if anything starts with term and adds it to the result string.
		for(Term word : words)
		{
			if(word.getWord().startsWith(prefix))
				return word.getWord();
		}
		return null;
	}

	@Override
	public Iterable<String> matches(String prefix, int k) {
		//finds every word that starts with the users input and adds them to an arraylist called result
		//also takes in a value from the user (k) and adds a word to the list k times
		List<String> result = new ArrayList<String>();
		
		for(Term storeWord:words)
			if(storeWord.getWord().startsWith(prefix) && k > 0)
			{
				result.add(storeWord.getWord());
				k--;
			}
		return result;
	}
}
