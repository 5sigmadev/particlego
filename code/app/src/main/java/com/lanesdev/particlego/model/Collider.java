package com.lanesdev.particlego.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.String;
import java.util.List;

public class Collider implements Parcelable
{
    private String name;
    private int maxEnergy;
    private String particle;
    private List<String> partsNeeded;

    public Collider(String name, int maxEnergy, String particle, List<String> partsNeeded) {
        this.name = name;
        this.maxEnergy = maxEnergy;
        this.particle = particle;
        this.partsNeeded = partsNeeded;
    }

    protected Collider(Parcel in) {
        name = in.readString();
        maxEnergy = in.readInt();
        particle = in.readString();
        partsNeeded = in.createStringArrayList();
    }

    public static final Creator<Collider> CREATOR = new Creator<Collider>() {
        @Override
        public Collider createFromParcel(Parcel in) {
            return new Collider(in);
        }

        @Override
        public Collider[] newArray(int size) {
            return new Collider[size];
        }
    };

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

    public String getParticleDiscovered() {
        return particle;
    }

    public void setParticleDiscovered(String particle) {
        this.particle = particle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(name);
        out.writeInt(maxEnergy);
        out.writeString(particle);
        out.writeStringList(partsNeeded);
    }
}