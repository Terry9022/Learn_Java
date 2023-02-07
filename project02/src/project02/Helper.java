package project02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
	
/**
 * Helper class for the driver program. 
 * Tests the design of PriorityQueue.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Helper {
	/**
	 * Tests the PriorityQueue.
	 * @throws FileNotFoundException if there is no such file
	 */
	public static void start() throws FileNotFoundException{
	
		//	Create an empty priority queue and save its reference. We use EmployeeNameComparator as Comparator here.
		GenericPriorityQueue<Employee> queue = new GenericPriorityQueue<Employee>(new EmployeeNameComparator());
		//  Pass the reference to create method.
		create(queue);
		
		//	Pass the reference to display method.
		System.out.println("We use EmployeeNameComparator as Comparator here.");
		System.out.println("The Employee Objects in the queue after inserting test data:");
		display(queue);
		System.out.println("-----------------------------");
		
		//	Sort the queue. (minHeap is used to sort in descending order) and display the queue again.
		System.out.println("After heapsort:");
		queue.sort();
		display(queue);
		System.out.println("-----------------------------");
		
		//	Rebuild the heap to maintain the heap properties.
		System.out.println("Rebuild the heap:");
		queue.heapify();
		display(queue);
		System.out.println("-----------------------------");
		
		//	Delete from the queue and display the queue again.
		System.out.println("Test deleting the root which has the smallest item:");
		System.out.println("Smallest is: " + queue.delete());
	    System.out.println("Next smallest is: " + queue.delete());
	    System.out.println("-----------------------------");
	    System.out.println("The Employee Objects in the queue after deleting some data:");
		display(queue);
		System.out.println("The PriorityQueue is or not: "+ queue.isEmpty());
		System.out.println("-----------------------------");
		
		//	Delete everything from the queue and display the queue again.
		while(!queue.isEmpty()) {
			queue.delete();
		}
		System.out.println("The Employee Objects in the queue after deleting everything:");
		display(queue);
		System.out.println("After deleting everything, the AddressBook is empty or not : "+queue.isEmpty());
		System.out.println("-----------------------------");

	
		// Test priority queue and this time we use EmployeePayrateComparator as Comparator here.
		System.out.println("*****************************");
		System.out.println("-----------------------------");
		System.out.println("This time we use EmployeePayrateComparator as Comparator here.");
		queue = new GenericPriorityQueue<Employee>(new EmployeePayrateComparator());
		//  Pass the reference to create method.
		create(queue);
		
		//	Pass the reference to display method.
		System.out.println("The Employee Objects in the queue after inserting test data:");
		display(queue);
		System.out.println("-----------------------------");
		//	Sort the queue. (minHeap is used to sort in descending order) and display the queue again.
		System.out.println("After heapsort:");
		queue.sort();
		display(queue);
		System.out.println("-----------------------------");
		
		//	Rebuild the heap to maintain the heap properties.
		System.out.println("Rebuild the heap:");
		queue.heapify();
		display(queue);
		System.out.println("-----------------------------");
		
		//	Delete from the queue and display the queue again.
		System.out.println("Test deleting the root which has the smallest item:");
		System.out.println("Smallest is: " + queue.delete());
	    System.out.println("Next smallest is: " + queue.delete());
	    System.out.println("-----------------------------");
	    System.out.println("The Employee Objects in the queue after deleting some data:");
		display(queue);
		System.out.println("The PriorityQueue is or not: "+ queue.isEmpty());
		System.out.println("-----------------------------");
		//	Delete everything from the queue and display the queue again.
		while(!queue.isEmpty()) {
			queue.delete();
		}
		System.out.println("The Employee Objects in the queue after deleting everything:");
		display(queue);
		System.out.println("After deleting everything, the AddressBook is empty or not : "+queue.isEmpty());
		System.out.println("-----------------------------");
	}
	
	/**
	 * Creates the PriorityQueue and read the test data to insert into the PriorityQueue. 
	 * @param queue A reference to the PriorityQueue. 
	 * @throws FileNotFoundException if there is no such file
	 */
	private static void create(GenericPriorityQueue<Employee> queue) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("testdata.txt")).useDelimiter("\n");;
		
		input.next();  // skip row header
		while(input.hasNext()){
			String[] arr = input.next().split("\t");
			// Make employee objects from the testing data in a file.
			Employee empolyee = new Employee(arr[0], Float.parseFloat(arr[1]));
			// Insert the employee objects into the queue.
			queue.insert(empolyee);
	    }
		input.close();
	}
	
	/**
	 * Display the PriorityQueue.
	 * @param queue A reference to a PriorityQueue
	 */
	private static void display(GenericPriorityQueue<Employee> queue){
		// Displays objects in the queue.
		// Use the print method in the heap class to print every Object in the ArrayList in index order
		queue.print();
		
	}
}
