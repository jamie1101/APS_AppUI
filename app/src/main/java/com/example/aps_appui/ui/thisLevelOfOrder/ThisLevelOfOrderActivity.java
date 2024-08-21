package com.example.aps_appui.ui.thisLevelOfOrder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.menu.FragmentViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThisLevelOfOrderActivity extends AppCompatActivity implements ThisLevelOfOrderContract.view{
    private Button todayprogress_back;

    private ViewPager2 todayViewPager2;
    private TabLayout todayTab;
    private ThisLevelOfOrderAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_this_level_of_order);

        todayprogress_back=findViewById(R.id.todayBack);
        todayprogress_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();

        String numA=intent.getStringExtra("numA");
        String numB=intent.getStringExtra("numB");
        String numC=intent.getStringExtra("numC");
        String numD=intent.getStringExtra("numD");
        String amount=intent.getStringExtra("amount");
        String ClosingDate=intent.getStringExtra("ClosingDate");
        String PlanBegins=intent.getStringExtra("PlanBegins");
        String group=intent.getStringExtra("group");

        TextView show_numA= (TextView) findViewById(R.id.numA);
        TextView show_numB= (TextView) findViewById(R.id.numB);
        TextView show_numC= (TextView) findViewById(R.id.numC);
        TextView show_numD= (TextView) findViewById(R.id.numD);
        TextView show_amount= (TextView) findViewById(R.id.amount);
        TextView show_ClosingDate= (TextView) findViewById(R.id.ClosingDate);
        TextView show_PlanBegins= (TextView) findViewById(R.id.PlanBegins);
        TextView show_group= (TextView) findViewById(R.id.group);

        show_numA.setText(String.valueOf(numA));
        show_numB.setText(String.valueOf(numB));
        show_numC.setText(String.valueOf(numC));
//        show_numD.setText(String.valueOf(numD));  //上面欄位沒使用到
        show_amount.setText(String.valueOf(amount));
        show_ClosingDate.setText(String.valueOf(ClosingDate));
        show_PlanBegins.setText(String.valueOf(PlanBegins));
        show_group.setText(String.valueOf(group));
//////////////////////////////////////////////////////////////
        todayViewPager2 = findViewById(R.id.todayViewpager2);
        todayTab = findViewById(R.id.todayTab);
        Adapter = new ThisLevelOfOrderAdapter(this);
        todayViewPager2.setAdapter(Adapter);
        todayViewPager2.setCurrentItem(0);

        new TabLayoutMediator(todayTab, todayViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setText("前關製令");
                if (position == 1) tab.setText("本階製令");
                if (position == 2) tab.setText("後關製令");
                if (position == 3) tab.setText("裝配製令");
                if (position == 4) tab.setText("銷售訂單");
            }
        }).attach();

        todayTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}