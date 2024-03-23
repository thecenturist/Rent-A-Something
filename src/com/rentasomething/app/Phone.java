package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * 
 * References:
 * Version/date: March-21-2024
 * 
 * Responsibilities of class:
 * Model a Phone object which is a type of Electronic
 */

// A Phone is-a Electronic
public class Phone extends Electronic
{
        // A Phone has-a mass
        private int mass;
        // A Phone has-a CPU
        private String CPU;
        // A Phone has-a numberOfCameras
        private int numberOfCameras;
        
        public Phone(String manufacturer, String brand, String model)
        {
            super(manufacturer, brand, model);
        }

        public Phone(String manufacturer, String brand, String model, int mass, String CPU, int numberOfCameras)
        {
            super(manufacturer, brand, model);
            this.mass = mass;
            this.CPU = CPU;
            this.numberOfCameras = numberOfCameras;
        }

        /**
         * Set the mass of the Phone
         * @param mass
         */
        public void setMass(int mass) 
        {
            this.mass = mass;
        }
        
        /**
         * Set the CPU of the Phone
         * @param CPU
         */
        public void setCPU(String CPU) 
        {
            this.CPU = CPU;
        }

        /**
         * Set the number of cameras of the Phone
         * @param numberOfCameras
         */
        public void setNumberOfCameras(int numberOfCameras) 
        {
            this.numberOfCameras = numberOfCameras;
        }
        
        /**
         * Return the mass of the Phone
         * @return int
         */
        public int getMass() 
        {
            return this.mass;
        };
        
        /**
         * Return the CPU of the Phone
         * @return String
         */
        public String getCPU() 
        {
            return this.CPU;
        }

        /**
         * Return the number of cameras of the Phone
         * @return int
         */
        public int getNumberOfCameras() 
        {
            return this.numberOfCameras;
        }

}

