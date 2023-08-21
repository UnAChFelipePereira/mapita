package com.example.mapita.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mapita.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_map,container,false);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.MY_MAP);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                final LatLng punto1 = new LatLng(-36.623573, -72.131717);
                final LatLng punto2 = new LatLng(-36.624374, -72.134904);
                googleMap.addMarker(new MarkerOptions().position(punto1).title("Punto 1 reciclaje"));
                googleMap.addMarker(new MarkerOptions().position(punto2).title("Punto 2 reciclaje"));


                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(punto1);
                builder.include(punto2);
                LatLngBounds bounds = builder.build();

                int  padding = 100; // Ajusta este valor según tus preferencias
                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                googleMap.animateCamera(cu);
            }
        });
        return view;

    }
}