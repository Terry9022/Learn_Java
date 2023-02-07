package project2;

/**
 * Specifications on the design of operations of the linked string. 
 * @author Chi Ting Lu
 * @version 1.0 
 */
public interface LinkedStringInterface {
	
	/**
	   * Return the char value at the specified index.
	   * @param index An integer specifying the position of the char
	   * @return The char specifying the retrieved char 
	   * @throws LinkedStringOutOfBoundException If index < 0 or index > length()-1
	   * @throws LinkedStringException If length() is 0
	   */
	public char charAt(int index) throws LinkedStringOutOfBoundException, LinkedStringException;
	
	 /**
	   * Concatenate a specified linked string to the end of this linked string.
	   * @param OtherString The other linked string will be added to the end of this linked string
	   * @return A linked string after adding and combining other linked string
	   */
	public LinkedString concat(LinkedString OtherString);
	
	/**
	  * Determines whether the linked string is empty. Returns true if and only if the length of this linked string is 0. 
	  * @return A boolean value specifying if this linked string is empty or not
	  */
	public boolean isEmpty();
	
	/**
	   * Return the length of this linked string. 
	   * @return An integer specifying the length of the linked string
	   */
	public int length();
	
	/**
	   * Return a new linked string that is a substring of this linked string, where startIndex is inclusive, and endIndex is exclusive.
	   * @param startIndex An integer specifying the start position of the substring
	   * @param endIndex An integer specifying the end position of the substring
	   * @return A linked string which is the substring of this linked string
	   * @throws LinkedStringOutOfBoundException If index < 0 or index > length()-1
	   * @throws LinkedStringException If length() is 0
	   */
	public LinkedString substring(int startIndex, int endIndex) throws LinkedStringOutOfBoundException, LinkedStringException;
 

}



