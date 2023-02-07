package project3;

/**
 * Specifications of operations of a generic stack. 
 * @author Chi-Ting Lu
 * @version 1.0
 */

public interface GenericStackInterface<E> {
	   
	 /**
	   * Adds an item to the top of a stack.
	   * @param item An item to be added
	   */
	  public void push(E item);
	  
	  
    /**
     * Removes the top of a stack.
     * @return The item that was most recently added to this stack
     * @throws StackException If the stack is empty.
     */
	  public E pop() throws StackException;
	  
	  
	  /**
	   * Removes all the items from the stack.
	   * @throws StackException If the stack is empty.
	   */
	  public void popAll() throws StackException;
	  
	  
	  /**
	   * Returns a reference to the top item of a stack.
	   * @return A reference to the item that was added most recently
	   * @throws StackException If the stack is empty.
	   */
	  public E peek() throws StackException;
	  
	  
	  /**
	   * Determines whether the stack is empty.
	   * @return A boolean value specifying if this stack is empty
	   */
	  public boolean isEmpty();
	  
	  
	  /**
	   * Returns the number of items in the stack.
	   * @return A number specifying how many items in the stack
	   */
	  public int size();
	  
	  
}

	

