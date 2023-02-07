package project02;

/**
 * Specifications on the design of operations of a PriorityQueue. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public interface GenericPriorityQueueInterface<E> {
	
	 /**
	  * Adds an item to the end of the list of the Heap.
	  * @param item A reference to this added data
	  */
	  public void insert(E item);
	  
	 /**
	  * Retrieves and removes the item from the root of a heap.
	  * @return the item from the root of a heap.
	  */
	  public E delete() ;

	 /**
	  * Determines whether the heap is empty. 
	  * @return A boolean value specifying if the heap is empty or not
	  */
	  public boolean isEmpty();
	  
	  /**
	   * Sorts the items in the heap.
	   */
	  public void sort() ;

}
