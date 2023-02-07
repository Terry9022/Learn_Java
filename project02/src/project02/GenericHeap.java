package project02;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Implementations of operations of a Heap. 
 * @author Chi Ting Lu
 * @version 1.0 
 */

public class GenericHeap<E> implements GenericHeapInterface<E>{
	
	 /**
	   * The ArrayList containing the items of this heap
	   */
	  private ArrayList<E> list;
	  
	/**
	  * A comparator specifying the ordering used for organizing a list of objects in a heap.
	  */
	  private Comparator<? super E> comparator;
	  
	  /**
	   * Constructs a heap with a ArrayList and a comparator. 
	   */
	  public GenericHeap(Comparator<? super E> comparator) {
		this.list = new ArrayList<E>();
	    this.comparator = comparator;
	  }
	  
	  /**
	   * Constructs a heap with a ArrayList and a comparator 
	   * If we don't provide specific comparator, we'll use objects’ natural ordering as default. 
	   */
	  @SuppressWarnings("unchecked")
	  public GenericHeap() {
		  this.list = new ArrayList<E>();
		  this.comparator = (Comparator<? super E>) Comparator.naturalOrder();
	  }

	 /**
	   * Adds an item to the end of the list of this heap and keep list in min-heap order.
	   * @param item A reference to this added data
	   */
	  public void insert(E item) {
		list.add(item);             // add the new item at the end
	    int index = list.size()-1;  // and get its index
	    // Swap keys with the parent until parent is not smaller.
	    while (index > 0 && this.comparator.compare(list.get(index),list.get(parent(index))) < 0) {
	      swap(list, index, parent(index));
	      index = parent(index);
	    }
	  };
	  
	  /**
	   * Retrieves and removes the item from the root of a heap.
	   * @throws HeapException if the heap is empty
	   * @return the item from the root of a heap.
	   */
	  public E delete() throws HeapException{
		  if (this.isEmpty())
			  throw new HeapException("It cannot delete any item because the heap is empty.");
		    else {
		      E minVal = list.get(0);
		      list.set(0, list.get(list.size()-1)); // move last item to position 0
		      list.remove(list.size()-1);
		      minHeapify(list, 0);
		      return minVal;
		    }
	  };
	  
	  /**
	   * Rebuild a heap to maintain the heap properties.
	   */
	  public void heapify() {
		  // We call minHeapify from all leaves going upward, and then we have a min-heap.
		  // there is no need to call minHeapify on leaves
		  for (int index = (list.size() - 1) / 2; index >= 0; index--) {
			  minHeapify(this.list, index) ;
		  }
	  };

	 /**
	  * Determines whether this heap is empty. 
	  * @return A boolean value specifying if this heap is empty or not
	  */
	  public boolean isEmpty() {
		  return list.size() == 0;
	  };
	  
	  /**
	   * Sorts the items in a heap using the heapsort algorithm
	   */
	  public void sort() {
		  // Rebuild a heap to maintain the heap properties first.
		  this.heapify();
		  // I use another ArrayList to store the sorted item.
		  ArrayList<E> listSorted = new ArrayList<E>();
		  for (int i = 0; i < list.size(); i++) {
			  listSorted.add(list.get(i));
			}
		  // Heapsort algorithm (minHeap is used to sort in descending order)
		  for(int i = list.size()-1;i >= 0; i--) {
			  swap(list, 0, i);  
			  listSorted.set(i, list.get(i));
			  list.remove(i);
			  minHeapify(list, 0);
		  }
		 // Now make list equal to listSorted
		  this.list = listSorted;
	  };
	  
	  /**
	   * Print the items in the heap in index order
	   */
	  public void print() {
		  for (int i = 0; i < list.size(); i++) {
			  System.out.println(list.get(i));
		  }
	  };
	  
	  /**
	   * Restore the min-heap property.  When this method is called, the min-heap
	   * property holds everywhere, except possibly at node i and its children.
	   * When this method returns, the min-heap property holds everywhere.
	   * @param a the ArrayList holding the min-heap
	   * @param i the index of the root
	   */
	  private void minHeapify(ArrayList<E> a, int i) {
	    int left = leftChild(i);    // index of node i's left child
	    int right = rightChild(i);  // index of node i's right child
	    int smallest;   // Find the index of the smallest node of A[i] and its children.

	    // Case: if there is a left child and check whether the left child has an element smaller than node i
	    if (left <= a.size()-1 && this.comparator.compare(a.get(left),(a.get(i))) < 0)
	      smallest = left;   // yes, so the left child is the smallest among them
	    else
	      smallest = i;      // no, so node i is the smallest among them

	    // Case: if there is a right child and check whether the right child has an element smaller than node i and left child
	    if (right <= a.size()-1 && this.comparator.compare(a.get(right),(a.get(smallest))) < 0)
	      smallest = right;  // yes, so the left child is the smallest among them

	    // If node i holds an element smaller than both the left and right children, then the min-heap property already held, 
	    // and we need do nothing more. Otherwise, we need to swap node i with the smaller one of the two children, 
	    // and then recursively call minHeapify from the smaller child.
	    if (smallest != i) {
	      swap(a, i, smallest);
	      minHeapify(a, smallest);
	    }
	  } 
	  
	  /**
	   * Swap two locations i and j in ArrayList a.
	   * @param a the ArrayList
	   * @param i first position
	   * @param j second position
	   */
	  private static <E> void swap(ArrayList<E> a, int i, int j) {
	    E t = a.get(i);
	    a.set(i, a.get(j));
	    a.set(j, t);
	  }
	  
	  /**
	   * Return the index of the left child of node i.
	   * @param i index of the parent node
	   * @return index of the left child of node i
	   */
	  private static int leftChild(int i) {
	    return 2*i + 1;
	  }
	  
	  /**
	   * Return the index of the right child of node i.
	   * @param i index of the parent node
	   * @return the index of the right child of node i
	   */
	  private static int rightChild(int i) {
	    return 2*i + 2;
	  }
	  
	  /**
	   * Return the index of the parent of node i.
	   * If called on the root (i equals 0), the returned index is 0.
	   * @param i index of the child
	   * @return index of the parent of node i
	   */
	  private static int parent(int i) {
	    return (i-1)/2;
	  }

}
