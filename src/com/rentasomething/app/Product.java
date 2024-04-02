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
	private double rentAmount; // A Product has-a rentAmount
	private double discountPercent; // A Product has-a discountPercent
	
	Product(double rent, double discount){
		this.rentAmount = rent;
		this.discountPercent = discount;
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

	@Override
	public String toString()
	{
		return "Rent: " + this.getRentAmount() + "\nDiscount: " + this.getDiscountPercentage() + "%" ;
	}
}
