package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Vehicle object which is Product
 */

// A Vehicle is-a Product
public class Vehicle extends Product
{
	private String manufacturer; // A Vehicle has-a manufacturer
	private String model; // A Vehicle has-a model
	private int year; // A Vehicle has-a year
	
	Vehicle(String manufacturer, String model, int year, double rent, double discount)
	{
		super(rent, discount);
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
	}
	
	Vehicle(String manufacturer, String model, int year)
	{
		super(0,0);
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
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
	
}
