package project1;


/**
 * Specifications on the design of operations of a Bag. 
 * @author Chi Ting Lu
 * @version 1.0 
 */
public interface BagInterface {
	
	
	/**
   * Adds an item to the end of the list of this bag.
   * @param item A reference to this added data
   * @throws BagException If a ADT bag is full when a new item is inserted
   */
  public void insert(Object item) throws BagException;
  
  /**
   * Removes the item at the end of this bag.
   * @throws BagException If size() is 0
   */
  public void removeLast()  throws BagException;
  
  /**
   * Removes an item at a random index from this bag.
   * @throws BagException If size() is 0
   */
  public void removeRandom()  throws BagException;
  
  /**
   * Gets the index of the first occurrence of an item from this bag.
   * @param item A reference to the data we want to get
   * @return the index of the first occurrence of the item
   * @throws BagException If size() is 0 or there is no item in the bag.
   */
  public int get(Object item) throws BagException;
  
  /**
   * Gets a reference to an item at position index of this bag.
   * @param the index of the list
   * @return item A reference to the data we want to get
   * @throws BagIndexOutOfBoundsException If index < 0 or index > size()-1
   * @throws BagException If size() is 0
   */
  public Object get(int index) throws BagIndexOutOfBoundsException,BagException;
  
  /**
   * Returns how many items are there in this bag. 
   * @return An integer specifying how many items are there in this bag
   */
  public int size();

 /**
  * Determines whether this bag is empty. 
  * @return A boolean value specifying if this bag is empty or not
  */
  public boolean isEmpty();
  
  /**
   * Empty this bag.
   */
  public void makeEmpty();

  
  }
