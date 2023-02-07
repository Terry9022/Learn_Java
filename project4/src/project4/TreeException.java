package project4;

/**
 * Represents an exception thrown from a tree when operations fail. 
 * @author Chi Ting Lu
 * @version 1.0
 */

public class TreeException extends RuntimeException {
	  
	/**
	   * Construct an exception object with a message.
	   * @param s A reference to an exception message
	   */
	
	  public TreeException(String s) {
	    super(s);
	  }
	} 