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
 *         Model an Apartment object which is a Lodging
 */

// An Apartment is-a Lodging
public class Apartment extends Lodging
{
	// An Apartment has-an apartment number
	private int apartmentNumber;
	// An Apartment has-a price
	private int apartmentPrice;
	// An Apartment has-a number of bedrooms
	private long numberOfBedrooms;
	// An Apartment has-a number of bathrooms
	private long numberOfBathrooms;

	public Apartment(Person renter, int maxCapacity)
	{
		super(renter, maxCapacity);
	}

	public Apartment(Person renter, int maxCapacity, int apartmentNumber,
			int apartmentPrice, long numberOfBedrooms, long numberOfBathrooms)
	{
		super(renter, maxCapacity);
		this.apartmentNumber = apartmentNumber;
		this.apartmentPrice = apartmentPrice;
		this.numberOfBedrooms = numberOfBedrooms;
		this.numberOfBathrooms = numberOfBathrooms;
	}

	/**
	 * Set the apartment number of the Apartment
	 * 
	 * @param apartmentNumber
	 */
	public void setApartmentNumber(int apartmentNumber)
	{
		this.apartmentNumber = apartmentNumber;
	}

	/**
	 * Set the price of the Apartment
	 * 
	 * @param apartmentPrice
	 */
	public void setApartmentPrice(int apartmentPrice)
	{
		this.apartmentPrice = apartmentPrice;
	}

	/**
	 * Set the number of bedrooms of the Apartment
	 * 
	 * @param numberOfBedrooms
	 */
	public void setNumberOfBedrooms(int numberOfBedrooms)
	{
		this.numberOfBedrooms = numberOfBedrooms;
	}

	/**
	 * Set the number of bathrooms of the Apartment
	 * 
	 * @param numberOfBathrooms
	 */
	public void setNumberOfBathrooms(int numberOfBathrooms)
	{
		this.numberOfBathrooms = numberOfBathrooms;
	}

	/**
	 * Return the apartment number of the Apartment
	 * 
	 * @return int
	 */
	public int getApartmentNumber()
	{
		return this.apartmentNumber;
	};

	/**
	 * Return the price of the Apartment
	 * 
	 * @return int
	 */
	public int getApartmentPrice()
	{
		return this.apartmentPrice;
	}

	/**
	 * Return the number of bedrooms of the Apartment
	 * 
	 * @return int
	 */
	public long getNumberOfBedrooms()
	{
		return this.numberOfBedrooms;
	}

	/**
	 * Return the number of bathrooms of the Apartment
	 * 
	 * @return int
	 */
	public long getNumberOfBathrooms()
	{
		return this.numberOfBathrooms;
	}

}
