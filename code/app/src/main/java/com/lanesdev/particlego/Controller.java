package com.lanesdev.particlego;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.lanesdev.particlego.model.Collider;
import com.lanesdev.particlego.model.Particle;
import com.lanesdev.particlego.model.User;
import com.lanesdev.particlego.service.LocationService;
import com.lanesdev.particlego.view.ExperimentFragment;
import com.lanesdev.particlego.view.MapFragment;
import com.lanesdev.particlego.view.TabAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Controller extends AppCompatActivity {

    private LocationReceiver locationReceiver;
    private User user;
    private Location mCurrentLocation;
    private HashMap<Integer, Collider> colliders = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.user = new User("Crazy physicist");
        populateColliders();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        tabLayout.addTab(tabLayout.newTab().setText("Experiment"));
        //tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), this.user, this.colliders);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onStart() {
        //Register BroadcastReceiver
        //to receive event from our service
        locationReceiver = new LocationReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LocationService.LOCATION_UPDATE);
        registerReceiver(locationReceiver, intentFilter);

        //Start our own service
        Intent intent = new Intent(this, LocationService.class);
        startService(intent);

        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(locationReceiver);
        stopService(new Intent(this, LocationService.class));
        super.onStop();
    }

    private void populateColliders()
    {
        Collider bubbleChamber0 = new Collider("Bubble Chamber", 0, "Electron", new ArrayList<String>());
        Collider bubbleChamber1 = new Collider("Bubble Chamber", 0, "Proton", new ArrayList<String>());
        Collider bubbleChamber2 = new Collider("Bubble Chamber", 0, "Neutron", new ArrayList<String>());
        Collider bubbleChamber3 = new Collider("Bubble Chamber", 0, "Positron", Arrays.asList("Magnets", "Chamber", "Water"));
        Collider bubbleChamber4 = new Collider("Bubble Chamber", 0, "Muon", new ArrayList<String>());
        Collider bubbleChamber5 = new Collider("Bubble Chamber", 0, "Kaon", new ArrayList<String>());
        Collider bevatron = new Collider("Bevatron", 1, "Antiproton", Arrays.asList("Magnets", "Vacuum chamber"));
        Collider poltergeist = new Collider("Poltergeist", 0, "Neutrino", Arrays.asList("Reactor", "Chemicals"));
        Collider slack0 = new Collider("SLAC", 90, "Quarks", Arrays.asList("Magnets", "Beam pipe"));
        Collider slack1 = new Collider("SLAC", 90, "J/psi", new ArrayList<String>());
        Collider doris = new Collider("Doris", 10, "Gluon", Arrays.asList("Magnets", "Beam pipe", "Detector"));
        Collider sps0 = new Collider("SPS", 540, "W", Arrays.asList("Magnets", "Beam pipe", "Detector", "Controlling system"));
        Collider sps1 = new Collider("SPS", 540, "Z", new ArrayList<String>());
        Collider lhc = new Collider("LHC", 14000, "Higgs boson", Arrays.asList("Magnets", "Beam pipe", "Detector", "Controlling system", "Liquid helium"));

        this.colliders.put(0, bubbleChamber0);
        this.colliders.put(1, bubbleChamber1);
        this.colliders.put(2, bubbleChamber2);
        this.colliders.put(3, bubbleChamber3);
        this.colliders.put(4, bubbleChamber4);
        this.colliders.put(5, bubbleChamber5);
        this.colliders.put(6, bevatron);
        this.colliders.put(7, poltergeist);
        this.colliders.put(8, slack0);
        this.colliders.put(9, slack1);
        this.colliders.put(10, doris);
        this.colliders.put(11, sps0);
        this.colliders.put(12, sps1);
        this.colliders.put(13, lhc);
    }

    private class LocationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {

            mCurrentLocation = arg1.getParcelableExtra("LOCATION");
            Toast.makeText(getApplicationContext(), "New Location Received at Main Activity", Toast.LENGTH_SHORT).show();
            FragmentManager supportFragment = getSupportFragmentManager();
            if(supportFragment.getFragments().size() > 0) {
                MapFragment mapFragment = (MapFragment) (supportFragment.getFragments().get(0));
                if (mapFragment != null)
                    mapFragment.updateMap(mCurrentLocation);
            }

        }
    }

    public void collectParticle(Particle p){
        if(p != null) {
            this.user.collectParticle(p);
            FragmentManager supportFragment = getSupportFragmentManager();
            if (supportFragment.getFragments().size() == 2) {
                ExperimentFragment experimentFragment = (ExperimentFragment) (supportFragment.getFragments().get(1));
                if (experimentFragment != null)
                    experimentFragment.refresh();
            }
            Log.e("TAG", String.valueOf(this.user.getCollectedParticles().size()));
        }
    }

}
