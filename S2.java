import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* Multiple Choice (S2)
 * Ameya Sindgikar
 * CCC 2011
 * March 1, 2011
 */

public class S2 
{
	//global variables
	static String fileName = "";
	static String studentAns[];
	static String correctAns[];
	static int rightAnswers = 0;
	
	public static void main (String args[]) throws IOException //main method
	{
		Scanner sc = new Scanner (new FileReader(fileName));
		int numInputs = sc.nextInt();
		
		//make two arrays of the same size, one for student answers, other for correct answers
		studentAns = new String [numInputs];
		correctAns = new String [numInputs];
		
		Scanner ab = new Scanner (new FileReader(fileName));
		ab.nextLine(); //skip the first line as it has an int
		
		for (int i=0; i<numInputs; i++) //add the student answers to the array
		{
			studentAns[i] = ab.nextLine();
			//System.out.print(studentAns[i]); //for testing
		}
		
		
		for (int i=0; i<numInputs; i++) //add the correct answers to the array
		{
			correctAns[i] = ab.nextLine();
			//System.out.print(correctAns[i]); //for testing
		}
		
		for (int i=0; i<numInputs; i++)
		{
			if (studentAns[i].equalsIgnoreCase(correctAns[i])) //check if the student answer matches the correct answers
			{
				rightAnswers = rightAnswers+1;
			}
		}
		
		//System.out.println (rightAnswers); //for testing
		outputAnswer(); //call method to output answer in a file
	}
	
	public static void outputAnswer () throws IOException
	{
		//print answer in a file
		PrintWriter pw = new PrintWriter (new FileWriter (fileName));
	    pw.println(rightAnswers);
	    pw.close();
	}

}
