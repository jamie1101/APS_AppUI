package com.example.aps_appui.ui.menu.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.menu.fragment.listadapter.TodayprogressAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TodayprogressFragment extends Fragment {
    private RecyclerView recyclerView;
    private TodayprogressAdapter todayprogressAdapter;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    public TodayprogressFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todayprogress, container, false);
    }
    //使用context(fragment跟activity的區別)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.todayprogressrecycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todayprogressAdapter = new TodayprogressAdapter(arrayList, getActivity());
        recyclerView.setAdapter(todayprogressAdapter);
        makeData();
    }
    //產生表單內資料
    private void makeData() {
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("num", String.valueOf(i+1));
            hashMap.put("numA", "1MO18120"+String.valueOf(new Random().nextInt(89999)+10000));
            hashMap.put("numB", "1SO1811"+String.valueOf(new Random().nextInt(999999)));
            hashMap.put("numC", "F"+String.valueOf(new Random().nextInt(99999))
                    +String.valueOf(new Random().nextInt(2) == 0 ? "ATN" : "M")
                    +"-"+String.valueOf(new Random().nextInt(2) == 0 ?"1A":"2"));
            hashMap.put("numD",String.valueOf(new Random().nextInt(2) == 0 ?"MATADOR":"祥雲工具股.."));

            hashMap.put("amount", "數量:" + String.valueOf(new Random().nextInt(100)));
            hashMap.put("ClosingDate", "結關日:" + (new Random().nextInt(100) + 2018) + "-"
                    + (new Random().nextInt(11) + 1) + "-"
                    + (new Random().nextInt(30) + 1));
            hashMap.put("PlanBegins", "計畫開始:" + (new Random().nextInt(23) + 1)
                    + ":" + String.valueOf(new Random().nextInt(60)));
            hashMap.put("group", "一群-點焊");
            arrayList.add(hashMap);
        }
        todayprogressAdapter.notifyDataSetChanged(); // 通知 Adapter 数据已更改
    }
}
