package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Person object representing a human being
 */

public class Person
{
	private String firstName; // A Person has-a firstName
	private String lastName; // A Person has-a lastName
	private long socialSecurityNumber; // A Person has-a socialSecurityNumber
	
	Person(String first, String last, long ssn){
		this.firstName = first;
		this.lastName = last;
		this.socialSecurityNumber = ssn;
	}
	
	Person (Person copyPerson){
		this(copyPerson.firstName, copyPerson.lastName, copyPerson.socialSecurityNumber);
	}
	
	/**
	 * Return the social security number of the Person
	 * @return long
	 */
	public long getSSN() {
        return this.socialSecurityNumber;
    }
	
	/**
	 * Return the last name of the Person
	 * @return String
	 */
    public String getLastName() {
        return this.lastName;
    }

    /**
	 * Return the first name of the Person
	 * @return String
	 */
    public String getFirstName() {
        return this.firstName;
    }

    /**
	 * Return the full name of the Person
	 * @return String
	 */
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    
    /**
     * Set the last name of the Person
     * @param name
     */
    public void setLastName(String name) {
    	this.lastName = name;
    }
    
    /**
     * Set the first name of the Person
     * @param name
     */
    public void setFirstName(String name) {
    	this.firstName = name;
    }
    
    /**
     * Set the social security number of the Person
     * @param ssn
     */
    public void setSSN(long ssn) {
    	this.socialSecurityNumber = ssn;
    }

	/**
	 * Return the details of the Person
	 * @return String
	 */
	public String toString(){
		return this.firstName + " " + this.lastName + " " + this.socialSecurityNumber;
	}
}
