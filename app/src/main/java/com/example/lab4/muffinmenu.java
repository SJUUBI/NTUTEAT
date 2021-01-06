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

public class muffinmenu extends AppCompatActivity {

    private Button muffin_send;
    Button btn_up[] = new Button[8];
    Button btn_down[] = new Button[8];
    TextView num[] = new TextView[8];
    int up[] = {R.id.btnup1, R.id.btnup2, R.id.btnup3, R.id.btnup4, R.id.btnup5, R.id.btnup6, R.id.btnup7, R.id.btnup8 };
    int down[] = {R.id.btndown1, R.id.btndown2, R.id.btndown3, R.id.btndown4, R.id.btndown5,R.id.btndown6,R.id.btndown7,R.id.btndown8};
    int number[] = {R.id.num_1, R.id.num_2, R.id.num_3, R.id.num_4, R.id.num_5,R.id.num_6,R.id.num_7,R.id.num_8};
    int e[] = {0, 0, 0, 0, 0, 0, 0, 0};
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
        for (int i = 0; i < e.length; i++) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("點餐結果")
                    .setMessage(
                            "鮮奶油鬆餅:" + e[0] + "份\n" + "巧克力鬆餅:" + e[1] + "份\n" + "草莓鬆餅:"
                                    + e[2] + "份\n" + "蜂蜜鬆餅:" + e[3] + "份\n"
                                    + "紅茶:" + e[4] + "杯\n"+"綠茶:" + e[5] + "杯\n"
                                    + "鮮奶茶:" + e[6] + "杯\n"+"烏龍茶:" + e[7] + "杯\n"
                                    +"總金額:"+(e[0]*50+e[1]*45+e[2]*50+e[3]*50+e[4]*25+e[5]*20+e[6]*35+e[7]*30)+"元")
                    .setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {
                                // 訊息框裡加一個按鈕
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();// 返回點餐畫面
                                }
                            }).show();
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muffinmenu);
        findView();

        TextView muf = (TextView) findViewById(R.id.muffintext1);                                  //北科美食通標題
        muf.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf1 = (TextView) findViewById(R.id.muffintext2);                                  //北科美食通標題
        muf1.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf2 = (TextView) findViewById(R.id.taste1);                                  //北科美食通標題
        muf2.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf3 = (TextView) findViewById(R.id.taste2);                                  //北科美食通標題
        muf3.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf4 = (TextView) findViewById(R.id.taste3);                                  //北科美食通標題
        muf4.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf5 = (TextView) findViewById(R.id.taste4);                                  //北科美食通標題
        muf5.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf6 = (TextView) findViewById(R.id.taste5);                                  //北科美食通標題
        muf6.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf7 = (TextView) findViewById(R.id.taste6);                                  //北科美食通標題
        muf7.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf8 = (TextView) findViewById(R.id.taste7);                                  //北科美食通標題
        muf8.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));
        TextView muf9 = (TextView) findViewById(R.id.taste8);                                  //北科美食通標題
        muf9.setTypeface(Typeface.createFromAsset(getAssets(), "HanyiSentyTang.ttf"));

        muffin_send = findViewById(R.id.muffin_send);
        muffin_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(muffinmenu.this,                  //將頁面轉到餐廳優惠快報圖片頁面(slideimg)
                        apimap.class), 1);
            }
        });
    }
}