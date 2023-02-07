package project02;

/**
 * Represents an employee class contains name and payrate data.
 * @author Chi Ting Lu
 * @version 1.0
 */

public class Employee {
	
	/**
	 * The name data of an employee
	 */
	public String name;
	/**
	 * The payrate data of an employee
	 */
	public float payrate;
	
	/**
	 * Constructs an address class.
	 * @param name A String specifying the name data
	 * @param payrate A float specifying the payrate data
	 * 
	 */
	public Employee(String name, float payrate) {
		this.name = name;
		this.payrate = payrate;
	};

	/**
	 * Returns a string representation of this Employee.
	 * @return A string representation of this Employee
	 */
    public String toString() {

    return this.name + "  " + this.payrate;
    };

}
