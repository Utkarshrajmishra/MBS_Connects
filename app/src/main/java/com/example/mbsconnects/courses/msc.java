package com.example.mbsconnects.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.mbsconnects.Adapter.MCOM_tablayout;
import com.example.mbsconnects.Adapter.MSc_tablayout;
import com.example.mbsconnects.R;
import com.google.android.material.tabs.TabLayout;

public class msc extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MSc_tablayout adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msc);
        tabLayout = findViewById(R.id.msc_tab_layout);
        viewPager2 = findViewById(R.id.msc_viewpager);
        adapter = new MSc_tablayout(this);
        viewPager2.setAdapter(adapter);



        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

}