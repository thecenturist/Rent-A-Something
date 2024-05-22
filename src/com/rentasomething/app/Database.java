package com.rentasomething.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Lead Author(s):
 * 
 * @author Anjolaoluwa Akinremi
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: May-12-2024
 * 
 *         Responsibilities of class:
 *         The Database, this class will mimic a poor representation of a MySQL
 *         database, essentially allowing for storage and retrieval of People,
 *         Products, and Rent information.
 */

public class Database
{
	private static ArrayList<Person> people; // A Database has-a people
	private static HashMap<String, ArrayList<Product>> products; // A Database has-a
															// products
	private static Hashtable<String, Person> peopleNames; // A Database has-a peopleNames
	private static String[] nameArray; // A Database has-a nameArray

	public Database()
	{
		// Initialize 'tables'
		Database.people = new ArrayList<Person>();
		Database.products = new HashMap<String, ArrayList<Product>>();
		Database.products.put("car", new ArrayList<Product>());
		Database.products.put("boat", new ArrayList<Product>());
		Database.products.put("camera", new ArrayList<Product>());
		Database.products.put("phone", new ArrayList<Product>());
		loadPeopleDatabase();
	}
	
	private void loadPeopleDatabase() {
		try {
			Scanner scanner = new Scanner(new File("data.csv"));

			while (scanner.hasNextLine()) {
				String[] person = scanner.nextLine().split(",");
				this.addPerson(new Person(person[0], person[1], Long.parseLong(person[2])));
			}

			scanner.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	
	private void savePeopleDatabase(ArrayList<Person> people) throws IOException {
		FileWriter fileWriter = new FileWriter("data.csv");
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    
		for (Person person : people) {
			printWriter.println(person.getFirstName() + "," + person.getLastName() + "," + person.getSSN());
		}
		printWriter.close();
	}

	/**
	 * Add a person to the database
	 * @param p
	 */
	public void addPerson(Person p)
	{
		Database.people.add(p);
		try {
			savePeopleDatabase(Database.people);
		} catch (IOException e) {
			new ErrorDialog("Unable to save to database.");
		}
	}

	/**
	 * Remove a person from the database
	 * @param p
	 */
	public void removePerson(Person p)
	{
		Database.people.remove(p);
		try {
			savePeopleDatabase(Database.people);
		} catch (IOException e) {
			new ErrorDialog("Unable to save to database.");
		}
	}

	/**
	 * Retrieve all persons in the database
	 * @return ArrayList<Person>
	 */
	public ArrayList<Person> getAllPersons()
	{
		return Database.people;
	}

	/**
	 * Retrieve person object with matching ssn, el
	 * @param ssn
	 * @return Person if found, else null
	 */
	public Person getPersonBySSN(Long ssn)
	{
		for (Person p : Database.people)
		{
			if (p.getSSN() == ssn)
			{
				return p;
			}
		}
		return null;
	}

	/**
	 * Return the names of people in the database
	 * @return String[]
	 */
	public static String[] namesArray()
	{
		int personInc = 1;
		nameArray = new String[people.size()+1];
		nameArray[0] = "None";
		for (Person person : people)
		{
			nameArray[personInc] = person.getFullName();
			personInc++;

		}
		return nameArray;
	}

	/**
	 * Get the names of the people in the database
	 * @return Hashtable<String, Person>
	 */
	public static Hashtable<String, Person> getNames()
	{
		peopleNames = new Hashtable<>();
		for (Person person : people)
		{
			peopleNames.put(person.getFullName(), person);
		}
		return peopleNames;
	}

	/**
	 * Return all the products in the database
	 * @return HashMap<String, ArrayList<Product>>
	 */
	public HashMap<String, ArrayList<Product>> getAllProducts()
	{
		return Database.products;
	}
	
	/**
	 * Add a product to the database of a type
	 * @param type
	 * @param product
	 */
	public void addProduct(String type, Product product) {
		Database.products.get(type).add(product);
	}
	
	/**
	 * Retrieve the number of products in the database
	 * @return int
	 */
	public int getInventoryCount() {
		int count = 0;
		
		for (Map.Entry<String, ArrayList<Product>> set : Database.products.entrySet()) {
			count += set.getValue().size();
           }
		return count;
	}
	
	/**
	 * Retrieve all products of a type
	 * @param type
	 * @return ArrayList<Product>
	 */
	public ArrayList<Product> getProductForType(String type){
		return Database.products.get(type);
	}
}
