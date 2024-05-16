package com.rentasomething.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

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
	private HashMap<String, ArrayList<Product>> products; // A Database has-a
															// products
	private static Hashtable<String, Person> peopleNames;
	private static String[] nameArray;

	public Database()
	{
		// Initialize 'tables'
		this.people = new ArrayList<Person>();
		this.products = new HashMap<String, ArrayList<Product>>();

	}

	public void addPerson(Person p)
	{
		this.people.add(p);
	}

	public void removePerson(Person p)
	{
		this.people.remove(p);
	}

	public ArrayList<Person> getAllPersons()
	{
		return this.people;
	}

	public Person getPersonBySSN(Long ssn)
	{
		for (Person p : this.people)
		{
			if (p.getSSN() == ssn)
			{
				return p;
			}
		}
		return null;
	}

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

	public static Hashtable<String, Person> getNames()
	{
		peopleNames = new Hashtable<>();
		for (Person person : people)
		{
			peopleNames.put(person.getFullName(), person);
		}
		return peopleNames;
	}

	public HashMap<String, ArrayList<Product>> getAllProducts()
	{
		return this.products;
	}
}
