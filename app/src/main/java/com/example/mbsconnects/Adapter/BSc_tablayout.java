package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.courses.Bsc;
import com.example.mbsconnects.courses.about_bba;
import com.example.mbsconnects.courses.about_bsc;
import com.example.mbsconnects.courses.bba;
import com.example.mbsconnects.courses.bca_faculty;
import com.example.mbsconnects.courses.bcom_faculty;
import com.example.mbsconnects.courses.bsc_faculty;

public class BSc_tablayout extends FragmentStateAdapter {
    public BSc_tablayout(@NonNull Bsc fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new about_bsc();
            case 1:
                return new bsc_faculty();
            default:
                return new about_bsc();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
