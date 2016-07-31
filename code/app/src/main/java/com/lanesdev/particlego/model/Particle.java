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
        return "";
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

    /* PARTICLE LIST

    particleList.add(new Particle("Pion+",1,"u + anti-d",0.139,"GeV",26,"ns"));
    particleList.add(new Particle("Pion-",-1,"d + anti-u",0.139,"GeV",26,"ns"));
    particleList.add(new Particle("Pion0",0,"u + anti-u or d + anti-d",0.134,"GeV",85,"as"));
    particleList.add(new Particle("Eta",0,"u + anti-u or d + anti-d or s + anti-s",0.547,"GeV",500,"zs"));
    particleList.add(new Particle("Kaon+",1,"u + anti-s ",0.493,"GeV",12.4,"ns"));
    particleList.add(new Particle("Kaon-",-1,"s + anti-u",0.493,"GeV",12.4,"ns"));
    particleList.add(new Particle("Kaon0",0,"s + anti-s",0.497,"GeV",51,"ns"));
    particleList.add(new Particle("D+",1,"c + anti-d",1.870,"GeV",1,"ps"));
    particleList.add(new Particle("D-",-1,"d + anti-c",1.870,"GeV",1,"ps"));
    particleList.add(new Particle("D0",0,"c + anti-u",1.865,"GeV",410,"fs"));
    particleList.add(new Particle("Strange D+",1,"c + anti s",1.968,"GeV",500,"fs"));
    particleList.add(new Particle("Strange D-",-1,"s + anti c",1.968,"GeV",500,"fs"));
    particleList.add(new Particle("B+",1,"u + anti-b",5.279,"GeV",1.6,"ps"));
    particleList.add(new Particle("B-",-1,"b + anti-u",5.279,"GeV",1.6,"ps"));
    particleList.add(new Particle("B0",0,"d + anti-b",5.279,"GeV",1.5,"ps"));
    particleList.add(new Particle("Strange B0",0,"s + anti-b",5.367,"GeV",1.5,"ps"));
    particleList.add(new Particle("Charm B+",1,"c + anti-b",6.276,"GeV",452,"fs"));
    particleList.add(new Particle("Charm B+",-1,"b + anti-c",6.276,"GeV",452,"fs"));
    particleList.add(new Particle("J/Psi",0,"c + anti-c",3.097,"GeV",7.2,"zs"));
    particleList.add(new Particle("Upsilon",0,"b + anti-b",9.460,"GeV",12,"zs"));
    particleList.add(new Particle("Proton",1,"uud",0.938,"GeV",0,"big"));
    particleList.add(new Particle("Neutron",0,"udd",0.940,"GeV",880,"s"));
    particleList.add(new Particle("Delta++",2,"uuu",1.232,"GeV",5.6,"ys"));
    particleList.add(new Particle("Delta+",1,"uud",1.232,"GeV",5.6,"ys"));
    particleList.add(new Particle("Delta0",0,"udd",1.232,"GeV",5.6,"ys"));
    particleList.add(new Particle("Delta-",-1,"ddd",1.232,"GeV",5.6,"ys"));
    particleList.add(new Particle("Lambda",0,"uds",1.116,"GeV",263,"ps"));
    particleList.add(new Particle("Sigma+",1,"uus",1.189,"GeV",80,"ps"));
    particleList.add(new Particle("Sigma0",0,"uds",1.193,"GeV",80,"ps"));
    particleList.add(new Particle("Sigma-",-1,"dds",1.197,"GeV",80,"ps"));
    particleList.add(new Particle("Xi0",0,"uss",1.315,"GeV",290,"ps"));
    particleList.add(new Particle("Xi-",-1,"dss",1.322,"GeV",290,"ps"));
    particleList.add(new Particle("Omega-",-1,"sss",1.672,"GeV",82,"ps"));
    particleList.add(new Particle("Charm Lambda+",1,"udc",2.286,"GeV",20,"fs"));
    particleList.add(new Particle("Charm Sigma++",2,"uuc",2.454,"GeV",0,"low"));
    particleList.add(new Particle("Charm Sigma+",1,"udc",2.453,"GeV",0,"low"));
    particleList.add(new Particle("Charm Sigma0",0,"ddc",2.454,"GeV",0,"low"));
    particleList.add(new Particle("Charm Xi+",1,"usc",2.468,"GeV",442,"fs"));
    particleList.add(new Particle("Charm Xi0",0,"dsc",2.471,"GeV",112,"fs"));
    particleList.add(new Particle("Charm Omega0",0,"ssc",2.695,"GeV",69,"fs"));
    particleList.add(new Particle("Bottom Lambda0",0,"udb",5.620,"GeV",1.4,"ps"));
    particleList.add(new Particle("Bottom Xi0",0,"usb",5.793,"GeV",1.49,"ps"));
    particleList.add(new Particle("Bottom Xi-",-1,"dsb",5.795,"GeV",1.56,"ps"));
    particleList.add(new Particle("Bottom Omega-",-1,"ssb",6.049,"GeV",1.1,"ps"));

     */
}
