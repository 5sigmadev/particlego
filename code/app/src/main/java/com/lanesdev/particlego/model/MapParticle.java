package com.lanesdev.particlego.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ppanero on 30/07/16.
 */
public class MapParticle {

    private Particle particle;
    private LatLng location;

    public MapParticle(Particle particle, LatLng location) {
        this.particle = particle;
        this.location = location;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public Particle getParticle() {
        return particle;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }
}
