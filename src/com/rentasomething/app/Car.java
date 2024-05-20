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

	Car(String manufacturer, String model, int year, Person person, long rent, long discount)
	{
		super(manufacturer, model, year, person, rent, discount);
	}

	Car(Vehicle vehicle)
	{
		this(vehicle.getManufacturer(), vehicle.getModel(), vehicle.getYear(),
				vehicle.getRenter(), vehicle.getRentAmount(), vehicle.getDiscountPercentage());
	}
}
