package project1;

/**
 * Defines an exception that is thrown when an index is out of bound.
 */
public class BagIndexOutOfBoundsException extends IndexOutOfBoundsException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public BagIndexOutOfBoundsException(String message) {
		super(message);
	}
}