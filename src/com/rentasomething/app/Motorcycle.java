package com.rentasomething.app;

/**
 * Lead Author(s):
 * @author Kaitlyn Nguy
 * 
 * References:
 * Version/date: March-18-2024
 * 
 * Responsibilities of class:
 * Model a Motorcycle object which is a type of Vehicle
 */

// A Motorcycle is-a Vehicle
public class Motorcycle extends Vehicle
{
    // A Motorycycle has-a weight, in kilograms
    private double weight;
    // A Boat has-a powerOutput, in CC
    private double powerOutput;
    
    public Motorcycle(String manufacturer, String model, int year)
    {
        super(manufacturer, model, year);
    }
    
    public Motorcycle(String manufacturer, String model, int weight, int powerOutput)
    {
        super(manufacturer, model, year);
        this.weight = weight;
        this.powerOutput = powerOutput;
    }
    
    /**
     * Set the weight (kg) of the Motorcycle
     * @param weight
     */
    public void setWeight(double weight) {
        // assumes weight to new weight
        this.weight = weight;
    }

    /**
     * Return the weight (kg) of the Motorcycle
     * @return double
     */
    public double getWeight() {
        // returns the result
        return this.weight;
    }

        /**
     * Set the power output (cc) of the Motorcycle
     * @param powerOutput
     */
    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }
    
    /**
     * Return the power output (cc) of the Motorcycle
     * @return double
     */
    public double powerOutput() {
        return this.powerOutput;
    }
}

