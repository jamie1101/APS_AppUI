package com.example.aps_appui.ui.thisLevelOfOrder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.aps_appui.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThisLevelOfOrderActivity extends AppCompatActivity implements ThisLevelOfOrderContract.view {

    private TextView show_group;
    private TextView show_existOrOver;
    private TextView show_orderNumber, show_masterPartNumber, show_sourceOrder, show_MotherPartProductName;
    private TextView show_amount, show_EstimatedLaunchTime, show_planBegins, show_planEnd;

    private Button todayprogress_back;
    private ViewPager2 todayViewPager2;
    private TabLayout todayTab;
    private ThisLevelOfOrderAdapter Adapter;

    private ImageView nextpageleft, nextpageright;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_this_level_of_order);

        todayprogress_back = findViewById(R.id.todayBack);
        todayprogress_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent(); // 抓取 todayprogressadapter 的資料

        show_orderNumber = findViewById(R.id.numA);
        show_sourceOrder = findViewById(R.id.numB);
        show_masterPartNumber = findViewById(R.id.numC);
        show_MotherPartProductName = findViewById(R.id.numD);

        show_group = findViewById(R.id.group);
        show_EstimatedLaunchTime = findViewById(R.id.EstimatedLaunchTime);
        show_planBegins = findViewById(R.id.PlanBegins);
        show_planEnd = findViewById(R.id.planEnd);
        show_amount = findViewById(R.id.amount);
        show_existOrOver = findViewById(R.id.existOrOver);

        nextpageleft = findViewById(R.id.nextpageleft_iv);
        nextpageright = findViewById(R.id.nextpageright_iv);

        // 進入時預設是 position 0 (顯示 pr)
        show_orderNumber.setText(intent.getStringExtra("numA"));
        show_sourceOrder.setText(intent.getStringExtra("numB"));
        show_masterPartNumber.setText(intent.getStringExtra("numC"));
        show_MotherPartProductName.setText(intent.getStringExtra("this_MotherPartProductName"));
        show_group.setText("一群-點焊");
        show_existOrOver.setText("生效");
        show_existOrOver.setTextColor(Color.GREEN);

        todayViewPager2 = findViewById(R.id.todayViewpager2);
        todayTab = findViewById(R.id.todayTab);
        Adapter = new ThisLevelOfOrderAdapter(this);
        todayViewPager2.setAdapter(Adapter);

        new TabLayoutMediator(todayTab, todayViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("前關製令");
                        break;
                    case 1:
                        tab.setText("本階製令");
                        break;
                    case 2:
                        tab.setText("後關製令");
                        break;
                    case 3:
                        tab.setText("裝配製令");
                        break;
                    case 4:
                        tab.setText("銷售訂單");
                        break;
                }
            }
        }).attach();

        int defaultTabPosition = 1; // 進入畫面時 預設顯示 tab1 本階製令
        todayViewPager2.setCurrentItem(defaultTabPosition);
        updateButtonVisibility(defaultTabPosition); // 初始化时更新按钮可见性

        todayViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateButtonVisibility(position); // 页面变化时更新按钮可见性
            }
        });

        todayTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        show_orderNumber.setText(intent.getStringExtra("pr_orderNumber"));
                        show_sourceOrder.setText(intent.getStringExtra("numB"));
                        show_masterPartNumber.setText(intent.getStringExtra("pr_masterPartNumber"));
                        show_MotherPartProductName.setText(intent.getStringExtra("pr_MotherPartProductName"));
                        show_EstimatedLaunchTime.setText("預計上線：2018-12-05");
                        show_amount.setText("生產數量：3");
                        show_planBegins.setText("計劃開始：15:30");
                        show_planEnd.setText("計劃結束：15:45");
                        show_group.setText("一群-沖床");
                        show_existOrOver.setText("結案");
                        show_existOrOver.setTextColor(Color.RED);
                        break;
                    case 1:
                        show_orderNumber.setText(intent.getStringExtra("numA"));
                        show_sourceOrder.setText(intent.getStringExtra("numB"));
                        show_masterPartNumber.setText(intent.getStringExtra("numC"));
                        show_MotherPartProductName.setText(intent.getStringExtra("this_MotherPartProductName"));
                        show_EstimatedLaunchTime.setText("預計上線：2018-12-06");
                        show_amount.setText("生產數量：3");
                        show_planBegins.setText("計劃開始：08:00");
                        show_planEnd.setText("計劃結束：08:05");
                        show_group.setText("一群-點焊");
                        show_existOrOver.setText("生效");
                        show_existOrOver.setTextColor(Color.GREEN);
                        break;
                    case 2:
                        show_orderNumber.setText(intent.getStringExtra("later_orderNumber"));
                        show_sourceOrder.setText(intent.getStringExtra("numB"));
                        show_masterPartNumber.setText(intent.getStringExtra("later_masterPartNumber"));
                        show_MotherPartProductName.setText(intent.getStringExtra("later_MotherPartProductName"));
                        show_EstimatedLaunchTime.setText("預計上線：2018-12-07");
                        show_amount.setText("生產數量：3");
                        show_planBegins.setText("計劃開始：09:30");
                        show_planEnd.setText("計劃結束：09:50");
                        show_group.setText("一群-塗裝");
                        show_existOrOver.setText("生效");
                        show_existOrOver.setTextColor(Color.GREEN);
                        break;
                    case 3:
                        show_orderNumber.setText(intent.getStringExtra("assembly_orderNumber"));
                        show_sourceOrder.setText(intent.getStringExtra("numB"));
                        show_masterPartNumber.setText(intent.getStringExtra("assembly_masterPartNumber"));
                        show_MotherPartProductName.setText(intent.getStringExtra("assembly_MotherPartProductName"));
                        show_EstimatedLaunchTime.setText("預計上線：2018-12-08");
                        show_amount.setText("生產數量：3");
                        show_planBegins.setText("計劃開始：08:00");
                        show_planEnd.setText("計劃結束：08:05");
                        show_group.setText("一群-裝配");
                        show_existOrOver.setText("生效");
                        show_existOrOver.setTextColor(Color.GREEN);
                        break;
                    case 4:
                        show_orderNumber.setText(intent.getStringExtra("numB")); // 在原本欄位做來源訂單的資料顯示
                        show_sourceOrder.setText(intent.getStringExtra("        "));
                        show_masterPartNumber.setText("客戶名稱：(M1315) MATADOR GmbH");
                        show_MotherPartProductName.setText("客戶訂單：6003028");
                        show_group.setText(" ");
                        show_existOrOver.setText("生效");
                        show_existOrOver.setTextColor(Color.GREEN);
                        show_EstimatedLaunchTime.setText("業務人員：(M3049) 嚴卉婷");
                        show_amount.setText(" ");
                        show_planBegins.setText(" ");
                        show_planEnd.setText("");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        nextpageright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = todayViewPager2.getCurrentItem();
                if (currentItem < Adapter.getItemCount() - 1) {
                    todayViewPager2.setCurrentItem(currentItem + 1);
                }
            }
        });

        nextpageleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = todayViewPager2.getCurrentItem();
                if (currentItem > 0) {
                    todayViewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });
    }

    // 更新按钮可见性的函数
    private void updateButtonVisibility(int position) {
        if (position == 0) {
            nextpageleft.setVisibility(View.INVISIBLE);
        } else {
            nextpageleft.setVisibility(View.VISIBLE);
        }

        if (position == Adapter.getItemCount() - 1) {
            nextpageright.setVisibility(View.INVISIBLE);
        } else {
            nextpageright.setVisibility(View.VISIBLE);
        }
    }
}
