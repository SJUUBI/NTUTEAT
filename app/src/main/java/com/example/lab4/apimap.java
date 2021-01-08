package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Handler;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

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

        TextView delivery1 = (TextView) findViewById(R.id.textView4);                                  //北科美食通標題
        delivery1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型

        TextView delivery2 = (TextView) findViewById(R.id.textView5);                                  //北科美食通標題
        delivery2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型

        //final TextView delivery13 = (TextView) findViewById(R.id.textView13);                                  //北科美食通標題
        //delivery13.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型
        //------------------------------------------------------------------------------------------
        GifImageView ImageView1 = findViewById(R.id.deliveryman);
        try{
            GifDrawable gifDrawable1 = new GifDrawable(getResources(), R.drawable.giphy2);
            ImageView1.setImageDrawable(gifDrawable1);
        }catch (Exception e){
            e.printStackTrace();
        }
        //------------------------------------------------------------------------------------------
        AnimationSet animationSet11 = new AnimationSet(true);
        TranslateAnimation translateAnimation11=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,-2f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f);


        translateAnimation11.setDuration(5000);                                                      //動畫持續時間
        animationSet11.addAnimation(translateAnimation11);
        delivery.startAnimation(animationSet11);
        //-----------------------------------------------------------------------------------------
        AnimationSet animationSet55 = new AnimationSet(true);
        TranslateAnimation translateAnimation55=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,-2f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f);

        translateAnimation55.setDuration(5000);                                                      //動畫持續時間
        animationSet55.addAnimation(translateAnimation55);
        delivery1.startAnimation(animationSet55);
        //------------------------------------------------------------------------------------------
        AnimationSet animationSet66 = new AnimationSet(true);
        TranslateAnimation translateAnimation66=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,-2f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f);


        translateAnimation66.setDuration(5000);                                                      //動畫持續時間
        animationSet66.addAnimation(translateAnimation66);
        delivery2.startAnimation(animationSet66);
        //------------------------------------------------------------------------------------------
        AnimationSet animationSet6 = new AnimationSet(true);
        TranslateAnimation translateAnimation6 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,8f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f);

        translateAnimation6.setDuration(5000);                                                      //動畫持續時間
        animationSet6.addAnimation(translateAnimation6);
        ImageView1.startAnimation(animationSet6);
        //------------------------------------------------------------------------------------------
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
        m1.position(new LatLng(25.042411883591793, 121.53459043990914));
        m1.title("您的位置");
        m1.draggable(true);
        map.addMarker(m1);

        MarkerOptions m2 = new MarkerOptions();
        m2.position(new LatLng(25.044055385374527, 121.53322700408793));
        m2.title("店家位置");
        m2.draggable(true);
        map.addMarker(m2);

        PolylineOptions polylineOpt = new PolylineOptions();
        polylineOpt.add(new LatLng(25.044055385374527, 121.53322700408793));
            polylineOpt.add(new LatLng(25.04401893486118, 121.5336025133535));
            polylineOpt.add(new LatLng(25.04361797837276, 121.53369370844848));
            polylineOpt.add(new LatLng(25.043168419541246, 121.53369639065428));
            polylineOpt.add(new LatLng(25.043158699332334, 121.5339109673665));
            polylineOpt.add(new LatLng(25.042699418583798, 121.53390292073979));
            polylineOpt.add(new LatLng(25.042643527158376, 121.53446618460941));
        polylineOpt.add(new LatLng(25.042411883591793, 121.53459043990914));
        polylineOpt.color(Color.GREEN);
        Polyline polyline = map.addPolyline(polylineOpt);
        polyline.setWidth(10);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(25.043306932446388, 121.53383854772765),18));

    }
}