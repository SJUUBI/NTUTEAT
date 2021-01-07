package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.view.View;

public class mealtest1 extends AppCompatActivity {
    private TextView tv_detail, textView6,tv_price,tv_meallist,tv_meallist2;
    private Button btn_send;
    private ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealtest);


        tv_price = findViewById(R.id.tv_price);
        startActivityForResult(new Intent(mealtest1.this,
                muffinmenu.class),1);
        textView6 = findViewById(R.id.textView6);
        btn_send = findViewById(R.id.btn_send);
        tv_detail = findViewById(R.id.tv_detail);
        tv_meallist = findViewById(R.id.tv_meallist);
        tv_meallist2 = findViewById(R.id.tv_meallist2);
        TextView ing = (TextView) findViewById(R.id.tv_price);                                  //北科美食通標題
        ing.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing1 = (TextView) findViewById(R.id.tv_detail);                                  //北科美食通標題
        ing1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing2 = (TextView) findViewById(R.id.tv_meallist);                                  //北科美食通標題
        ing2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing3 = (TextView) findViewById(R.id.tv_meallist2);                                  //北科美食通標題
        ing3.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing4 = (TextView) findViewById(R.id.textView6);                                  //北科美食通標題
        ing4.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(mealtest1.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        apimap.class), 1);

            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) return;
        if (requestCode == 1) {
            if (resultCode == 201) {
                Bundle b = data.getExtras();
                String str1 = b.getString("meal1");
                String str2 = b.getString("meal2");
                String str3 = b.getString("meal3");
                String str4 = b.getString("meal4");
                String str5 = b.getString("meal5");
                Integer num1 = b.getInt("number1");
                Integer num2 = b.getInt("number2");
                Integer num3 = b.getInt("number3");
                Integer num4 = b.getInt("number4");
                Integer num5 = b.getInt("number5");
                Integer price= b.getInt("price");
                tv_meallist.setText(String.format("餐點:\n\n%s\n\n%s\n\n%s\n\n%s\n\n%s\n",str1,str2,str3,str4,str5));
                tv_meallist2.setText(String.format("數量:\n\n共%d\n\n共%d\n\n共%d\n\n共%d\n\n共%d\n",num1,num2,num3,num4,num5));
                tv_price.setText(String.format("%d元",price));

            }

        }

    }

}
