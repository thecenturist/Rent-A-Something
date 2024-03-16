package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Vehicle object which is Rental product
 */

// A Vehicle is-a Rental
public class Vehicle implements Rental
{
	private String manufacturer; // A Vehicle has-a manufacturer
	private String model; // A Vehicle has-a model
	private int year; // A Vehicle has-a year
	private double rentAmount; // A Vehicle has-a rentAmount
	private double discountPercent; // A Vehicle has-a discountPercent
	
	Vehicle(String manufacturer, String model, int year)
	{
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.rentAmount = 0.0;
		this.discountPercent = 0.0;
	}
	
	Vehicle(String manufacturer, String model, int year, double rent, double discount)
	{
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.rentAmount = rent;
		this.discountPercent = discount;
	}
	
	/**
	 * Return the manufacturer of the Vehicle
	 * @return String
	 */
	public String getManufacturer() {
		return this.manufacturer;
	};
	
	/**
	 * Return the model of the Vehicle
	 * @return String
	 */
	public String getModel() {
		return this.model;
	}
	
	/**
	 * Return the year of the Vehicle
	 * @return int
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Return the rent amount per hour of the Vehicle
	 * @return double
	 */
	public double getRentAmount()
	{
		return this.rentAmount;
	}

	/**
	 * Set the rent amount of the Vehicle
	 * @param rent
	 */
	public void setRentAmount(double rent)
	{
		this.rentAmount = rent;
	}

	/**
	 * Set discount percentage of the Vehicle's rent
	 * @param discount
	 */
	public void setDiscountPercentage(double discount)
	{
		this.discountPercent = discount;
	}

	/**
	 * Return the discount percentage of the Vehicle
	 * @return double
	 */
	public double getDiscountPercentage()
	{
		return this.discountPercent;
	}
	
}
