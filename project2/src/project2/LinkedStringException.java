package project2;

/**
 * Defines an exception that is thrown when the operation can't be completed.
 * For example, if the linked string is empty, substring operation can't done. 
 * @author Chi Ting Lu
 * @version 1.0
 */
public class LinkedStringException extends RuntimeException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public LinkedStringException(String message) {
		super(message);
	}
}