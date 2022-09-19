package com.example.mbsconnects.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.mbsconnects.Adapter.BBA_tablayout;
import com.example.mbsconnects.Adapter.BCA_tablayout;
import com.example.mbsconnects.Adapter.Bcom_tablayout;
import com.example.mbsconnects.R;
import com.google.android.material.tabs.TabLayout;

public class bcom extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Bcom_tablayout adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcom);

        tabLayout = findViewById(R.id.bcom_tab_layout);
        viewPager2 = findViewById(R.id.bcom_viewpager);
        adapter = new Bcom_tablayout(this);
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