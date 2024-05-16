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
 *         Model a Car object which is a type of Vehicle
 */

// A Car is-a Vehicle
public class Car extends Vehicle
{
	private long odometerReading; // A Car has-a odometerReading

	Car(String manufacturer, String model, int year, Person person,
			long mileage)
	{
		super(manufacturer, model, year, person);
		this.odometerReading = mileage;
	}

	Car(Vehicle vehicle, long mileage)
	{
		this(vehicle.getManufacturer(), vehicle.getModel(), vehicle.getYear(),
				vehicle.getRenter(), mileage);
	}

	/**
	 * Return the value of the odometer reading
	 * 
	 * @return double
	 */
	public long getOdometerReading()
	{
		return this.odometerReading;
	}

	/**
	 * Set the odometer reading
	 * 
	 * @param mileage
	 */
	public void setOdometerReading(long mileage)
	{
		this.odometerReading = mileage;
	}
}
