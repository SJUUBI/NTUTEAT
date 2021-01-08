package com.example.lab4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.viewpagerindicator.CirclePageIndicator;

public class slideimg extends FragmentActivity {
    private static final String[] StrArray = new String[] { "1", "2", "3", "4", "5", "6","7" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView n = (TextView) findViewById(R.id.textView6);                                  //北科美食通標題
        n.setTypeface(Typeface.createFromAsset(getAssets(), "salter.ttf"));  //北科美食通標題字型

        Toast.makeText(slideimg.this, "橙廚義大利麵",                                    //剛進去橙廚義大利麵無法進到SWITCH做判斷
                Toast.LENGTH_SHORT).show();                                                         //故先加入這行CODE預先顯示

        AnimationSet animationSet3 = new AnimationSet(true);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,-1f,
                Animation.RELATIVE_TO_SELF,0f);
        translateAnimation3.setDuration(900);
        animationSet3.addAnimation(translateAnimation3);
        n.startAnimation(animationSet3);

        findView();
    }

    private void findView() {
        FragmentPagerAdapter adapter = new slideimg.MyAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        CirclePageIndicator circlePageIndicator=(CirclePageIndicator)findViewById(R.id.CirclePageindicator);
        circlePageIndicator.setViewPager(pager);

        circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {                                                                          //依據圖片給出不同餐廳名稱
                    case 0:
                        Toast.makeText(slideimg.this, "橙廚義大利麵",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(slideimg.this, "麗宴自助餐",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(slideimg.this, "小木屋鬆餅",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(slideimg.this, "麥味登",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(slideimg.this, "COMEBUY",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(slideimg.this, "路易莎咖啡",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(slideimg.this, "誠字號涼本舖",
                                Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ContentFragment.newInstance(slideimg.StrArray[position % slideimg.StrArray.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return slideimg.StrArray[position % slideimg.StrArray.length].toUpperCase();
        }

        @Override
        public int getCount() {return slideimg.StrArray.length;}
    }

}