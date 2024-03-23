package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * 
 * References:
 * Version/date: March-21-2024
 * 
 * Responsibilities of class:
 * Model a Lodging object which is a Product
 */

// A Lodging is-a Product
public class Lodging extends Product
{
        // A Lodging has-a renter name
        private String renterName;
        // A Lodging has-a max capacity
        private int maxCapacity;

        public Lodging(String renterName, int maxCapacity)
        {
            super(0, 0);
            this.renterName = renterName;
            this.maxCapacity = maxCapacity;
        }

        public Lodging(String renterName, int maxCapacity, double rent, double discount)
        {
            super(rent, discount);
            this.renterName = renterName;
            this.maxCapacity = maxCapacity;
        }
        
        /**
         * Set the renter name of the Lodging
         * @param manufacturer
         */
        public void setRenterName(String renterName) 
        {
            this.renterName = renterName;
        }
        
        /**
         * Set the max capacity of the Lodging
         * @param maxCapacity
         */
        public void setMaxCapacity(int maxCapacity) 
        {
            this.maxCapacity = maxCapacity;
        }
        
        /**
         * Return the renter name of the Lodging
         * @return String
         */
        public String getRenterName() 
        {
            return this.renterName;
        };
        
        /**
         * Return the max capacity of the Lodging
         * @return int
         */
        public int getMaxCapacity() 
        {
            return this.maxCapacity;
        } 

}

