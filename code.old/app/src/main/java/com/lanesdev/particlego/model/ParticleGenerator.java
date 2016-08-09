package com.lanesdev.particlego.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class ParticleGenerator
{
    //private static final int LONGITUDE_MAX = 180;
    //private static final int LATITUDE_MAX = 85;
    private static final double LONGITUDE_MAX = 0.00001;
    private static final double LATITUDE_MAX = 0.00003;
    private static final int POSSIBLE_PARTICLES_NO_CHAMBER = 3;
    private static final int POSSIBLE_PARTICLES_WITH_CHAMBER = 6;

    private static final Random r = new Random();

    public static Map<LatLng, Particle> generateParticles(final int number, final boolean hasBubbleChamber, final int userlevel)
    {
        final Map<LatLng, Particle>  particles = new HashMap<LatLng, Particle> ();
        for (int i = 0; i < number; i++)
        {
            MapParticle particle = generateParticle(hasBubbleChamber, userlevel);
            particles.put(particle.getLocation(),particle.getParticle());
        }
        return particles;
    }

    public static MapParticle generateParticle(final boolean hasBubbleChamber, final int userlevel)
    {
        //final double longitude = r.nextDouble() * 2 * LONGITUDE_MAX - LONGITUDE_MAX;
        //final double latitude = r.nextDouble() * 2 * LATITUDE_MAX - LATITUDE_MAX;
        //final double randNum = r.nextDouble();
        final double longitude = 6.054613 + r.nextDouble() * 2 * LONGITUDE_MAX - LONGITUDE_MAX;
        final double latitude = 46.230949 + r.nextDouble() * 2 * LATITUDE_MAX - LATITUDE_MAX;
        final double randNum = r.nextDouble();

        final double possibleParticlesNumber = hasBubbleChamber ? POSSIBLE_PARTICLES_WITH_CHAMBER : POSSIBLE_PARTICLES_NO_CHAMBER;


        String name = "Electron";

        if (userlevel == 1 )
        {
            name = "Proton";
        }
        if (userlevel == 2 )
        {
            name = "Neutron";
        }
        if (userlevel == 3 )
        {
            name = "Positron";
        }
        if (userlevel == 4 )
        {
            name = "Muon";
        }
        if (userlevel == 5 )
        {
            name = "Kaon";
        }
        if (userlevel == 6)
        {
            name = "Proton";
        }
        if (userlevel == 7)
        {
            name = "Neutron";
        }
        if (userlevel >= 8 && userlevel <= 10)
        {
            if(randNum > 0.5)
            {
                name = "Electron";
            } else {
                name = "Positron";
            }
        }
        if (userlevel > 10)
        {
            name = "Proton";
        }
        return new MapParticle(new Particle(name), new LatLng(latitude, longitude));
    }
}
