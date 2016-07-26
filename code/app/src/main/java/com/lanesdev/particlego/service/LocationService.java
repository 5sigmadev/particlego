package com.lanesdev.particlego.service;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.lanesdev.particlego.commons.Lock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class LocationService extends Service {

    private static final String TAG = "LOCATION SERVICE";
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
    private IBinder mBinder;
    private Lock lock;


    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        Log.d("TAG", "onCreate SensorService");
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        mBinder = new LocalBinder();
        lock = new Lock();
        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                android.os.Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "location service destroyed", Toast.LENGTH_SHORT).show();
    }

    public Location getCurrentLocation() {
        Location aux = null;
        try {
            lock.lock();
            aux = mServiceHandler.getCurrentValues();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return aux;
    }

    public void start() {
        if (!mServiceHandler.isStarted()) {
            this.mServiceHandler.startHandlerWork();
        } else {
            Log.d(TAG, "Sensors were already started");
        }
    }

    public void stop() {
        if (mServiceHandler.isStarted()) {
            this.mServiceHandler.stopHandlerWork();
        } else {
            Log.d(TAG, "Sensors were already stopped");
        }
    }

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler implements com.google.android.gms.location.LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

        private boolean started;
        private GoogleApiClient mGoogleApiClient;
        private LocationRequest mLocationRequest;
        private Location mCurrentLocation;
        private boolean mRequestUpdates;

        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            started = false;
            buildGoogleApiClient();
            mGoogleApiClient.connect();
            mRequestUpdates = true;
            createLocationRequest();
            startHandlerWork();
        }

        public boolean isStarted() {
            return this.started;
        }

        public void startHandlerWork() {
            if (!mGoogleApiClient.isConnected()) {
                mGoogleApiClient.connect();
            }
            if (!mRequestUpdates) {
                startLocationUpdates();
            }
            started = true;
            Log.d(TAG, "Sensors started");
        }

        public void stopHandlerWork() {
            stopLocationUpdates();
            if (mGoogleApiClient.isConnected()) {
                mGoogleApiClient.disconnect();
            }
            started = false;
            Log.d(TAG, "Sensors stopped");
        }

        protected synchronized void buildGoogleApiClient() {
            mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        @Override
        public void onConnected(Bundle connectionHint) {
            Log.d(TAG, "Google Play Services API Connected");
            if (mRequestUpdates) {
                startLocationUpdates();
            }
        }


        @Override
        public void onConnectionSuspended(int i) {

        }

        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
            Log.e(TAG, connectionResult.getErrorMessage());
        }


        @Override
        public void onLocationChanged(Location location) {
            try {
                lock.lock();
                Log.d(TAG, "new location update");
                mCurrentLocation = location;
                lock.unlock();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        protected void createLocationRequest() {
            mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(10000);
            mLocationRequest.setFastestInterval(5000);
            mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        }

        protected void startLocationUpdates() {
            if (!mGoogleApiClient.isConnected()) {
                mGoogleApiClient.connect();
            }
            mRequestUpdates = true;
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

        protected void stopLocationUpdates() {
            if(mGoogleApiClient.isConnected()) {
                mRequestUpdates = false;
                LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            }
        }

        public Location getCurrentValues() {
            return mCurrentLocation;
        }

    }

    public class LocalBinder extends Binder {
        public LocationService getService() {
            return LocationService.this;
        }
    }

}