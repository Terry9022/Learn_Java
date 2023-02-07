package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Tests the design of Address Book. 
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Helper_AddressBook {
	/**
	 * Tests the Address Book. 
	 * @param args A reference to an command-line arguments
	 * @throws FileNotFoundException if there is no such file
	 */
	public static void start() throws FileNotFoundException{
		
		AddressBook list = new AddressBook();
		//Fill the address book. 
		create(list);
		//Display the address book. 
		display(list);
		 
		}
	/**
	 * Creates the Address Book and read the test data to fill the Address Book. 
	 * @param list A reference to the address book. 
	 * @throws FileNotFoundException if there is no such file
	 */
	private static void create(AddressBook list) throws FileNotFoundException{
		 
		Scanner input = new Scanner(new File("testdata.txt")).useDelimiter("\n");;
		
		input.next();  // skip row header
		while(input.hasNext()){
			String[] arr = input.next().split("\t");
			
			Address address = new Address(arr[2],arr[3],arr[4],arr[5]);
			Contact contact = new Contact(arr[0]+" "+arr[1],address,arr[6]);
			list.insert(contact);
	    }
		input.close();
	}
	
	/**
	 * Display the Address Book and test methods of the Address Book. 
	 * @param list A reference to the address book. 
	 */
	private static void display(AddressBook list){
		
		System.out.println("The AddressBook is empty or not : "+list.isEmpty());
		
		Contact contact_test = new Contact("James Butt",new Address("6649 N Blue Gum St","New Orleans","LA","70116"),"504-621-8927");
		System.out.println("The AddressBook has this contact or not : "+list.search(contact_test));
		list.delete(contact_test);
		System.out.println("After deleting, the AddressBook has this contact or not : "+list.search(contact_test));
		
		System.out.println();
		System.out.println("Find all contacts in the same zip code 12204 :");
		LinkedList<Contact> listZip = list.findContactZip("12204");
		while(!listZip.isEmpty()) {
			System.out.println(listZip.remove());
		}
		System.out.println();
		
		System.out.println("Find all contacts in the same city New York :");
		LinkedList<Contact> listCity = list.findContactCity("New York");
		while(!listCity.isEmpty()) {
			System.out.println(listCity.remove());
		}
		System.out.println();
		
		System.out.println("Find all contacts whose phone numbers have the same area code 215 :");
		LinkedList<Contact> listAreaCode = list.findContactAreaCode("215");
		while(!listAreaCode.isEmpty()) {
			System.out.println(listAreaCode.remove());
		}
		System.out.println();
		
		list.makeEmpty();
		System.out.println("After deleting everything, the AddressBook is empty or not : "+list.isEmpty());
		
		  
	}
	
}
