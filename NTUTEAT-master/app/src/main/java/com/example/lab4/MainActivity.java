package com.example.lab4;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity {

    private Button btn,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView ntuteat = (TextView) findViewById(R.id.textView5);                                  //北科美食通標題
        ntuteat.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));  //北科美食通標題字型



        //---------------------------------------------------------------------------------------------gif的圖像撥放
        GifImageView ImageView = findViewById(R.id.imageView);
        try{
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.giphy);
            ImageView.setImageDrawable(gifDrawable);
        }catch (Exception e){
            e.printStackTrace();
        }
        //---------------------------------------------------------------------------------------------gif的圖像撥放

        btn = findViewById(R.id.btn_choice);                                                        //從XML引入ID(btn_choice)
        btn2 = findViewById(R.id.btn_res);                                                          //從XML引入ID(btn_res)

        //---------------------------------------------------------------------------------------------字體飛入動畫(上而下)
        AnimationSet animationSet1 = new AnimationSet(true);
        TranslateAnimation translateAnimation1=new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,-1f,
                Animation.RELATIVE_TO_SELF,0f);
        translateAnimation1.setDuration(850);                                                      //動畫持續時間
        animationSet1.addAnimation(translateAnimation1);
        ntuteat.startAnimation(animationSet1);
        //---------------------------------------------------------------------------------------------字體飛入動畫(上而下)

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        slideimg.class), 1);                                            //將頁面轉到餐廳圖片頁面(slideimg)


            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(MainActivity.this,                  //將頁面轉到點餐頁面(MainActivity2)
                        menuJAVA.class), 1);                                       //將頁面轉到點餐頁面(MainActivity2)


            }

        });


    }




}
