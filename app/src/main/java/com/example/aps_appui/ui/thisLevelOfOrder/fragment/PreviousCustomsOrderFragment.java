package com.example.aps_appui.ui.thisLevelOfOrder.fragment;

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
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.listadapter.PreviousCustomsOrderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class PreviousCustomsOrderFragment extends Fragment {
    private RecyclerView recyclerView;
    private PreviousCustomsOrderAdapter previousCustomsOrderAdapter;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    public PreviousCustomsOrderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_previous_customs_order, container, false);
    }
    //使用context(fragment跟activity的區別)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.pr_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        previousCustomsOrderAdapter = new PreviousCustomsOrderAdapter(arrayList, getActivity());
        recyclerView.setAdapter(previousCustomsOrderAdapter);
        makeData();
    }
    //產生表單內資料
    private void makeData() {
        for (int i =0; i < 10; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("num1", String.valueOf(i+1));
            hashMap.put("num2", String.valueOf((char) ('A' + new Random().nextInt(26)))
                    +String.valueOf(new Random().nextInt(100))+"-"
                    +String.valueOf((char) ('A' + new Random().nextInt(26)))
                    +String.valueOf((char) ('A' + new Random().nextInt(26)))
                    +String.valueOf((char) ('A' + new Random().nextInt(26)))
                    +String.valueOf(new Random().nextInt(89999)+10000)+"-"
                    +String.valueOf(new Random().nextInt(98)+1));
            hashMap.put("num3","ATN260011  系統櫃(垃圾筒) -抽屜+垃圾筒固定片*4pcs");
            hashMap.put("num4",String.valueOf((new Random().nextInt(2)==0?"床":"木頭")));
            hashMap.put("num5",String.valueOf(new Random().nextInt(99)+".00"));
            hashMap.put("num6",String.valueOf(new Random().nextInt(99)+".00"));
            hashMap.put("num7","PCS");
            hashMap.put("num8","    ");
            arrayList.add(hashMap);
        }
        previousCustomsOrderAdapter.notifyDataSetChanged(); // 通知 Adapter 数据已更改
    }
}