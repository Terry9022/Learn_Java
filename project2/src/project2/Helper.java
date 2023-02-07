package project2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Helper class for the driver program. 
 * @author Chi Ting Lu
 * @version 1.0
 */
public class Helper {
	
	/**
	 * Tests the LinkedString.
	 */
	public static void start() throws FileNotFoundException{
		
		// Creates an empty array list that can be used to store a list of LinkedString objects
		ArrayList<LinkedString> list = new ArrayList<LinkedString>();
		
		// Create a list
		// Test data: Olivia Oliver Amelia Harry Isla Jack
		create(list);

	   // Display a list and test methods of LinkedString
		displayAndMore(list);
	}
	
	/**
	 * Creates a list of LinkedString objects.
	 * @param list A reference to a array list
	 */
	private static void create(ArrayList<LinkedString> list) throws FileNotFoundException{
		
		// Use useCharArray to control whether we use strings or use character arrays to test all constructors.
		boolean useCharArray = false;
		
		Scanner input = new Scanner(new File("test.txt"));
		// Olivia Oliver Amelia Harry Isla Jack
		// Add the LinkedString objects into the array list
		while(input.hasNext()){
			if(useCharArray) {
				char[] charArray = input.next().toCharArray();
				LinkedString string = new LinkedString(charArray);
				list.add(string);
			}
			else {
				LinkedString string = new LinkedString(input.next());
				list.add(string);
			}
			// next time use String if this time we use Char array, vice versa.
			useCharArray=!useCharArray;
	    }
		input.close();
	}
	
	/**
	 * Display a list and test methods of LinkedString.
	 * @param list A reference to a array list
	 */
	private static void displayAndMore(ArrayList<LinkedString> list){
		
		// For every two adjacent Linked strings in the list, if they are not empty, we do some test on methods.
		for(int k = 0;k<list.size();k+=2) {
			LinkedString string1 = list.get(k);
			LinkedString string2 = list.get(k+1);
			if ( (!string1.isEmpty()) &&  (!string2.isEmpty())) {
			
			// Show the two adjacent Linked strings separately
			System.out.print("The string1 is ");
			printLinkedString(string1);
			System.out.print("The string2 is ");
			printLinkedString(string2);
			
			// Call length and print the returned length of each linked string.
			System.out.println("The length of string1 is "+string1.length());
			System.out.println("The length of string2 is "+string2.length());
			
			// Call charAt and print the returned first character of each linked string.
			System.out.println("The first character of string1 is "+string1.charAt(0));
			System.out.println("The first character of string2 is "+string2.charAt(0));
			
			// Call substring to get the first character and print the returned string of each linked string.
			LinkedString substring1 = string1.substring(0,1);
			LinkedString substring2 = string2.substring(0,1);
			System.out.print("The first character of substring1 is ");
			printLinkedString(substring1);
			System.out.print("The first character of substring2 is ");
			printLinkedString(substring2);
			
			// Call concat to concatenate and print the length of each concatenated linked string.
			LinkedString concatenatedString = string1.concat(string2);
			System.out.println("The length of concatenated string is "+concatenatedString.length());
			System.out.print("The concatenated string become ");
			printLinkedString(concatenatedString);
			System.out.println();
			
			}
		}
	}
	
	/**
	 * Print entire characters in a LinkedString in order. 
	 * @param string A reference to a LinkedString
	 */
	private static void printLinkedString(LinkedString string){
		for(int i = 0;i<string.length();i++) {
			System.out.print(string.charAt(i));
		}
		System.out.println();
	}
	
}