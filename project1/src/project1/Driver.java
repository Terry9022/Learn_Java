package project1;

import java.io.FileNotFoundException;
/**
 * Demonstrates the use of Bag.
 * @author Chi Ting Lu
 * @version 1.0 
 */
public class Driver {
	/**
	 * Tests the Bag.
	 * @param args A reference to a string array that can store command-line arguments
	 * @throws BagException If count == 0
	 * @throws BagIndexOutOfBoundsException If index < 0 or index > count-1
	 * @throws FileNotFoundException if a file is not found
	 */
	public static void main(String[] args) throws FileNotFoundException, BagIndexOutOfBoundsException, BagException{
		Helper.start();
	}
}