package com.example.aps_appui.ui.menu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.aps_appui.R;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity implements MenuContract.view {
    private ViewPager2 viewPager;
    private TabLayout tab;
    private FragmentViewPagerAdapter adapter;
    private TextView peoplename;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        viewPager = findViewById(R.id.viewpager);
        tab = findViewById(R.id.tab);

        adapter = new FragmentViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        //sharepreference 抓Loginmodle 中的API人名資料
        peoplename=findViewById(R.id.people_Name_Menu);
        sharedPreferences=getSharedPreferences("data_name",MODE_PRIVATE);
        String name=sharedPreferences.getString("customer_name","default_value");
        peoplename.setText(name);

        new TabLayoutMediator(tab, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) tab.setText("生產排程");
                if (position == 1) tab.setText("當日進度表");
            }
        }).attach();

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(MenuActivity.this, tab.getText(), Toast.LENGTH_SHORT).show();
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