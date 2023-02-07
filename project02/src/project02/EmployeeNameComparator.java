package project02;

import java.util.Comparator;

/**
 * Helper class implementing Comparator interface
 * Represents Comparator class using Employee name to compare with the other Employee
 * @author Chi Ting Lu
 * @version 1.0
 */

public class EmployeeNameComparator implements Comparator<Employee> {
 
	/**
	 * Implement the Comparator interface 
	 * set compare method using order of name lexicographically
	 * @param e1 A Employee class we compare with
	 * @param e2 A Employee class we compare with
	 * @return A integer value specifying if it is bigger or smaller or the same
	 */
    public int compare(Employee e1, Employee e2)
    {
    	return e1.name.compareTo(e2.name);
    }
}