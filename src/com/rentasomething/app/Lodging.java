package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * @author Anjolaoluwa Akinremi
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
        // A Lodging has-a renter
        private Person renter;
        // A Lodging has-a max capacity
        private int maxCapacity;

        public Lodging(Person renter, int maxCapacity)
        {
            super(0, 0);
            this.renter = renter;
            this.maxCapacity = maxCapacity;
        }

        public Lodging(Person renter, int maxCapacity, double rent, double discount)
        {
            super(rent, discount);
            this.renter = renter;
            this.maxCapacity = maxCapacity;
        }
        
        /**
         * Set the renter of the Lodging
         * @param renter
         */
        public void setRenterName(Person renter) 
        {
            this.renter = renter;
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
         * Return the renter of the Lodging
         * @return Person
         */
        public Person getRenter() 
        {
            return this.renter;
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

