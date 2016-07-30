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
import android.widget.Toast;

import com.lanesdev.particlego.model.User;
import com.lanesdev.particlego.service.LocationService;
import com.lanesdev.particlego.view.MapFragment;
import com.lanesdev.particlego.view.TabAdapter;

public class Controller extends AppCompatActivity {

    private LocationReceiver locationReceiver;
    private User user;
    private Location mCurrentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        User user = new User();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Map"));
        //tabLayout.addTab(tabLayout.newTab().setText("Particles"));
        //tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabAdapter adapter = new TabAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
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

}
