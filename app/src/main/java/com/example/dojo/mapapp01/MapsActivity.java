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

        // 追加情報付きマーカー
        MarkerOptions opt = new MarkerOptions();
        opt.position(new LatLng(40.790395, 140.773397));
        opt.title("総合学校教育センターの近く");
        opt.snippet("昔ここで知り合いが自転車でこけて手首を骨折しましたね。");
        opt.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        Marker m1 = mMap.addMarker(opt);
        m1.showInfoWindow();

        // 視点を移動 + ズーム(2-21)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.784415, 140.780523), 13));

        // 現在地を表示
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 1);
            return;
        }
        mMap.setMyLocationEnabled(true);

        // ロングクリック
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("ここ")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                );
            }
        });

//        // クリック
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                mMap.addMarker(new MarkerOptions()
//                        .position(latLng)
//                        .title("ここ")
//                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
//                );
//            }
//        });

        // InfoWindowのタップを検出
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(MapsActivity.this, marker.getTitle() + "を押したね", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
