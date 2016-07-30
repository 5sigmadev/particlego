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
import com.lanesdev.particlego.model.Particle;

import java.util.ArrayList;
import java.util.List;


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
        markerList = new ArrayList<Marker>();
        particleList = new ArrayList<Particle>();

        LatLng lhc = new LatLng(46.230374, 6.054298);
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(lhc));
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lhc));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_tab_map, container, false);
        // Inflate the layout for this fragment
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
        populateMap(generatePoints());
        return rootView;
    }

    public void updateMap(Location location) {
        mCurrentPoint.remove();
        LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(point));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point));
    }

    private void populateMap(List<LatLng> points){
        for(LatLng point : points){
            markerList.add(mMap.addMarker(new MarkerOptions().position(point)));
        }
    }

    private List<LatLng> generatePoints(){
        //Logic later
        return new ArrayList<LatLng>();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(!marker.equals(mCurrentPoint)){
            if(distanceBetween(marker.getPosition()) > DISTANCE_THRESHOLD){
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
