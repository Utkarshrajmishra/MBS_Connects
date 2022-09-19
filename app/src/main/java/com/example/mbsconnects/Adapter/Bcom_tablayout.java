package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.courses.about_bcom;
import com.example.mbsconnects.courses.bca_about_course;
import com.example.mbsconnects.courses.bca_faculty;
import com.example.mbsconnects.courses.bcom;
import com.example.mbsconnects.courses.bcom_faculty;

public class Bcom_tablayout extends FragmentStateAdapter {
    public Bcom_tablayout(@NonNull bcom fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new about_bcom();
            case 1:
                return new bcom_faculty();
            default:
                return new bcom_faculty();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
