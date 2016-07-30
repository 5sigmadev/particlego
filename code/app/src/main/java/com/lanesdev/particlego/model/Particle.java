package com.lanesdev.particlego.model;

/**
 * Created by Light on 26/07/16.
 */
public class Particle {

    private String name;
    private double energy;
    private double probability;
    private String image;
    private String description;

    public Particle(String name, double energy, double probability, String description, String image) {
        this.name = name;
        this.energy = energy;
        this.probability = probability;
        this.description = description;
        this.image = image;
    }

    public Particle() {
        this.name = "Electron";
        this.energy = 0;
        this.probability = 0;
        this.image = "";
        this.description = "";
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
