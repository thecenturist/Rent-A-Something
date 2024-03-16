package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Boat object which is a type of Vehicle
 */

// A Boat is-a Vehicle
public class Boat extends Vehicle
{
	private double length; // A Boat has-a length, in meters
	private double topSpeed; // A Boat has-a topSpeed, in kilo-meters per hour (kmh)
	
	Boat(String manufacturer, String model, int year)
	{
		super(manufacturer, model, year);
	}
	
	Boat(String manufacturer, String model, int year, double length, double topSpeed)
	{
		super(manufacturer, model, year);
		this.length = length;
		this.topSpeed = topSpeed;
	}
	
	/**
	 * Return the length, in meters, of the Boat
	 * @return double
	 */
	public double getLength() {
		return this.length;
	}
	
	/**
	 * Set the length, in meters, of the Boat
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/**
	 * Return the top speed, in kmh, of the Boat
	 * @return double
	 */
	public double getTopSpeed() {
		return this.length;
	}
	
	/**
	 * Set the top speed, in kmh, of the Boat
	 * @param speed
	 */
	public void setTopSpeed(double speed) {
		this.topSpeed = speed;
	}
}
