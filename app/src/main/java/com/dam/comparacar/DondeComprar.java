package com.dam.comparacar;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DondeComprar extends FragmentActivity implements OnMapReadyCallback {
    Modelo mod;
    private GoogleMap mMap;
    boolean mapReady = false;
    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 1;
    LatLngBounds.Builder builder;

    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donde_comprar);

        mod = (Modelo) getApplication();

        Bundle bundle = getIntent().getExtras();
        posicion = bundle.getInt("posicion");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_FINE_LOCATION);
        } else {
//            setMarkers();
            setCamera();
            mapReady = true;
        }

//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
//        {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                if(marker.isInfoWindowShown()) {
//                    marker.hideInfoWindow();
//                } else {
//                    marker.showInfoWindow();
//                    ObjectAnimator animation = ObjectAnimator.ofFloat(bola, "translationY", -128f);
//                    animation.setDuration(500);
//                    animation.start();
//                }
//
//                return false;
//            }
//        });
    }

    private void setCamera() {
        // Añadir marcadores de los concesionarios
        builder = new LatLngBounds.Builder();
        // Marcador concesionario 1
        MarkerOptions opcionesMarcador = new MarkerOptions()
                .position(new LatLng(mod.listadoCoches.get(posicion).getLat1(), mod.listadoCoches.get(posicion).getLong1()))
                .title(mod.listadoCoches.get(posicion).getConcesionario1())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        Marker marcador = mMap.addMarker(opcionesMarcador);
//        marcador.setTag(aloj);
        builder.include(marcador.getPosition());

        // Marcador concesionario 2
        opcionesMarcador = new MarkerOptions()
                .position(new LatLng(mod.listadoCoches.get(posicion).getLat2(), mod.listadoCoches.get(posicion).getLong2()))
                .title(mod.listadoCoches.get(posicion).getConcesionario2())
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        marcador = mMap.addMarker(opcionesMarcador);
//        marcador.setTag(aloj);
        builder.include(marcador.getPosition());

        LatLngBounds bounds = builder.build();
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 150));
    }


}
