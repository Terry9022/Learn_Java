package project4;

/**
 * Represents a contact class contains full name, address, phone data.
 * It can used to store data, and it represents a node in an AddressBook (Binary search tree).
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Contact implements Comparable<Contact>{
	
	/**
	 * The full name data of a contact.
	 * We also use the full name as the key in the binary search tree.
	 */
	private String fullName;
	
	/**
	 * The address data of a contact.
	 */
	public Address address;
	
	/**
	 * The phone number data of a contact.
	 */
	public String phone;
	

	/**
	 * Constructs a contact class.
	 * @param fullname A String specifying the full name data
	 * @param address An Address class specifying the address data
	 * @param phone A String specifying the phone number data
	 */
	public Contact (String fullName, Address address, String phone) {
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}
	
	/**
	 * Returns the full name of this contact.
	 * @return A String specifying the full name data
	 */
	public String getName() {
		return this.fullName;
	}
	
	/**
	 * Implement the Comparable interface 
	 * set compareTo method using order of full name
	 * @param o A contact class we compare with
	 * @return A integer value specifying if it is bigger or smaller or the same
	 */
	public int compareTo(Contact o) {
		return this.fullName.compareTo(o.fullName);
	}
	
	/**
	 * Returns a string representation of this contact.
	 * @return A string representation of this contact
	 */
	public String toString(){
		return this.getName()+"  "+this.address.city+"  "+this.address.state+"  "+this.address.zipcode+"  "+this.phone;
	}
	

}
