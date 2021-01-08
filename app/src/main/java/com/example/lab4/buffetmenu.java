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

public class buffetmenu extends AppCompatActivity {

    private Button send_btn2;
    private TextView tvmeal;
    private RadioGroup rg1,rg2;

    private String ingredient = "野菇";
    private String sauce = "茄汁";
    private String extra = "5元";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buffetmenu);

        TextView ing = (TextView) findViewById(R.id.pastatext1);                                  //北科美食通標題
        ing.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing1 = (TextView) findViewById(R.id.pastatext2);                                  //北科美食通標題
        ing1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));


        tvmeal = findViewById(R.id.pasta_meal);
        send_btn2 = findViewById(R.id.pasta_send);

        send_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

        rg1 = findViewById(R.id.pastaingredient);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.pastaselectbtn:
                        ingredient= "野菇";
                        break;
                    case R.id.pastaselectbtn1:
                        ingredient = "嫩雞";
                        break;
                    case R.id.pastaselectbtn2:
                        ingredient = "德式香腸";
                        break;
                    case R.id.pastaselectbtn3:
                        ingredient = "培根";
                        break;
                }
            }
        });

        rg2 = findViewById(R.id.pastamain);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.pastamain1:
                        sauce = "微冰";
                        break;
                    case R.id.pastamain2:
                        sauce = "少冰";
                        break;
                    case R.id.pastamain3:
                        sauce = "正常冰";
                        break;
                    case R.id.pastamain4:
                        sauce = "正常冰";
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
                tvmeal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                        str1,
                        str2,
                        str3));
            }
        }
    }

}