
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
 * Model a Camera object which is a type of Electronic
 */

// A Camera is-a Electronic
public class Camera extends Electronic
{
        // A Camera has-a megapixels
        private int megapixels;
        // A Camera has-a sensorWidth
        private int sensorWidth;
        // A Camera has-a sensorLength
        private int sensorLength;
        // A Camera has-a sensorArea
        private int sensorArea;
        
        public Camera(String manufacturer, String brand, String model)
        {
            super(manufacturer, brand, model);
        }

        public Camera(String manufacturer, String brand, String model, int megapixels, int sensorWidth, int sensorLength, int sensorArea)
        {
            super(manufacturer, brand, model);
            this.megapixels = megapixels;
            this.sensorWidth = sensorWidth;
            this.sensorLength = sensorLength;
            this.sensorArea = sensorArea;
        }

        /**
         * Set the megapixels of the Camera
         * @param megapixels
         */
        public void setMegapixels(int megapixels) 
        {
            this.megapixels = megapixels;
        }
        
        /**
         * Set the sensor width of the Camera
         * @param sensorWidth
         */
        public void setSensorWidth(int sensorWidth) 
        {
            this.sensorWidth = sensorWidth;
        }

        /**
         * Set the sensor length of the Camera
         * @param sensorLength
         */
        public void setSensorLength(int sensorLength) 
        {
            this.sensorLength = sensorLength;
        }

        /**
         * Set the sensor area of the Camera
         * @param sensorArea
         */
        public void setSensorArea(int sensorArea) 
        {
            this.sensorArea = sensorArea;
        }
        
        /**
         * Return the megapixels of the Camera
         * @return int
         */
        public int getMegapixels() 
        {
            return this.megapixels;
        };
        
        /**
         * Return the sensor width of the Camera
         * @return int
         */
        public int getSensorWidth() 
        {
            return this.sensorWidth;
        }

        /**
         * Return the sensor length of the Camera
         * @return int
         */
        public int getSensorLength() 
        {
            return this.sensorLength;
        }
        
        /**
         * Return the sensor area of the Camera
         * @return int
         */
        public int getSensorArea() 
        {
            return this.sensorArea;
        }

}

