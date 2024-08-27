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
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.adapter.PreviousCustomsOrderAdapter;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.adapter.SalesOrderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SalesOrderFragment extends Fragment {
    private RecyclerView recyclerView;
    private SalesOrderAdapter salesOrderAdapter;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    //


    public SalesOrderFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_sales_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.salesOrderRe);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        salesOrderAdapter = new SalesOrderAdapter(arrayList, getActivity());
        recyclerView.setAdapter(salesOrderAdapter);
        makeData();
    }
    private void makeData() {
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("num1", String.valueOf(i + 1));
            hashMap.put("num2", "ATN260011-" + String.valueOf(90) + 9);
            hashMap.put("num3", "EP338T砂漆淺灰/EP340T砂漆灰 系統櫃組合-26''v下箱垃圾桶櫃");
            hashMap.put("num4", "3.00");
            hashMap.put("num5", "SET");
            hashMap.put("num6", "3.00");
            hashMap.put("num7", "2019/01/29");
            arrayList.add(hashMap);
        }
        salesOrderAdapter.notifyDataSetChanged();
    }
}