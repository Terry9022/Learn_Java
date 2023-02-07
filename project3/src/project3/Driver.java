package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
  * Demonstrates the use of the Expression class.
  * @author Chi-Ting Lu
  * @version 1.0
  */

public class Driver {
	/**
	 * Tests the Expression class.
	 * @param args A reference to a string array that can store command-line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		// Create a scanner object to read the input file.
		Scanner input = new Scanner(new File("testdata.txt"));
		while(input.hasNext()){
			
			// as long as there are more infix expressions, read one infix at a time, make an expression object.
			Expression curr = new Expression(input.nextLine());
			System.out.println("Infix: "+curr.getInfix());
			
			// use the object reference to call the infix to postfix method and evaluate method. And print the results.
			System.out.println("Result: "+curr.evaluate());
		}
		input.close();
	
		
		
	}
}