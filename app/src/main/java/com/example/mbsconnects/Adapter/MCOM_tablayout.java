package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.courses.about_mcom;
import com.example.mbsconnects.courses.bca;
import com.example.mbsconnects.courses.bca_about_course;
import com.example.mbsconnects.courses.bca_faculty;
import com.example.mbsconnects.courses.mcom;
import com.example.mbsconnects.courses.mcom_faculty;

public class MCOM_tablayout extends FragmentStateAdapter {
    public MCOM_tablayout(@NonNull mcom fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new about_mcom();
            case 1:
                return new mcom_faculty();
            default:
                return new about_mcom();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
