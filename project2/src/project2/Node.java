package project2;

/**
 * Represents a generic node in a double linked list.
 * @author Chi Ting Lu
 * @version 1.0
 */
public class Node<E> {
	/**
	 * The element of this node
	 */
	private E element;
	/**
	 * The link to previous node
	 */
	private Node<E> previous;
	/**
	 * The link to next node
	 */
	private Node<E> next;

	/**
	 * Constructs a default node.
	 */
	public Node() {
		this(null, null, null);
	}  
	/**
	 * Constructs a node with an element and set link to nodes as null.
	 * @param element A reference to the element of this node
	 */
	public Node(E element) {
		this(element, null, null);
	}  
	/**
	 * Constructs a node with an element and a link to previous node and a link to next node.
	 * @param element A reference to the element of this node
	 * @param previous A link to previous node
	 * @param next A link to next node
	 */
	public Node(E element, Node<E> previous, Node<E> next) {
		this.element = element;
		this.previous = previous;
		this.next = next;
    }
	
	/**
	 * Returns the element of this node.
	 * @return The element of this node
	 */
	public E getElement() {
		return this.element;
	}
	
	/**
	 * Changes the element of this node.
	 * @param A reference to an element
	 */
	public void setElement(E element) {
		this.element = element;
	}
	
	/**
	 * Returns the previous reference of this node.
	 * @return A reference to the previous node of this node
	 */
	public Node<E> getPrevious() {
		return this.previous;
	}
	
	/**
	 * Changes the previous reference of this node
	 * @param previous A reference to the previous node of this node
	 */
	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	} 
	
	/**
	 * Returns the next reference of this node.
	 * @return A reference to the next node of this node
	 */
	public Node<E> getNext() {
		return this.next;
	}
	
	/**
	 * Changes the next reference of this node
	 * @param next A reference to the next node of this node
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}  
	
	/**
	 * Returns a string representation of this node.
	 * @return A string representation of this node
	 */
	public String toString(){
		return getClass().getSimpleName() + ": " + this.element;
	}
	
	/**
	 * Returns whether the Object o equals to this.element
	 * @param o The other object taken to be compared with this.element
	 * @return A boolean indicates if equals or not
	 */
	public boolean equals(Object o) {
		return this.element.equals(o);
	}
}  