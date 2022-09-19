package com.example.mbsconnects.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mbsconnects.app_content.aim;
import com.example.mbsconnects.app_content.history;
import com.example.mbsconnects.app_content.principal_message;
import com.example.mbsconnects.app_content.vision;

public class tablayout_adapter extends FragmentStateAdapter {
    public tablayout_adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new principal_message();
            case 1:
                return new history();
            case 2:
                return new aim();
            case 3:
                return new vision();
            default:
                return new principal_message();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
