package com.lanesdev.particlego.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.lanesdev.particlego.R;

/**
 * Created by Light on 26/07/16.
 */
public class Particle implements Parcelable {

    private String name;
    private int charge;
    private String composition;
    private double mass;
    private String massUnit;
    private double lifetime;
    private String timeUnit;
    private int itemIcon;

    public Particle(String name){
        this.name = name;
        this.itemIcon = getResourceFromName();
    }

    public Particle(String name, int charge, String composition, double mass, String massUnit,
                    double lifetime, String timeUnit) {
        this.name = name;
        this.charge = charge;
        this.composition = composition;
        this.mass = mass;
        this.massUnit = massUnit;
        this.lifetime = lifetime;
        this.timeUnit = timeUnit;
        this.itemIcon = getResourceFromName();
    }

    protected Particle(Parcel in) {
        name = in.readString();
        charge = in.readInt();
        composition = in.readString();
        mass = in.readDouble();
        massUnit = in.readString();
        lifetime = in.readDouble();
        timeUnit = in.readString();
        itemIcon = in.readInt();
    }

    public static final Creator<Particle> CREATOR = new Creator<Particle>() {
        @Override
        public Particle createFromParcel(Parcel in) {
            return new Particle(in);
        }

        @Override
        public Particle[] newArray(int size) {
            return new Particle[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getMassUnit() {
        return massUnit;
    }

    public void setMassUnit(String massUnit) {
        this.massUnit = massUnit;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public double getLifetime() {
        return lifetime;
    }

    public void setLifetime(double lifetime) {
        this.lifetime = lifetime;
    }

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(name);
        out.writeInt(charge);
        out.writeString(composition);
        out.writeDouble(mass);
        out.writeString(massUnit);
        out.writeDouble(lifetime);
        out.writeString(timeUnit);
        out.writeInt(itemIcon);
    }

    public String getDescription() {
        return "Lorem Ipsum";
    }

    public int getResourceFromName(){
        switch(this.name){
            case "Electron":
                return R.drawable.electron;
            case "Proton":
                return R.drawable.proton;
            case "Neutron":
                return R.drawable.neutron;
            case "Muon":
                return R.drawable.muon;
            case "Positron":
                return R.drawable.positron;
            case "Kaon":
                return R.drawable.kaon;
            default:
                return R.drawable.electron;

        }
    }
}
