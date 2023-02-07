package project3;

import java.util.ArrayList;

/**
 * Implementation of a generic stack using an ArrayList. 
 * @author Chi-Ting Lu
 * @version 1.0
 */

public class GenericStack<E> implements GenericStackInterface<E> {
	
	  /**
	   * The ArrayList containing the items of this stack
	   */
	  private ArrayList<E> list;
	  
	  
	  /**
	   * Constructs a stack with a ArrayList. 
	   */
	  public GenericStack() {
	    this.list = new ArrayList<E>();
	  }
	  
	
	 /**
	   * Adds an item to the top of a stack.
	   * @param item An item to be added
	   */
	  public void push(E item) {
		  this.list.add(item);
		  
	  }
	  
	  
	  /**
	   * Removes the top of a stack.
	   * @return The item that was most recently added to this stack
	   * @throws StackException If the stack is empty.
	   */
	  public E pop() throws StackException{
		  if (!isEmpty()) {
		      return this.list.remove( this.size()-1 );
		    } else {
		      throw new StackException("Stack is empty");
		    }
	  }
	  
	  
	  /**
	   * Removes all the items from the stack.
	   * @throws StackException If the stack is empty.
	   */
	  public void popAll() throws StackException{
		  if(!isEmpty()){
			  this.list = new ArrayList<E>();
			  
		  }else{
			  throw new StackException("Stack is empty");
		  }
	  }
	  
	  
	  /**
	   * Returns a reference to the top item of a stack.
	   * @return A reference to the item that was added most recently
	   * @throws StackException If the stack is empty.
	   */
	  public E peek() throws StackException{
		  if (!isEmpty()) {
		      return this.list.get( this.size()-1 );
		    }else {
		    	throw new StackException("Stack is empty");
		    }
	  }
	  
	  
	  /**
	   * Determines whether the stack is empty.
	   * @return A boolean value specifying if this stack is empty
	   */
	  public boolean isEmpty() {
		  return list.size() == 0;
	  }
	  
	  
	  /**
	   * Returns the number of items in the stack.
	   * @return A number specifying how many items in the stack
	   */
	  public int size() {
		  return list.size();
	  }
	  
	  
}

	

