package com.rentasomething.app;

/**
 * Lead Author(s):
 * 
 * @author Anjolaoluwa Akinremi
 * 
 *         References:
 *         Version/date: March-9-2024
 * 
 *         Responsibilities of class:
 *         Model a Vehicle object which is Product
 */

// A Vehicle is-a Product
public class Vehicle extends Product
{
	private String manufacturer; // A Vehicle has-a manufacturer
	private String model; // A Vehicle has-a model
	private int year; // A Vehicle has-a year
	private Person renter;

	Vehicle(String manufacturer, String model, int year, Person person,
			long rent, long discount)
	{
		super(rent, discount);
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.renter = person;
	}

	Vehicle(String manufacturer, String model, int year, Person person)
	{
		super(0, 0);
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.renter = person;
	}

	/**
	 * Return the manufacturer of the Vehicle
	 * 
	 * @return String
	 */
	public String getManufacturer()
	{
		return this.manufacturer;
	};

	/**
	 * Return the model of the Vehicle
	 * 
	 * @return String
	 */
	public String getModel()
	{
		return this.model;
	}

	/**
	 * Return the year of the Vehicle
	 * 
	 * @return int
	 */
	public int getYear()
	{
		return this.year;
	}

	/**
	 * Set the manufacturer of the Vehicle
	 * 
	 * @param value
	 */
	public void setManufacturer(String value)
	{
		this.manufacturer = value;
	}

	/**
	 * Set the model of the Vehicle
	 * 
	 * @param value
	 */
	public void setModel(String value)
	{
		this.model = value;
	}

	/**
	 * Set the year of the Vehicle
	 * 
	 * @param value
	 */
	public void setYear(int value)
	{
		this.year = value;
	}

	/**
	 * Set the renter of the Vehicle
	 * 
	 * @param renter
	 */
	public void setRenter(Person renter)
	{
		this.renter = renter;
	}

	/**
	 * Return the renter of the Vehicle
	 * 
	 * @return renter
	 */
	public Person getRenter()
	{
		return this.renter;
	}
}
