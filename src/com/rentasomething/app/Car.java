package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Car object which is a type of Vehicle
 */

// A Car is-a Vehicle
public class Car extends Vehicle
{
	private double odometerReading; // A Car has-a odometerReading
	
	Car(String manufacturer, String model, int year, double mileage)
	{
		super(manufacturer, model, year);
		this.odometerReading = mileage;
	}
	
	/**
	 * Return the value of the odometer reading
	 * @return double
	 */
	public double getOdometerReading() {
		return this.odometerReading;
	}
	
	/**
	 * Set the odometer reading
	 * @param mileage
	 */
	public void setOdometerReading(double mileage) {
		this.odometerReading = mileage;
	}
}
