package com.lanesdev.particlego.model;

/**
 * Created by Light on 26/07/16.
 */
public class Particle {

    private String name;
    private double energyThreshold;
    private double probability;
    private String description;

    public Particle(String name){
        this.name = name;
        this.energyThreshold = -1;
        this.probability = -1;
        this.description = "";
    }

    public Particle(String name, double energy, double probability, String description) {
        this.name = name;
        this.energyThreshold = energy;
        this.probability = probability;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getEnergyThreshold() {
        return energyThreshold;
    }

    public void setEnergyThreshold(double energyThreshold) {
        this.energyThreshold = energyThreshold;
    }
}
