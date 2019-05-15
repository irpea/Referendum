package com.irpea.referendum;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapFragment extends SupportMapFragment {
    private static final String TAG = "MapFragment";
    private static final String[] LOCATION_PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
    };
    private static final int REQUEST_LOCATION_PERMISSIONS = 0;

    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private Location mCurrentLocation;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);

        mClient = new GoogleApiClient.Builder(getContext())
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        getActivity().invalidateOptionsMenu();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                })
                .build();

        getMapAsync( new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                updateUI();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        getActivity().invalidateOptionsMenu();
        mClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        mClient.disconnect();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.activity_fragment, menu);
        MenuItem searchItem = menu.findItem(R.id.action_locate);
        searchItem.setEnabled(mClient.isConnected());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_menu:
                return true;
            case R.id.action_locate:
                if(hasLocationPermission()) {
                    locate();
                } else {
                    requestPermissions(LOCATION_PERMISSIONS, REQUEST_LOCATION_PERMISSIONS);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_LOCATION_PERMISSIONS:
                if(hasLocationPermission()){
                    locate();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @SuppressLint("MissingPermission")
    private void locate(){
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setNumUpdates(1);
        request.setInterval(0);
        LocationServices.FusedLocationApi.requestLocationUpdates(mClient, request, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i(TAG, "Got a fix: " + location);
                new SearchTask().execute(location);
            }
        });
    }

    private boolean hasLocationPermission(){
        int result = ContextCompat.checkSelfPermission(getActivity(), LOCATION_PERMISSIONS[0]);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void updateUI(){
        if(mMap == null || mCurrentLocation == null){
            return;
        }

        ReferendumLab referendumLab = ReferendumLab.get(getActivity());
        List<ReferendumItem> referendumLocationList = referendumLab.getReferendumLocationList();

        LatLng[] items = new LatLng[17];
        MarkerOptions[] marker = new MarkerOptions[17];

        for(int i=0;i<17;i++) {
            items[i] = new LatLng(referendumLocationList.get(i).getLat(), referendumLocationList.get(i).getLon());
            marker[i] = new MarkerOptions().position(items[i]).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_edit_location_blue_800_36dp)).title(referendumLocationList.get(i).getCaption());

        }

        LatLng myPoint = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());

        MarkerOptions myMarker = new MarkerOptions()
                .position(myPoint);

        mMap.clear();
        mMap.addMarker(myMarker);
        for(int i=0; i<17;i++) {
            mMap.addMarker(marker[i]);
        }

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(myPoint)
                .include(items[0])
                .include(items[1])
                .include(items[2])
                .include(items[3])
                .include(items[4])
                .include(items[5])
                .include(items[6])
                .include(items[7])
                .include(items[8])
                .include(items[9])
                .include(items[10])
                .include(items[11])
                .include(items[12])
                .include(items[13])
                .include(items[14])
                .include(items[15])
                .include(items[16])
                .build();

        int margin = getResources().getDimensionPixelSize(R.dimen.map_insert_margin);
        CameraUpdate update = CameraUpdateFactory.newLatLngBounds(bounds, margin);
        mMap.animateCamera(update);
    }

    private class SearchTask extends AsyncTask<Location, Void, Void>{
        private Location mLocation;

        @Override
        protected Void doInBackground(Location... locations) {
            mLocation = locations[0];
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mCurrentLocation = mLocation;
            updateUI();
        }
    }
}
