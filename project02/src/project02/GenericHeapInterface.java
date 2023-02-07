package project02;

/**
 * Specifications on the design of operations of a Heap. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public interface GenericHeapInterface<E> {
	
	 /**
	   * Adds an item to the end of the list of this heap.
	   * @param item A reference to this added data
	   */
	  public void insert(E item);
	  
	  /**
	   * Retrieves and removes the item from the root of a heap.
	   * @throws HeapException if the heap is empty
	   * @return the item from the root of a heap.
	   */
	  public E delete() throws HeapException;
	  
	  /**
	   * Rebuild a heap to maintain the heap properties.
	   */
	  public void heapify();

	 /**
	  * Determines whether this heap is empty. 
	  * @return A boolean value specifying if this heap is empty or not
	  */
	  public boolean isEmpty();
	  
	  /**
	   * Sorts the items in a heap using the heapsort algorithm
	   */
	  public void sort();

}
