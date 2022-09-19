package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.app_content.aim;
import com.example.mbsconnects.app_content.history;
import com.example.mbsconnects.app_content.principal_message;
import com.example.mbsconnects.app_content.vision;
import com.example.mbsconnects.courses.bca;
import com.example.mbsconnects.courses.bca_about_course;
import com.example.mbsconnects.courses.bca_faculty;

public class BCA_tablayout extends FragmentStateAdapter {
    public BCA_tablayout(@NonNull bca fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new bca_about_course();
            case 1:
                return new bca_faculty();
            default:
                return new bca_about_course();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
