package com.rentasomething.app;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: March-21-2024
 * 
 *         Responsibilities of class:
 *         Model a Electronic object which is a Product
 */

// A Electronic is-a Product
public class Electronic extends Product
{
	// A Electronic has-a manufacturer
	private String manufacturer;
	// A Electronic has-a brand
	private String brand;
	// A Electronic has-a model
	private String model;
	private Person renter;

	public Electronic(Person person, String manufacturer, String brand,
			String model)
	{
		super(0, 0);
		this.renter = person;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.model = model;
	}

	public Electronic(Person person, String manufacturer, String brand,
			String model, long rent, long discount)
	{
		super(rent, discount);
		this.renter = person;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.model = model;
	}

	/**
	 * Set the manufacturer of the Electronic
	 * 
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	/**
	 * Set the brand of the Electronic
	 * 
	 * @param brand
	 */
	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	/**
	 * Set the model of the Electronic
	 * 
	 * @param model
	 */
	public void setModel(String model)
	{
		this.model = model;
	}

	/**
	 * Return the manufacturer of the Electronic
	 * 
	 * @return String
	 */
	public String getManufacturer()
	{
		return this.manufacturer;
	};

	/**
	 * Return the brand of the Electronic
	 * 
	 * @return String
	 */
	public String getBrand()
	{
		return this.brand;
	}

	/**
	 * Return the model of the Electronic
	 * 
	 * @return String
	 */
	public String getModel()
	{
		return this.model;
	}

	/**
	 * Set the renter of the Electronic
	 * 
	 * @param renter
	 */
	public void setRenter(Person renter)
	{
		this.renter = renter;
	}

	/**
	 * Return the renter of the Electronic
	 * 
	 * @return renter
	 */
	public Person getRenter()
	{
		return this.renter;
	}

}
