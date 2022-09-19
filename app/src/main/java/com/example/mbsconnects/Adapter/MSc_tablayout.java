package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.courses.about_bba;
import com.example.mbsconnects.courses.about_msc;
import com.example.mbsconnects.courses.bba;
import com.example.mbsconnects.courses.bca_faculty;
import com.example.mbsconnects.courses.msc;
import com.example.mbsconnects.courses.msc_faculty;

public class MSc_tablayout extends FragmentStateAdapter {
    public MSc_tablayout(@NonNull msc fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new about_msc();
            case 1:
                return new msc_faculty();
            default:
                return new about_msc();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
