package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of class:
 * Model a Product object which is-a Rental
 */

public class Product extends Item implements Rental
{
	private long rentAmount; // A Product has-a rentAmount
	private long discountPercent; // A Product has-a discountPercent
	
	Product(long rent, long discount){
		this.rentAmount = rent;
		this.discountPercent = discount;
	}
	
	/**
	 * Return the rent amount per hour of the Vehicle
	 * @return long
	 */
	public long getRentAmount()
	{
		return this.rentAmount;
	}

	/**
	 * Set the rent amount of the Vehicle
	 * @param rent
	 */
	public void setRentAmount(long rent)
	{
		this.rentAmount = rent;
	}

	/**
	 * Set discount percentage of the Vehicle's rent
	 * @param discount
	 */
	public void setDiscountPercentage(long discount)
	{
		this.discountPercent = discount;
	}

	/**
	 * Return the discount percentage of the Vehicle
	 * @return long
	 */
	public long getDiscountPercentage()
	{
		return this.discountPercent;
	}

	@Override
	public String toString()
	{
		return "Rent: " + this.getRentAmount() + "\nDiscount: " + this.getDiscountPercentage() + "%" ;
	}
}
