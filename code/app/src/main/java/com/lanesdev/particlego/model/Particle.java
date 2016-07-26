package com.lanesdev.particlego.model;

/**
 * Created by Light on 26/07/16.
 */
public class Particle {

    public static final Object ITEMS = "";
    String name;

    public Particle() {
    }

    public Particle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
