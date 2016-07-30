package com.lanesdev.particlego.model;

import java.util.ArrayList;
import java.util.List;

public final class User
{
    private String name;
    private ArrayList<Particle> collectedParticles = new ArrayList<>();
    private List<String> collectedColliderParts = new ArrayList<>();
    private int collectedEnergy = 0;
    private int level = 6;

    public User(final String name)
    {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level)
    {
        this.level = level;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public ArrayList<Particle> getCollectedParticles()
    {
        return collectedParticles;
    }

    public void setCollectedParticles(final ArrayList<Particle> collectedParticles)
    {
        this.collectedParticles = collectedParticles;
    }

    public List<String> getCollectedColliderParts()
    {
        return collectedColliderParts;
    }

    public void setCollectedColliderParts(final List<String> collectedColliderParts)
    {
        this.collectedColliderParts = collectedColliderParts;
    }

    public int getCollectedEnergy()
    {
        return collectedEnergy;
    }

    public void setCollectedEnergy(final int collectedEnergy)
    {
        this.collectedEnergy = collectedEnergy;
    }

    public List<String> collectedParticlesNames()
    {
        List<String> particleNames = new ArrayList<>();
        for (final Particle p : this.collectedParticles)
        {
            particleNames.add(p.getName());
        }
        return particleNames;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", collectedParticles=" + collectedParticles +
                ", collectedColliderParts=" + collectedColliderParts +
                ", collectedEnergy=" + collectedEnergy +
                ", level=" + level +
                '}';
    }

    public void collectParticle(Particle particle) {
        this.collectedParticles.add(particle);
    }
}
