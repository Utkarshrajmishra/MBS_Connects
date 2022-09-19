package com.example.mbsconnects.app_content;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.mbsconnects.Adapter.tablayout_adapter;
import com.example.mbsconnects.R;
import com.google.android.material.tabs.TabLayout;

public class about_us extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    tablayout_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.viewpager);
        adapter=new tablayout_adapter(this);
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