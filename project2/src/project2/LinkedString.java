package project2;

/**
 * Implementations of operations of linked string.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class LinkedString implements LinkedStringInterface{
	
	/**
	 * A reference to the head of the linked string
	 */
	private Node<Character> head;
	
	/**
	 * The number of character in this linked string
	 */
	private int count;
	
	/**
	 * Create a LinkedString instance containing a sequence of characters as a char array instance.
	 * @param input A sequence of characters as a char array instance, which we want put into the linked string
	 */
	public LinkedString(char[] input){

		this.head = null;
	    this.count = 0;
	    
	    if(input!=null) {
		    for(int i=0;i<input.length;i++) {
		    	this.add(input[i]);
		    }
	    }
	}
	
	/**
	 * Create an empty LinkedString instance
	 */
	public LinkedString(){
		this(new char[0]);
	}
	
	/**
	 * Create a create a LinkedString instance containing same sequence of characters as a String instance.
	 * @param  input A sequence of characters as a String instance, which we want put into the linked string
	 */
	public LinkedString(String input){
		this(input.toCharArray());
	}
	
	/**
	   * Return the char value at the specified index.
	   * @param index An integer specifying the position of the char
	   * @return The char specifying the retrieved char 
	   * @throws LinkedStringOutOfBoundException If index < 0 or index > length()-1
	   * @throws LinkedStringException If length() is 0
	   */
	public char charAt(int index) throws LinkedStringOutOfBoundException, LinkedStringException{
		
		// throw exception if there is any error.
		if(this.count == 0){
			  throw new LinkedStringException("The list is empty");
			  }
	    if(index < 0 || index > this.length()-1){
		      throw new LinkedStringOutOfBoundException("The index value must be between 0 and " + (this.count -1));
	    	}
	    
	    // return the character at index from this LinkedString.
		return find(index).getElement();
	}
	
	 /**
	   * Concatenate a specified linked string to the end of this linked string.
	   * @param OtherString The other linked string will be added to the end of this linked string
	   * @return A linked string after adding and combining other linked string
	   */
	public LinkedString concat(LinkedString OtherString){
		
		// Create a new character array to place all the combined characters from two linked string inside of this array.
		char [] NewCharArray = new char[this.count+OtherString.count];
		
		for(int i=0;i<this.count;i++) {
			NewCharArray[i] = this.charAt(i);
		}
		for(int i=0;i<OtherString.count;i++) {
			NewCharArray[this.count+i] = OtherString.charAt(i);
		}
		
		// Then create a new linked string and return it
		LinkedString ConcatString = new LinkedString(NewCharArray);
	    
	    return ConcatString;
	}
	
	/**
	  * Determines whether the linked string is empty. Returns true if and only if the length of this linked string is 0. 
	  * @return A boolean value specifying if this linked string is empty or not
	  */
	public boolean isEmpty(){
		return this.count == 0;
	}
	
	/**
	   * Return the length of this linked string. 
	   * @return An integer specifying the length of the linked string
	   */
	public int length(){
		return this.count;
	}
	
	/**
	   * Return a new linked string that is a substring of this linked string, where startIndex is inclusive, and endIndex is exclusive.
	   * @param startIndex An integer specifying the start position of the substring
	   * @param endIndex An integer specifying the end position of the substring
	   * @return A linked string which is the substring of this linked string
	   * @throws LinkedStringOutOfBoundException If index < 0 or index > length()-1
	   * @throws LinkedStringException If length() is 0
	   */
	public LinkedString substring(int startIndex, int endIndex) throws LinkedStringOutOfBoundException, LinkedStringException{
		
		// throw exception if there is any error
		if(this.count == 0){
			  throw new LinkedStringException("The list is empty");
			  }
		if(startIndex > endIndex){
			  throw new LinkedStringException("The startIndex is bigger than endIndex");
			  }
	    if(startIndex < 0 || startIndex > this.length()-1){
		      throw new LinkedStringOutOfBoundException("The index value must be between 0 and " + (this.count -1));
	    	}
	    if(endIndex < 0 || endIndex > this.length()){
		      throw new LinkedStringOutOfBoundException("The index value must be between 0 and " + (this.count));
	    	}
	    
	    // Create a new character array to place all the substring characters inside of this array.
	    char [] NewCharArray = new char[endIndex-startIndex];
	    for(int i=0;i<NewCharArray.length;i++) {
	    	NewCharArray[i] = this.charAt(startIndex+i);
	    }
	    // Then create a new linked string and return it
	    LinkedString Substring = new LinkedString(NewCharArray);
	    
	    return Substring;
	}
	
	/**
	   * Adds an element to the LinkedString at position index.
	   * @param index The position of this added element
	   * @param data A reference to this added character
	   * @throws LinkedStringOutOfBoundException If index < 0 or index > length()
	   */
	  public void add(int index, char data) throws LinkedStringOutOfBoundException{
		  
		  // throw exception if there is any error.
		  if(index < 0 || index > this.length()){
			  throw new LinkedStringOutOfBoundException("The index value must be between 0 and " + (this.count -1));
		  }
		  
		  // When adding we need to consider following situations:
		  // Empty list
		  // - create a new node
		  // One node list
		  // - front or end
		  // Multiple nodes list(two nodes or more)
		  // - front, middle, end
			  
		  if(this.head == null){  
			  //Empty list
			  this.head = new Node<Character>(data, null, null);
		  }else if(this.length() == 1){  
			  // One node list
			  if(index == 0){ 
				  // front
				  this.head = new Node<Character>(data, null, this.head);
			  }else if(index == this.length()){  
				  // end
				  this.head.setNext(new Node<Character>(data, this.head, null));
			  }
		  }else{   
			  // a multiple node list
			  if(index == 0){ 
				  // front
				  this.head = new Node<Character>(data, null, this.head);
			  }else if(index == this.length()){ 
				  // end
				  // find the very last node
				  Node<Character> current = find(index -1);
				  current.setNext(new Node<Character>(data, current, null));
			  }else{ 
				  // middle
				  // Find the node prior to the node at index
				  Node<Character> current = find(index-1);
				  // Insert the node at the font of the node at index
				  current.setNext(new Node<Character>(data, current, current.getNext()));
			  }
		  }
		  
		  this.count++;
	} 
	  
	  /**
	   * Returns a reference to a specific node at index.
	   * @param index The index of a specific node
	   * @return The reference to the specific character node
	   */
	  private Node<Character> find(int index){
		  int position = 0;
		  Node<Character> current = this.head;
		  while(position != index){
			  position++;
			  current = current.getNext();
		  }
		 return current;
	  }
	  
	  /**
	   * Adds an element to the end of the LinkedString.
	   * @param data The character we want to add
	   */
	  public void add(char data) {
			add(length(),data);
	  }
	  
	 
	  


}


