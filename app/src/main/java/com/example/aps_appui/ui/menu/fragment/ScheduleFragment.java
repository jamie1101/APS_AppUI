package com.example.aps_appui.ui.menu.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.progressTableQuery.ProgressTableQueryActivity;
import com.example.aps_appui.ui.setting.SettingActivity;

public class ScheduleFragment extends Fragment {
    private Button bt; //Progress_table_queryActivity進度表查詢
    private Button bt2;//SettingActivity設定
    public ScheduleFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        bt = view.findViewById(R.id.button1);
        bt2=view.findViewById(R.id.button5);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the Progress_table_queryActivity
                Intent intent = new Intent(getActivity(), ProgressTableQueryActivity.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the Progress_table_queryActivity
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
