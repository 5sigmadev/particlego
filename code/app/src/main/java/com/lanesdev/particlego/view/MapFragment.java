package com.lanesdev.particlego.view;


import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.maps.model.Marker;
import com.lanesdev.particlego.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lanesdev.particlego.model.MapParticle;
import com.lanesdev.particlego.model.Particle;
import com.lanesdev.particlego.model.ParticleGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private static final int DISTANCE_THRESHOLD = 10;
    private GoogleMap mMap;
    private Marker mCurrentPoint;
    private List<Marker> markerList;
    private List<Particle> particleList;


    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        mMap = map;

        LatLng lhc = new LatLng(46.230374, 6.054298);
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(lhc));
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lhc));
        populateMap(generatePoints());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_tab_map, container, false);
        // Inflate the layout for this fragment
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
        markerList = new ArrayList<Marker>();
        particleList = new ArrayList<Particle>();
        return rootView;
    }

    public void updateMap(Location location) {
        mCurrentPoint.remove();
        LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(point));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point));
    }

    private void populateMap(Map<LatLng, Particle> points){
        Iterator<Map.Entry<LatLng, Particle>> it = points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<LatLng, Particle> point = it.next();
            markerList.add(mMap.addMarker(new MarkerOptions().title(point.getValue().getName()).position(point.getKey())));
        }
    }

    private Map<LatLng,Particle> generatePoints(){
        return ParticleGenerator.generateParticles(5, true);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(!marker.equals(mCurrentPoint)){
            double distance = distanceBetween(marker.getPosition());
            if(distance > DISTANCE_THRESHOLD){
                marker.remove();
            }
        }
        return false;
    }

    private double distanceBetween(LatLng point) {

        Location currentLoc = new Location(LocationManager.GPS_PROVIDER);
        Location pointLoc = new Location(LocationManager.GPS_PROVIDER);

        currentLoc.setLatitude(mCurrentPoint.getPosition().latitude);
        currentLoc.setLongitude(mCurrentPoint.getPosition().longitude);

        pointLoc.setLatitude(point.latitude);
        pointLoc.setLongitude(point.longitude);


        return currentLoc.distanceTo(pointLoc);
    }
}
