package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class breakfastmenu extends AppCompatActivity {

    private
    Button btn_up[] = new Button[5];
    Button btn_down[] = new Button[5];
    TextView num[] = new TextView[5];
    int up[] = {R.id.btn_up1, R.id.btn_up2, R.id.btn_up3, R.id.btn_up4, R.id.btn_up5};
    int down[] = {R.id.btn_down1, R.id.btn_down2, R.id.btn_down3, R.id.btn_down4, R.id.btn_down5};
    int number[] = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5};
    int e[] = {0, 0, 0, 0, 0};
    String[] meal=new String[]{"招牌套餐","法式套餐","幸福套餐","樂活套餐","美式套餐"};
    String s = "";

    public void UP(View v) {
        for (int i = 0; i < btn_up.length; i++) {
            if (v == btn_up[i]) {
                e[i]++;//遞增，用陣列來存取每個餐點的數量
                s = Integer.toString(e[i]);
                num[i].setText(s);

            }
        }

    }

    public void Down(View v) {
        for (int i = 0; i < btn_down.length; i++) {
            if (v == btn_down[i]) {
                if (e[i] > 0) {
                    e[i]--;//遞減，用陣列來存取每個餐點的數量
                    s = Integer.toString(e[i]);
                    num[i].setText(s);
                }
            }
        }
    }

    public void findView() {
        for (int i = 0; i < btn_up.length; i++) {
            btn_up[i] = (Button) this.findViewById(up[i]);
            btn_down[i] = (Button) this.findViewById(down[i]);
            num[i] = (TextView) this.findViewById(number[i]);
        }
    }
    public void Enter(View v) {
        Intent i = new Intent();
        Bundle b = new Bundle();

        b.putString("meal1",meal[0]);
        b.putString("meal2",meal[1]);
        b.putString("meal3",meal[2]);
        b.putString("meal4",meal[3]);
        b.putString("meal5",meal[4]);
        b.putInt("number1",e[0]);
        b.putInt("number2",e[1]);
        b.putInt("number3",e[2]);
        b.putInt("number4",e[3]);
        b.putInt("number5",e[4]);
        b.putInt("price", (e[0]*75+e[1]*80+e[2]*65+e[3]*95+e[4]*95));
        i.putExtras(b);
        setResult(501, i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfastmenu);
        findView();

        TextView ing = (TextView) findViewById(R.id.pastaingredienttext);                                  //北科美食通標題
        ing.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing1 = (TextView) findViewById(R.id.extranoodletext);                                  //北科美食通標題
        ing1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing2 = (TextView) findViewById(R.id.pasta1);                                  //北科美食通標題
        ing2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing3 = (TextView) findViewById(R.id.pasta2);                                  //北科美食通標題
        ing3.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing4 = (TextView) findViewById(R.id.pasta3);                                  //北科美食通標題
        ing4.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing5 = (TextView) findViewById(R.id.pasta4);                                  //北科美食通標題
        ing5.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        TextView ing6 = (TextView) findViewById(R.id.pasta5);                                  //北科美食通標題
        ing6.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
    }
}