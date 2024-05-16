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
		
		// Create sample persons
		this.people.add(new Person("Mary", "Moses", 54993943L));
		this.people.add(new Person("James", "Moses", 7865398L));
		this.people.add(new Person("John", "Moses", 73987));
		this.people.add(new Person("Matthew", "Moses", 5395L));
		this.people.add(new Person("Mark", "Moses", 5396L));
		this.people.add(new Person("Luke", "Moses", 5397L));
		this.people.add(new Person("Isaiah", "Moses", 4398L));
		this.people.add(new Person("Elijah", "Moses", 1398L));
		this.people.add(new Person("Ruth", "Moses", 2498L));
		this.people.add(new Person("Mary", "Moses", 54993943L));
		this.people.add(new Person("James", "Moses", 7865398L));
		this.people.add(new Person("John", "Moses", 73987));
		this.people.add(new Person("Matthew", "Moses", 5395L));
		this.people.add(new Person("Mark", "Moses", 5334L));
		this.people.add(new Person("Luke", "Moses", 497L));
		this.people.add(new Person("Isaiah", "Moses", 4398L));
		this.people.add(new Person("Elijah", "Moses", 1398L));
		this.people.add(new Person("Ruth", "Moses", 2498L));
		this.people.add(new Person("Mary", "Moses", 54993943L));
		this.people.add(new Person("James", "Moses", 7865398L));
		this.people.add(new Person("John", "Moses", 73987));
		this.people.add(new Person("Matthew", "Moses", 5395L));
		this.people.add(new Person("Mark", "Moses", 5396L));
		this.people.add(new Person("Luke", "Moses", 5397L));
		this.people.add(new Person("Isaiah", "Moses", 4398L));
		this.people.add(new Person("Elijah", "Moses", 1398L));
		this.people.add(new Person("Ruth", "Moses", 2498L));
		
	}
	
	/**
	 * Add a person to the list of people existing
	 * @param person
	 */
	public void addPerson(Person person) {
		this.people.add(person);
	}
	
	/**
	 * Remove a person from the list of people existing
	 * @param person
	 */
	public void removePerson(Person person) {
		this.people.remove(person);
	}
	
	/**
	 * Return the list of all persons existing
	 * @return ArrayList<Person>
	 */
	public ArrayList<Person> getAllPersons(){
		return this.people;
	}
	
	/**
	 * Retrieve a person matching the given ssn from the list of people existing
	 * @param ssn
	 * @return Person
	 */
	public Person getPersonBySSN(Long ssn) {
		for (Person p : this.people) {
			if (p.getSSN() == ssn) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Retutn the hashmap of all products existing
	 * @return HashMap
	 */
	public HashMap<String, ArrayList<Product>> getAllProducts(){
		return this.products;
	}
	
	/**
	 * Add a new product to the product list.
	 * @param productType
	 * @param newProduct
	 * @return boolean, true if successful, otherwise false
	 */
	public boolean addProduct(String productType, Product newProduct) {
		// If the products list doesn't contain the product trying to be added, then add it to the list
		if (!this.products.get(productType).contains(newProduct)) {
			this.products.get(productType).add(newProduct);
			return true;
		}
		return false;
	}
}
