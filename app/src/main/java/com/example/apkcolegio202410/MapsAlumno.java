package com.example.apkcolegio202410;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.EditText;

import com.example.util.Mensaje;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.apkcolegio202410.databinding.ActivityMapsAlumnoBinding;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsAlumno extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMapClickListener{

    private GoogleMap mMap;
    private ActivityMapsAlumnoBinding binding;
    private LocationManager ubicacion;
    private EditText txtLati, txtLong, txtDir;
    private Marker marcador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsAlumnoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        txtLati = (EditText) findViewById(R.id.FrmMap_txtLatitud);
        txtLong = (EditText) findViewById(R.id.FrmMap_txtLongitud);
        txtDir = (EditText) findViewById(R.id.FrmMap_txtDir);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getActGPS();
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
    }

    public void getActGPS(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
            },1000);
        }
        mMap.setMyLocationEnabled(true);
        ubicacion = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc=ubicacion.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        ubicacion.requestLocationUpdates(LocationManager.GPS_PROVIDER,1500,0,GPSLocal);
        getUpLocation(loc);
    }

    LocationListener GPSLocal=new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            getUpLocation(location);

        }
    };

    public void getMarcador(double lat, double log,String nom) {
        try {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(lat, log);
            CameraUpdate miubi = CameraUpdateFactory.newLatLngZoom(sydney, 17);
            if(marcador!=null)marcador.remove();
            marcador = mMap.addMarker(new MarkerOptions()
                    .position(sydney)
                    .title(nom)
                    .draggable(true));
            marcador.showInfoWindow();
            mMap.animateCamera(CameraUpdateFactory.zoomTo(17));
            mMap.animateCamera(miubi);

            Geocoder geo=new Geocoder(getApplicationContext(), Locale.getDefault());
            List<Address> dir= null;
                dir = geo.getFromLocation(lat,log,1);
                txtDir.setText(""+dir.get(0).getAddressLine(0));
                txtLati.setText(""+lat);
                txtLong.setText(""+log);
        } catch (IOException e)
        {getMensaje("Error getMarcador:"+e.getMessage());}
    }

    public void getUpLocation(Location loc){
        if(loc!=null){
            double log=loc.getLongitude();
            double lat=loc.getLatitude();
            Geocoder geo=new Geocoder(getApplicationContext(), Locale.getDefault());
            try{
                List<Address> dir=geo.getFromLocation(lat,log,1);
                String direccion="Pais:"+dir.get(0).getCountryName()
                        +" Capital:"+dir.get(0).getAdminArea()
                        +" Distrito:"+dir.get(0).getLocality();
                getMarcador(lat,log,direccion);
            }catch (IOException ex){getMensaje("Error GPS - Address getUpLo:");}
        }else getMensaje("Error GPS");
    }

    public void getMensaje(String men){
        new Mensaje(this).getMensaje(men).show();
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        double lat=latLng.latitude;
        double log=latLng.longitude;
        getMarcador(lat,log,null);

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        /*double lat=marker.getPosition().latitude;
        double log=marker.getPosition().longitude;
        getMarcador(lat,log,null);*/
        getMensaje("Hola MarkerClick");
        return false;
    }


}