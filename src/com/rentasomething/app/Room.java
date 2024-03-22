
package com.rentasomething.app;

import java.nio.file.ProviderNotFoundException;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * 
 * References:
 * Version/date: March-21-2024
 * 
 * Responsibilities of class:
 * Model a Room object which is a Lodging
 */

// A Room is-a Lodging
public class Room extends Lodging
{
        // A Room has-a room number
        private int roomNumber;
        // A Room has-a room price
        private int roomPrice;

        public Room(String renterName, int maxCapacity)
        {
            super(renterName, maxCapacity);
        }

        public Room(String renterName, int maxCapacity, int roomNumber, int roomPrice)
        {
            super(renterName, maxCapacity);
            this.roomNumber = roomNumber;
            this.roomPrice = roomPrice;
        }
        
        /**
         * Set the room number of the Room
         * @param roomNumber
         */
        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }
        
        /**
         * Set the room price of the Room
         * @param roomPrice
         */
        public void setRoomPrice(int roomPrice) {
            this.roomPrice = roomPrice;
        }
        
        /**
         * Return the room number of the Room
         * @return int
         */
        public int getRoomNumber() {
            return this.roomNumber;
        };
        
        /**
         * Return the room price of the Room
         * @return int
         */
        public int getRoomPrice() {
            return this.roomPrice;
        } 

}

