package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class apimap extends AppCompatActivity implements OnMapReadyCallback {
    private final static int REQUEST_PERMISSIONS =1;
    @Override
    public  void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults){
        switch (requestCode){
            case REQUEST_PERMISSIONS:
                for (int result:grantResults){
                    if (result != PackageManager.PERMISSION_GRANTED){
                        finish();
                    }else {
                        SupportMapFragment map =
                                (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
                        map.getMapAsync(this);
                    }
                }
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apimap);

        TextView delivery = (TextView) findViewById(R.id.textView3);                                  //北科美食通標題
        delivery.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型

        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_PERMISSIONS);
        else {
            SupportMapFragment map =
                    (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
            map.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap map){
        if (ActivityCompat.checkSelfPermission(apimap.this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(apimap.this,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION)!=
                        PackageManager.PERMISSION_GRANTED)
            return;
        map.setMyLocationEnabled(true);
        MarkerOptions m1 = new MarkerOptions();
        m1.position(new LatLng(25.033611,121.565000));
        m1.title("臺北101");
        m1.draggable(true);
        map.addMarker(m1);

        MarkerOptions m2 = new MarkerOptions();
        m2.position(new LatLng(25.047924,121.517081));
        m2.title("臺北車站");
        m2.draggable(true);
        map.addMarker(m2);

        PolylineOptions polylineOpt = new PolylineOptions();
        polylineOpt.add(new LatLng(25.033611,121.565000));
        polylineOpt.add(new LatLng(25.032728,121.565137));
        polylineOpt.add(new LatLng(25.047924,121.517081));
        polylineOpt.color(Color.GREEN);
        Polyline polyline = map.addPolyline(polylineOpt);
        polyline.setWidth(10);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(25.034,121.545),13));

    }
}