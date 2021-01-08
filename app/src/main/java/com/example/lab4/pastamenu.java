package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class pastamenu extends AppCompatActivity {

    private Button send_btn;
    private TextView buffetmeal;
    private RadioGroup rg1,rg2,rg3;

    private String ingredient = "野菇";
    private String sauce = "茄汁";
    private String extra = "5元";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastamenu);

        TextView ing = (TextView) findViewById(R.id.buffettext2);                                  //北科美食通標題
        ing.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing1 = (TextView) findViewById(R.id.buffettext1);                                  //北科美食通標題
        ing1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing2 = (TextView) findViewById(R.id.extranoodletext);                                  //北科美食通標題
        ing2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        buffetmeal = findViewById(R.id.buffet_meal);
        send_btn = findViewById(R.id.buffet_send);

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //將頁面轉到餐廳圖片頁面(slideimg)
                startActivityForResult(new Intent(pastamenu.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        apimap.class), 1);
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("sugar",ingredient);
                b.putString("drink",sauce);
                b.putString("ice",extra);
                i.putExtras(b);
                setResult(111,i);
                finish();
            }
        });

        rg1 = findViewById(R.id.buffetmain);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.buffetmain1:
                        ingredient= "野菇";
                        break;
                    case R.id.buffetmain2:
                        ingredient = "嫩雞";
                        break;
                    case R.id.buffetmain3:
                        ingredient = "德式香腸";
                        break;
                    case R.id.buffetmain4:
                        ingredient = "培根";
                        break;
                    case R.id.pastaingredient5:
                        ingredient = "明太子";
                        break;
                    case R.id.pastaingredient6:
                        ingredient = "海鮮";
                        break;
                }
            }
        });

        rg2 = findViewById(R.id.buffetingredient);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.buffetselectbtn:
                        sauce = "微冰";
                        break;
                    case R.id.buffetselectbtn1:
                        sauce = "少冰";
                        break;
                    case R.id.buffetselectbtn2:
                        sauce = "正常冰";
                        break;
                    case R.id.buffetselectbtn3:
                        sauce = "正常冰";
                        break;
                }
            }
        });

        rg3 = findViewById(R.id.extranoodle);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.extranoodle1:
                        sauce = "5元";
                        break;
                    case R.id.extranoodle2:
                        sauce = "10元";
                        break;

                }
            }
        });

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;

        if(requestCode == 1){
            if(resultCode == 111){

                Bundle b = data.getExtras();
                String str1 = b.getString("drink");
                String str2 = b.getString("sugar");
                String str3 = b.getString("ice");
                buffetmeal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                        str1,
                        str2,
                        str3));
            }
        }
    }

}