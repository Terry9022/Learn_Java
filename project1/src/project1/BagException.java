package project1;

/**
 * Defines an exception that is thrown when there is error for the bag operation
 */
public class BagException extends RuntimeException {
	
	/**
	 * Constructs an object with specific message
	 * @param message A string literal specifying the details of this exception
	 */
	public BagException(String message) {
		super(message);
	}
}