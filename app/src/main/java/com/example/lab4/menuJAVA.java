package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

public class menuJAVA extends AppCompatActivity {

    private ImageButton img,img1,img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        TextView ntuteatt = (TextView) findViewById(R.id.textView4);                                  //北科美食通標題
        ntuteatt.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型

        TextView ntuteat1 = (TextView) findViewById(R.id.textView7);                                  //北科美食通標題
        ntuteat1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ntuteat2 = (TextView) findViewById(R.id.textView8);                                  //北科美食通標題
        ntuteat2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ntuteat3 = (TextView) findViewById(R.id.textView9);                                  //北科美食通標題
        ntuteat3.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ntuteat4 = (TextView) findViewById(R.id.textView10);                                  //北科美食通標題
        ntuteat4.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ntuteat5 = (TextView) findViewById(R.id.textView11);                                  //北科美食通標題
        ntuteat5.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ntuteat6 = (TextView) findViewById(R.id.textView12);                                  //北科美食通標題
        ntuteat6.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        //-----------------------------------------------------------------------------------------------------------
        AnimationSet animationSet2 = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,-1f,
                Animation.RELATIVE_TO_SELF,0f);
        translateAnimation2.setDuration(850);                                                      //動畫持續時間
        animationSet2.addAnimation(translateAnimation2);
        ntuteatt.startAnimation(animationSet2);
        //-----------------------------------------------------------------------------------------------------------
        img  = findViewById(R.id.imageButton);
        img1 = findViewById(R.id.imageButton1);
        img2 = findViewById(R.id.imageButton2);
        img3 = findViewById(R.id.imageButton3);
        img4 = findViewById(R.id.imageButton4);
        img5 = findViewById(R.id.imageButton5);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        pastamenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        buffetmenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        muffinmenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        breakfastmenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        comebuymenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(menuJAVA.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        louisamenu.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
    }
}