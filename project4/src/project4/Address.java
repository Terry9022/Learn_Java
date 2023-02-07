package project4;

/**
 * Represents an address class contains street, city, state and zipcode data.
 * It can used to store data
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Address {
	
	/**
	 * The street data of an address
	 */
	public String street;
	/**
	 * The city data of an address
	 */
	public String city;
	
	/**
	 * The state data of an address
	 */
	public String state;
	
	/**
	 * The zipcode data of an address
	 */
	public String zipcode;

	/**
	 * Constructs an address class.
	 * @param street A String specifying the street data
	 * @param city A String specifying the city data
	 * @param state A String specifying the state data
	 * @param zipcode A String specifying the zipcode data
	 * 
	 */
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

}
