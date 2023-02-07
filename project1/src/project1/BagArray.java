package project1;

import java.util.*;

/**
 * Implementations of operations of a Bag. 
 * @author Chi Ting Lu
 * @version 1.0 
 *
 */
public class BagArray implements BagInterface{
	/**
	 * A reference to an array of data
	 */
	private Object[] data;
	
	/**
	 * The number of data in this ADT list
	 */
	private int count;
	
	/**
	 * The maximum number of data in this bag
	 */
	public static final int Max_size = 100;

	/**
	 * Constructor with no parameters - creates a new, empty ArrayBag with the default maximum size.
	 */
	public BagArray(){
		this.data = new Object[Max_size];
		this.count = 0;
	}
	 
	  /**
	   * Adds an item to the end of the list of this bag.
	   * @param item A reference to this added data
	   * @throws BagException If a ADT bag is full when a new item is inserted
	   */
	  public void insert(Object item) throws BagException{
		  if( this.count > Max_size ){
			  throw new BagException("A ADT bag is full when a new item is inserted");
		  }else{
			  this.data[this.count] = item;
			  this.count++;
		  }
	  }
	  
	  /**
	   * Removes the item at the end of this bag.
	   * @throws BagException If count is 0
	   */
	  public void removeLast() throws BagException{
		  if( this.count == 0 ){
			  throw new BagException("A ADT bag is empty when trying to remove");
		  }else{
			  this.data[this.count-1]=null;
			  this.count--;
		  }
	  }
	  
	  /**
	   * Removes an item at a random index from this bag.
	   * @throws BagException If count is 0
	   */
	  public void removeRandom() throws BagException{
		  if( this.count == 0 ){
			  throw new BagException("A ADT bag is empty when trying to remove");
		  }else{
			  // create instance of Random class
		      Random rand = new Random();
		      // Generate random integers in range 0 to count-1
		      int rand_int = rand.nextInt(this.count);
		      // Shift the remaining items left by one.
		      for (int i = rand_int; i < this.count - 1; i++) {
                  this.data[i] = this.data[i + 1];
              }
		      
			  this.data[this.count-1]=null;
			  this.count--;
		  }
	  }
	  
	  /**
	   * Gets the index of the first occurrence of an item from this bag.
	   * @param item A reference to the data we want to get
	   * @return the index of the first occurrence of the item
	   * @throws BagException If count is 0 or there is no item in the bag.
	   */
	  public int get(Object item) throws BagException{
		  boolean contains = false;
		  int index = 0;
		  if( this.count == 0 ){
			  throw new BagException("There is no element in a empty bag.");
		  }else{
			  for (int i = 0; i < this.count; i++) {
		            if (this.data[i].equals(item)) {
		            	contains = true;
		            	index = i;
		            	return index;
		            }
			  	}
			  if(!contains) {
				  throw new BagException("There is no item in this bag.");
			  } 
		  }
		  return index;

	  }
	  
	  /**
	   * Gets a reference to an item at position index of this bag.
	   * @param the index of the list
	   * @return item A reference to the data we want to get
	   * @throws BagIndexOutOfBoundsException If index < 0 or index > count-1
	   * @throws BagException If count is 0
	   */
	  public Object get(int index) throws BagIndexOutOfBoundsException,BagException{
		  if(this.count == 0){
			  throw new BagException("The list is empty, and no elements can be removed.");
		  }else if(index < 0 || index > this.count-1){
			  throw new BagIndexOutOfBoundsException("The index value must be between 0 and " + (this.count-1));
		  }else{
			  // return an items at index from this list.
			  return this.data[index];
		  }
	  }
	  
	  /**
	   * Returns how many items are there in this bag. 
	   * @return An integer specifying how many items are there in this bag
	   */
	  public int size() {
		  return this.count;
	  }
	
	 /**
	  * Determines whether this bag is empty. 
	  * @return A boolean value specifying if this bag is empty or not
	  */
	  public boolean isEmpty(){
		  return this.count == 0;
	  }
	  
	  /**
	   * Empty this bag.
	   */
	  public void makeEmpty() {
		  this.data = new Object[100];
		  this.count = 0;
	  }

	
}




