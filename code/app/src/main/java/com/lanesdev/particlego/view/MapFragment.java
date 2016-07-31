package com.lanesdev.particlego.view;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.lanesdev.particlego.Controller;
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
import com.lanesdev.particlego.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {


    private static final int DISTANCE_THRESHOLD = 30;
    private GoogleMap mMap;
    private Marker mCurrentPoint;
    private Map<LatLng, Particle> particleMapList;
    private User user;



    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        mMap = map;

        LatLng lhc = new LatLng(46.230374, 6.054298);
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(lhc));
        mMap.setOnMarkerClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lhc,15));
        particleMapList = generatePoints();
        populateMap(particleMapList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_tab_map, container, false);
        // Inflate the layout for this fragment
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);
        user = getArguments().getParcelable("USER");
        particleMapList = new HashMap<LatLng, Particle>();
        return rootView;
    }

    public void updateMap(Location location) {
        mCurrentPoint.remove();
        LatLng point = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(point));
    }

    private void populateMap(Map<LatLng, Particle> points){
        Iterator<Map.Entry<LatLng, Particle>> it = points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<LatLng, Particle> point = it.next();
            Bitmap drawableBitmap = BitmapFactory.decodeResource(getContext().getResources(),point.getValue().getResourceFromName());
            Bitmap bhalfsize=Bitmap.createScaledBitmap(drawableBitmap, drawableBitmap.getWidth()/10,drawableBitmap.getHeight()/10, false);
            mMap.addMarker(new MarkerOptions().position(point.getKey()).title(point.getValue().getName())
                                        .icon(BitmapDescriptorFactory.fromBitmap(bhalfsize)
                                        ));
        }
    }

    private Map<LatLng,Particle> generatePoints(){
        boolean hasCloudChamber = this.user.getLevel() > 2;
        return ParticleGenerator.generateParticles(10, hasCloudChamber, this.user.getLevel());
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(!marker.equals(mCurrentPoint)){
            double distance = distanceBetween(marker.getPosition());
            if(distance < DISTANCE_THRESHOLD){
                Particle p = particleMapList.get(marker.getPosition());
                ((Controller)getActivity()).collectParticle(p);
                marker.remove();
                particleMapList.remove(marker.getPosition());
                levelUp(p);   // MARCOLOGIC
                if(particleMapList.size() < 5){
                    particleMapList = generatePoints();
                    populateMap(particleMapList);
                }
                return true;
            }
        }
        return false;
    }

    private void levelUp(Particle p){
        if(user.getLevel() == 0 && p.getName() == "Electron"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        else if(user.getLevel() == 1 && p.getName() == "Proton"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        else if(user.getLevel() == 2 && p.getName() == "Neutron"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        else if(user.getLevel() == 3 && p.getName() == "Positron"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        else if(user.getLevel() == 4 && p.getName() == "Muon"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        else if(user.getLevel() == 5 && p.getName() == "Kaon"){
            user.setLevel(user.getLevel() + 1);
            user.setCollidersBuilt(user.getCollidersBuilt() + 1);
            restartMap();
            Toast.makeText(getContext(), "You have just leveled up!", Toast.LENGTH_SHORT).show();
        }
        ((Controller)getActivity()).updateStatus(user.getLevel());
    }

    private void restartMap() {
        mMap.clear();
        particleMapList = generatePoints();
        populateMap(particleMapList);
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
