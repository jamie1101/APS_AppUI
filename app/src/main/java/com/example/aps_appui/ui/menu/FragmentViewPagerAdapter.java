package com.example.aps_appui.ui.menu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aps_appui.ui.menu.fragment.MessageFragment;
import com.example.aps_appui.ui.menu.fragment.ScheduleFragment;
import com.example.aps_appui.ui.menu.fragment.TodayprogressFragment;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    public FragmentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new ScheduleFragment();
        }
        else if (position == 1){
            return new TodayprogressFragment();
        }
        else {
            return new MessageFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
