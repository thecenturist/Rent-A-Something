package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Anjolaoluwa Akinremi
 * 
 * References:
 * Version/date: March-9-2024
 * 
 * Responsibilities of interface:
 * Enforce requirements for a Rental object
 */

public interface Rental
{
	double getRentAmount();
	
	void setRentAmount(double rent);
	
	void setDiscountPercentage(double discount);
	
	double getDiscountPercentage();
}
