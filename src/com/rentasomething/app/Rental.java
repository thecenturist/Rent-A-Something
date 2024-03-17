package com.rentasomething.app;

public interface Rental
{
	double getRentAmount();
	
	void setRentAmount(double rent);
	
	void setDiscountPercentage(double discount);
	
	double getDiscountPercentage();
}
