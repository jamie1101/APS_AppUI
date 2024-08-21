package com.example.aps_appui.ui.thisLevelOfOrder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.aps_appui.ui.menu.fragment.ScheduleFragment;
import com.example.aps_appui.ui.menu.fragment.TodayprogressFragment;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.AssemblyOrderFragment;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.InsideThisLevelOfOrderFragment;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.LaterCustomsOrderFragment;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.PreviousCustomsOrderFragment;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.SalesOrderFragment;

public class ThisLevelOfOrderAdapter extends FragmentStateAdapter {
    public ThisLevelOfOrderAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new PreviousCustomsOrderFragment();
        }
        else if(position == 1){
            return new InsideThisLevelOfOrderFragment();
        }
        else if(position == 2){
            return new LaterCustomsOrderFragment();
        }
        else if(position == 3){
            return new AssemblyOrderFragment();
        }
        else{
            return new SalesOrderFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
