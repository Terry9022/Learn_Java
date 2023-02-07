package project4;

import java.util.LinkedList;

/**
 * Represents an ADT Address book maintains a list of contacts in a binary search tree.
 * This ADT is implemented using a binary search tree as the data structure.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class AddressBook {

	  /**
	   * The binary search tree of this Address Book
	   * it provide the operations of the Address Book
	   */
	  private BinarySearchTree<Contact> tree;
	  
	  /**
	   * Constructs an Address Book. 
	   */
	  public AddressBook(){
		  this.tree = new BinarySearchTree<Contact>();
	  }
	  
	  /**
	   * Search a contact in this address book.
	   * @param contact A contact we want to search
	   * @return A value specifying if the address book has this contact or not
	   */
	   public boolean search(Contact contact) {
		 return this.tree.search(contact);
	  }
	  
      /**
       * Insert a contact into this address book.
	   * @param contact A reference to a new contact
	   */
	   public void insert(Contact contact) {
		   this.tree.insert(contact);
		  }	  
	   
	   /**
	    * Delete a contact from this address book, if it exists.
		* If the contact is not contained in the address book, no change is made
		* @param contact A reference to a contact we want to delete from the address book
		* @throws TreeException if the tree is empty
		*/
	    public void delete(Contact contact) throws TreeException{
	    	this.tree.delete(contact);
		  }	  
	   
	  /**
	   * Returns true if the address book is empty, else returns false.
	   * @return A value specifying if the address book is empty
	   */
	  public boolean isEmpty() {
		  return this.tree.isEmpty();
	  } 

	  /**
	   * Removes all contacts from the address book.
	   */
	  public void makeEmpty() {
		  this.tree.makeEmpty();
	  }	  
	  
	  
	  /**
	   * Find all contacts in the same zip code. 
	   * @param zipcode A String which is a specific zip code we are looking for
	   * @return A sorted linked list contains all contacts in the same zip code 
	   */
	  public LinkedList<Contact> findContactZip(String zipcode) {
		  LinkedList<Contact> list = new LinkedList<Contact>();
		  TreeIterator<Contact> iterator = this.tree.inorderTraversal();
		  while(iterator.hasNext()){
			  Contact current = iterator.next();
			  if(current.address.zipcode.equals(zipcode)) {
				  list.add(current);
			  }
		  }
		  return list;
	  }	
	  
	  /**
	   * Find all contacts in the same city. 
	   * @param city A String which is a specific city we are looking for
	   * @return A sorted linked list contains all contacts in the same city
	   */
	  public LinkedList<Contact> findContactCity(String city) {
		  LinkedList<Contact> list = new LinkedList<Contact>();
		  TreeIterator<Contact> iterator = this.tree.inorderTraversal();
		  while(iterator.hasNext()){
			  Contact current = iterator.next();
			  if(current.address.city.equals(city)) {
				  list.add(current);
			  }
		  }
		  return list;
	  }	
	  
	  /**
	   * Find all contacts whose phone numbers have the same area code.
	   * @param areacode A String which is a specific  area code we are looking for
	   * @return A sorted linked list contains all contacts have the same area code.
	   */
	  public LinkedList<Contact> findContactAreaCode(String areacode) {
		  LinkedList<Contact> list = new LinkedList<Contact>();
		  TreeIterator<Contact> iterator = this.tree.inorderTraversal();
		  while(iterator.hasNext()){
			  Contact current = iterator.next();
			  if(current.phone.substring(0,3).equals(areacode)) {
				  list.add(current);
			  }
		  }
		  return list;
	  }	
	  
	   
}
