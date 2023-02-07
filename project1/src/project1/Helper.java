package project1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Contains helper methods the Bag. 
 * @author Chi Ting Lu
 * @version 1.0 
 */
public class Helper {
	/**
	 * Demonstrates and tests the Bag.
	 * @throws BagException If size() == 0
	 * @throws BagIndexOutOfBoundsException If index < 0 or index > count-1
	 * @throws FileNotFoundException if a file is not found
	 */
	public static void start() throws FileNotFoundException, BagIndexOutOfBoundsException, BagException{
		
		BagArray bag = new BagArray();
		
	   //Create a bag
		create(bag);

	   //Display a bag
		System.out.println("Display the bag:");
		display(bag);
		System.out.println("-----------");
	
		//Remove first data
		System.out.println("Remove first data:");
		bag.removeLast();
		display(bag);
		System.out.println("-----------");
		
		//Insert new data
		System.out.println("Insert new data: Yogurt");
		bag.insert("Yogurt");
		display(bag);
		System.out.println("-----------");
		
		//Test get method
		System.out.println("get index of Orange:");
		System.out.println(bag.get("Orange"));
		System.out.println("-----------");
		
		//Test get method
		System.out.println("get item on index 2:");
		System.out.println(bag.get(2));
		System.out.println("-----------");
		
		//Test size() method
		System.out.println("get size of bag:");
		System.out.println(bag.size());
		System.out.println("-----------");
		
		//Test isEmpty() method
		System.out.println("check bag is empty:");
		System.out.println(bag.isEmpty());
		System.out.println("-----------");
		
		//Remove all of the data
		System.out.println("remove all of the data:");
		bag.makeEmpty();
		display(bag);
		System.out.println("-----------");
		
		//Test isEmpty() method
		display(bag);
		System.out.println("check bag is empty:");
		System.out.println(bag.isEmpty());
		System.out.println("-----------");
		
	}
	
	/**
	 * Creates a bag and put test data into the bag.
	 * @param bag A reference to a bag of data
	 */
	private static void create(BagArray bag) throws FileNotFoundException{
		Scanner input = new Scanner(new File("datalist.txt"));
		//Apple Pear Orange Milk Bread
	
		while(input.hasNext()){
			bag.insert(input.next()); 
	    }
		input.close();
	}
	
	/**
	 * Displays data in order. 
	 * @param bag A reference to a bag of data
	 * @throws BagException if size() == 0
	 * @throws BagIndexOutOfBoundsException If index < 0 or index > count-1
	 */
	private static void display(BagArray bag) throws BagIndexOutOfBoundsException, BagException{
	   for(int i = 0; i < bag.size(); i++){
		   System.out.println(bag.get(i));
	   }
	}

}