package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class pastamenu extends AppCompatActivity {
    private Button pasta_send;
    Button btn_up[] = new Button[5];
    Button btn_down[] = new Button[5];
    TextView num[] = new TextView[5];
    int up[] = {R.id.btn_up1, R.id.btn_up2, R.id.btn_up3, R.id.btn_up4, R.id.btn_up5};
    int down[] = {R.id.btn_down1, R.id.btn_down2, R.id.btn_down3, R.id.btn_down4, R.id.btn_down5};
    int number[] = {R.id.num1, R.id.num2, R.id.num3, R.id.num4, R.id.num5};
    int e[] = {0, 0, 0, 0, 0};
    String[] meal=new String[]{"野菇茄汁義大利麵","嫩雞白醬義大利麵","德式香腸紅醬義大利麵","奶油培根義大利麵", "海鮮明太子義大利麵"};
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
        b.putInt("price", (e[0]*85+e[1]*85+e[2]*100+e[3]*95+e[4]*110));
        i.putExtras(b);
        setResult(101, i);
        finish();
        /*startActivityForResult(new Intent(pastamenu.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                mealtest.class), 1);*/
           /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("點餐結果")
                    .setMessage(
                            "野菇茄汁義大利麵:" + e[0] + "份\n" + "嫩雞白醬義大利麵:" + e[1] + "份\n" + "德式香腸紅醬義大利麵:"
                                    + e[2] + "份\n" + "奶油培根義大利麵:" + e[3] + "份\n"
                                    + "海鮮明太子義大利麵:" + e[4] + "份\n"+"總金額:"+(e[0]*85+e[1]*85+e[2]*100+e[3]*95+e[4]*110)+"元")
                    .setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {
                                // 訊息框裡加一個按鈕
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();// 返回點餐畫面
                                }
                            }).show();*/


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastamenu);
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

        /*pasta_send = findViewById(R.id.pasta_send);
        pasta_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(pastamenu.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        apimap.class), 1);

            }

            });*/



        }
    }
