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

public class louisamenu extends AppCompatActivity {

    private Button send_btn6;
    private TextView louisameal;
    private RadioGroup rg1,rg2;

    private String ingredient = "野菇";
    private String sauce = "茄汁";
    private String extra = "5元";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.louisamenu);

        TextView ing = (TextView) findViewById(R.id.louisatext1);                                  //北科美食通標題
        ing.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing1 = (TextView) findViewById(R.id.louisatext2);                                  //北科美食通標題
        ing1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));


        louisameal = findViewById(R.id.louisa_meal);
        send_btn6 = findViewById(R.id.louisa_send);

        send_btn6.setOnClickListener(new View.OnClickListener() {
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

        rg1 = findViewById(R.id.louisaingredient);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.louisaselectbtn:
                        ingredient= "野菇";
                        break;
                    case R.id.louisaselectbtn1:
                        ingredient = "嫩雞";
                        break;
                    case R.id.louisaselectbtn2:
                        ingredient = "德式香腸";
                        break;
                    case R.id.louisaselectbtn3:
                        ingredient = "培根";
                        break;
                }
            }
        });

        rg2 = findViewById(R.id.louisamain);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.louisamain1:
                        sauce = "微冰";
                        break;
                    case R.id.louisamain2:
                        sauce = "少冰";
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
                louisameal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                        str1,
                        str2,
                        str3));
            }
        }
    }

}