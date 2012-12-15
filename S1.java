import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* French or English? (S1)
 * Ameya Sindgikar
 * CCC 2011
 * March 1, 2011
 */

public class S1 
{
	//global variables
	static int numT;
	static int numS;
	static String fileName = "";
	
	public static void main (String args[]) throws IOException //main method
	{
		int numInput = 0;
		Scanner sc = new Scanner (new FileReader(fileName));
		
		while(sc.hasNext()) //go through the file to find the amount of words
		{
			sc.next();
			numInput++;
		}
		//System.out.println (numInput); //for testing
		
		Scanner ab = new Scanner (new FileReader(fileName));
		for (int i=0; i<numInput; i++)
		{
			String input = ab.next(); //take each word
			splitValue(input); //and call method to find "s" and "t" in it
		}
		
		outputAnswer(); //method to output answer to a file
	}
	

	public static void splitValue (String input) //method that splits each word
	{
		for (int i=0; i<input.length(); i++)
		{
			String letter = input.substring(i, i+1);
			checkWord(letter); //send each letter to the check word method
		}
	}
	
	public static void checkWord (String letter) //method that checks if the word is "s" or "t"
	{
		if (letter.equalsIgnoreCase("T"))
		{
			numT = numT + 1;
		}
		
		if (letter.equalsIgnoreCase("S"))
		{
			numS = numS + 1;
		}
		
	}
	
	public static void outputAnswer () throws IOException
	{
		//for testing
		//System.out.println (numT);
		//System.out.println (numS); 
		
		//output answer to the file
		PrintWriter pw = new PrintWriter (new FileWriter (fileName));
	    if (numT > numS)
	    {
	    	pw.println ("English");
	    }
	    else if (numT < numS)
	    {
	    	pw.println ("French");
	    }
	    else if (numT == numS)
	    {
	    	pw.println("French");
	    }
	    
	    pw.close();
	}
}
