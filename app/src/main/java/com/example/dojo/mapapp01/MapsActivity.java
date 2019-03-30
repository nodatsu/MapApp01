package com.example.dojo.mapapp01;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // マーカーを追加
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.794476, 140.780089)).title("つじい"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.798399, 140.780915)).title("麺山"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.796351, 140.772948)).title("かわら"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.789288, 140.762521)).title("まるしげ"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.791799, 140.790497)).title("めんや喜一"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.797153, 140.777024)).title("らーめん工房繁"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.796355, 140.773919)).title("麺屋 城"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.795802, 140.768972)).title("中華そばさとう"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.794836, 140.757593)).title("麺屋とろも"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.791076, 140.760690)).title("ラァメン ぼーんず"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.791795, 140.760784)).title("たんめん亭 妙見店"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.788426, 140.759775)).title("らーめんはちもり"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(40.787541, 140.784817)).title("ラーメンショップ幸畑店"));

        // 視点を移動 + ズーム(2-21)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.784415, 140.780523), 14));
    }
}
