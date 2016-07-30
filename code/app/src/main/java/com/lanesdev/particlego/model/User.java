package com.lanesdev.particlego.model;

import java.util.ArrayList;
import java.util.List;

public final class User
{
    private String name;
    private List<Particle> collectedParticles = new ArrayList<>();
    private List<ColliderPart> collectedColliderParts = new ArrayList<>();
    private int collectedEnergy = 0;
    private int level = 0;

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

    public List<Particle> getCollectedParticles()
    {
        return collectedParticles;
    }

    public void setCollectedParticles(final List<Particle> collectedParticles)
    {
        this.collectedParticles = collectedParticles;
    }

    public List<ColliderPart> getCollectedColliderParts()
    {
        return collectedColliderParts;
    }

    public void setCollectedColliderParts(final List<ColliderPart> collectedColliderParts)
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
            particleNames.add(p.getName())
        }
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
}
