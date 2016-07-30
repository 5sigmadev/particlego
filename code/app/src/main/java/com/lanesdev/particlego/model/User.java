package com.lanesdev.particlego.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public final class User implements Parcelable {
    private String name;
    private ArrayList<Particle> collectedParticles = new ArrayList<>();
    private List<String> collectedColliderParts = new ArrayList<>();
    private int collectedEnergy = 0;
    private int level = 0;
    private int collidersBuilt = 5;
    private int energy;

    public User(final String name)
    {
        this.name = name;
        this.energy = 100000;
    }

    protected User(Parcel in) {
        name = in.readString();
        collectedParticles = in.createTypedArrayList(Particle.CREATOR);
        collectedColliderParts = in.createStringArrayList();
        collectedEnergy = in.readInt();
        level = in.readInt();
        collidersBuilt = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level)
    {
        this.level = level;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(final int energy)
    {
        this.energy = energy;
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

    public int getCollidersBuilt() {
        return collidersBuilt;
    }

    public void setCollidersBuilt(int collidersBuilt) {
        this.collidersBuilt = collidersBuilt;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeTypedList(collectedParticles);
        parcel.writeStringList(collectedColliderParts);
        parcel.writeInt(collectedEnergy);
        parcel.writeInt(level);
        parcel.writeInt(collidersBuilt);
    }

    public void removeParticleByName(String name, int i) {
        int j = 0;
        List<Particle> toRemove = new ArrayList<>();
        while(i > 0 && j < collectedParticles.size()) {

            Particle p = collectedParticles.get(j);
            if(p.getName().equalsIgnoreCase(name)){
                toRemove.add(p);
                i -= 1;
                Log.e("TAG", "one taken out");
            }
            j++;
            Log.e("TAG", "p skipped not matched");
        }
        for (Particle p : toRemove){
            collectedParticles.remove(p);
        }
    }
}
