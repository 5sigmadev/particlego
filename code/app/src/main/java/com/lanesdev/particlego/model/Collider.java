package com.lanesdev.particlego.model;

import java.lang.String;
import java.util.List;

public class Collider
{
    private String name;
    private int maxEnergy;
    private int level;
    private String particle;
    private List<String> partsNeeded;

    public Collider(String name, int maxEnergy, int level, String particle, List<String> partsNeeded) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.level = level;
        this.particle = particle;
        this.partsNeeded = partsNeeded;
    }

    public List<String> getPartsNeeded() {
        return partsNeeded;
    }

    public void setPartsNeeded(List<String> partsNeeded) {
        this.partsNeeded = partsNeeded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getParticleDiscovered() {
        return particle;
    }

    public void setParticleDiscovered(String particle) {
        this.particle = particle;
    }
}