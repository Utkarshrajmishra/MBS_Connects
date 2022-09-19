package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.courses.about_bba;
import com.example.mbsconnects.courses.bba;
import com.example.mbsconnects.courses.bca_about_course;
import com.example.mbsconnects.courses.bca_faculty;

public class BBA_tablayout extends FragmentStateAdapter {
    public BBA_tablayout(@NonNull bba fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new about_bba();
            case 1:
                return new bca_faculty();
            default:
                return new about_bba();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
