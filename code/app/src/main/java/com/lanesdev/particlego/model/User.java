package com.lanesdev.particlego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ppanero on 30/07/16.
 */
public class User {

    private List<Particle> particleList;

    public User(){
        this.particleList = new ArrayList<Particle>();
    }

    public User(List<Particle> particleList) {
        this.particleList = particleList;
    }
}
