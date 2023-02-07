package project02;

import java.util.Comparator;

/**
 * Implementations of operations of a PriorityQueue. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public class GenericPriorityQueue<E> implements GenericPriorityQueueInterface<E>{

	 /**
	  * The Heap in the PriorityQueue which operates the methods
	  */
	  private GenericHeap<E> heap;
	  
	 /**
	  * Constructs a PriorityQueue with specific comparator. 
	  */
	  public GenericPriorityQueue(Comparator<? super E> comparator) {
	    this.heap = new GenericHeap<E>(comparator);
	  }
	  
	 /**
	  * Constructs a PriorityQueue without a comparator, and we'll use objects’ natural ordering as default. 
	  */
	  public GenericPriorityQueue() {
	    this.heap = new GenericHeap<E>();
	  }
	  
	/**
	  * Adds an item to the end of the list of the Heap.
	  * @param item A reference to this added data
	  */
	  public void insert(E item) {
		  heap.insert(item);
	  };
	  
	 /**
	  * Retrieves and removes the item from the root of a heap.
	  * @return the item from the root of a heap.
	  */
	  public E delete() {
		  return heap.delete();
	  };

	 /**
	  * Determines whether the heap is empty. 
	  * @return A boolean value specifying if the heap is empty or not
	  */
	  public boolean isEmpty() {
		  return heap.isEmpty();
	  };
	  
	 /**
	  * Sorts the items in the heap.
	  */
	  public void sort() {
		  heap.sort();
	  };
	  
	  /**
	   * Print the items in the heap in order
	   */
	  public void print() {
		heap.print();
	  };
	  
	  /**
	   * Rebuild a heap to maintain the heap properties.
	   */
	  public void heapify() {
		 heap.heapify();
	  };


}
