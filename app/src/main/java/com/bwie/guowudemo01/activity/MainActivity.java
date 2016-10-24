package com.bwie.guowudemo01.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.guowudemo01.R;
import com.bwie.guowudemo01.adapter.PlateFragmentPagerAdapter;
import com.bwie.guowudemo01.fragment.Bumen;
import com.bwie.guowudemo01.fragment.Lianbo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2;
    private ViewPager vp_plate;
    private View view_week,view_all;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vp_plate=(ViewPager)findViewById(R.id.vp_plate);

        //得到管理者
        fm=getSupportFragmentManager();
        //Viewpager的适配器
        vp_plate.setAdapter(new PlateFragmentPagerAdapter(fm,getFragment()));


        view_week= findViewById(R.id.view1_plate);
        view_all= findViewById(R.id.view2_plate);


        tv1 = (TextView)findViewById(R.id.tv_plate_week);
        tv2 = (TextView)findViewById(R.id.tv_plate_all);


        vp_plate.setCurrentItem(0);
        tv1.setTextColor(Color.BLUE);
        view_week.setVisibility(View.VISIBLE);
        view_all.setVisibility(View.GONE);


        vp_plate.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    view_week.setVisibility(View.VISIBLE);
                    view_all.setVisibility(View.GONE);

                    tv1.setTextColor(Color.BLUE);
                    tv2.setTextColor(Color.BLACK);


                } else if (position == 1) {
                    view_week.setVisibility(View.GONE);
                    view_all.setVisibility(View.VISIBLE);

                    tv2.setTextColor(Color.BLUE);
                    tv1.setTextColor(Color.BLACK);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 设置点击选项，mvp切换游标切换
        tv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vp_plate.setCurrentItem(0);
                view_week.setVisibility(View.VISIBLE);
                view_all.setVisibility(View.GONE);




            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vp_plate.setCurrentItem(1);
                view_week.setVisibility(View.GONE);
                view_all.setVisibility(View.VISIBLE);

            }
        });


    }

    public List<Fragment> getFragment() {
        List<Fragment> list=new ArrayList<Fragment>();

        list.add(new Bumen());
        list.add(new Lianbo());

        return list;
    }

}
