package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ntuteat = (TextView) findViewById(R.id.textView5);                                  //北科美食通
        ntuteat.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));      //北科美食通 font

        TextView develop = (TextView) findViewById(R.id.textView14);                                 //Developed by
        develop.setTypeface(Typeface.createFromAsset(getAssets(), "spacerangerital.ttf"));     //Developed by font

        ImageView ntutimg = findViewById(R.id.imageView2);                                           //(Developed by) transparency
        ntutimg.setAlpha(0.65f);
        //---------------------------------------------------------------------------------------------duck gif
        GifImageView ImageView = findViewById(R.id.imageView);
        try{
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.giphy1);
            ImageView.setImageDrawable(gifDrawable);
        }catch (Exception e){
            e.printStackTrace();
        }
        //---------------------------------------------------------------------------------------------
        btn = findViewById(R.id.btn_choice);
        btn2 = findViewById(R.id.btn_res);
        btn3 = findViewById(R.id.btn_sql);
        //---------------------------------------------------------------------------------------------duck gif animation
        AnimationSet animationSetd = new AnimationSet(true);
        TranslateAnimation translateAnimationd = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,2f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,5f,
                Animation.RELATIVE_TO_SELF,0f);
        translateAnimationd.setDuration(1500);                                                       //animation time
        animationSetd.addAnimation(translateAnimationd);
        ImageView.startAnimation(animationSetd);
        //---------------------------------------------------------------------------------------------北科美食通 gif animation
        AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation1=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,-1f,
                Animation.RELATIVE_TO_SELF,0f);
        translateAnimation1.setDuration(850);                                                        //animation time
        animationSet1.addAnimation(translateAnimation1);
        ntuteat.startAnimation(animationSet1);
        //---------------------------------------------------------------------------------------------
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this,                  //MainActivity change to slideimg
                        slideimg.class), 1);


            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this,                  //MainActivity change to menuJAVA
                        menuJAVA.class), 1);


            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this,                  //MainActivity change to MainActivity2 sqlite
                        sqlite.class), 1);


            }

        });

    }




}
