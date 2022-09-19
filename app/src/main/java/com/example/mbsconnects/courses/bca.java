package com.example.mbsconnects.courses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.mbsconnects.Adapter.BCA_tablayout;
import com.example.mbsconnects.Adapter.Ebook_Adapter;
import com.example.mbsconnects.Adapter.tablayout_adapter;
import com.example.mbsconnects.Adapter.teacher_adaptor;
import com.example.mbsconnects.HelperClass.EbookData;
import com.example.mbsconnects.HelperClass.teacher_Data;
import com.example.mbsconnects.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class bca extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
   BCA_tablayout adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca);


        tabLayout = findViewById(R.id.bca_tab_layout);
        viewPager2 = findViewById(R.id.bca_viewpager);
        adapter = new BCA_tablayout(this);
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
