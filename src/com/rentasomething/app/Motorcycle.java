package com.rentasomething.app;

/**
 * Lead Author(s):
 * 
 * @author Kaitlyn Nguy
 * 
 *         References:
 *         Version/date: March-18-2024
 * 
 *         Responsibilities of class:
 *         Model a Motorcycle object which is a type of Vehicle
 */

// A Motorcycle is-a Vehicle
public class Motorcycle extends Vehicle
{
	// A Motorcycle has-a weight, in kilograms
	private long weight;
	// A Motorcycle has-a powerOutput, in CC
	private long powerOutput;
	private Person renter;

	public Motorcycle(String manufacturer, String model, int year,
			Person person)
	{
		super(manufacturer, model, year, person);
	}

	public Motorcycle(String manufacturer, String model, int year,
			Person person, long weight, long powerOutput)
	{
		super(manufacturer, model, year, person);
		this.weight = weight;
		this.powerOutput = powerOutput;
	}

	/**
	 * Set the weight (kg) of the Motorcycle
	 * 
	 * @param weight
	 */
	public void setWeight(long weight)
	{
		// assumes weight to new weight
		this.weight = weight;
	}

	/**
	 * Return the weight (kg) of the Motorcycle
	 * 
	 * @return double
	 */
	public long getWeight()
	{
		// returns the result
		return this.weight;
	}

	/**
	 * Set the power output (cc) of the Motorcycle
	 * 
	 * @param powerOutput
	 */
	public void setPowerOutput(long powerOutput)
	{
		this.powerOutput = powerOutput;
	}

	/**
	 * Return the power output (cc) of the Motorcycle
	 * 
	 * @return double
	 */
	public long powerOutput()
	{
		return this.powerOutput;
	}

	/**
	 * Set the renter of the Vehicle
	 * 
	 * @param renter
	 */
	@Override
	public void setRenter(Person renter)
	{
		this.renter = renter;
	}

	/**
	 * Return the renter of the Vehicle
	 * 
	 * @return renter
	 */
	@Override
	public Person getRenter()
	{
		return this.renter;
	}
}
