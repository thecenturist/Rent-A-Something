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
	private int socialSecurityNumber; // A Person has-a socialSecurityNumber
	
	Person(String first, String last, int ssn){
		this.firstName = first;
		this.lastName = last;
		this.socialSecurityNumber = ssn;
	}
	
	Person (Person copyPerson){
		this(copyPerson.firstName, copyPerson.lastName, copyPerson.socialSecurityNumber);
	}
	
	/**
	 * Return the social security number of the Person
	 * @return int
	 */
	public int getSSN() {
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
	 * Return the details of the Person
	 * @return String
	 */
	public String toString(){
		return this.firstName + " " + this.lastName + " " + this.socialSecurityNumber;
	}
}
