package project2;

/**
 * Defines an exception that is thrown when an index is out of bound of the linked string.
 * @author Chi Ting Lu
 * @version 1.0
 */
public class LinkedStringOutOfBoundException extends IndexOutOfBoundsException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public LinkedStringOutOfBoundException(String message) {
		super(message);
	}
}