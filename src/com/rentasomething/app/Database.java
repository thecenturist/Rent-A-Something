package com.rentasomething.app;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lead Author(s):
 * 
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: May-12-2024
 * 
 *         Responsibilities of class:
 *         The Database, this class will mimic a poor representation of a MySQL database, essentially allowing for storage and retrieval of People, Products, and Rent information.
 */

public class Database
{
	private ArrayList<Person> people; // A Database has-a people
	private HashMap<String, ArrayList<Product>> products; // A Database has-a products
	
	public Database() {
		// Initialize 'tables'
		this.people = new ArrayList<Person>();
		this.products = new HashMap<String, ArrayList<Product>>();
		
	}
	
	public void addPerson(Person p) {
		this.people.add(p);
	}
	
	public ArrayList<Person> getAllPersons(){
		return this.people;
	}
	
	public Person getPersonBySSN(Long ssn) {
		for (Person p : this.people) {
			if (p.getSSN() == ssn) {
				return p;
			}
		}
		return null;
	}
	
	public HashMap<String, ArrayList<Product>> getAllProducts(){
		return this.products;
	}
}
