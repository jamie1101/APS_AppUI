package com.example.aps_appui.ui.thisLevelOfOrder.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.adapter.AssemblyOrderAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AssemblyOrderFragment extends Fragment {
    private TextView show_orderNumber,show_masterPartNumber,show_sourceOrderNumber,show_MotherPartProductName;
    private RecyclerView recyclerView;
    private AssemblyOrderAdapter assemblyOrderAdapter;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    public AssemblyOrderFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assembly_order, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.assembly_order_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        assemblyOrderAdapter = new AssemblyOrderAdapter(arrayList, getActivity());
        recyclerView.setAdapter(assemblyOrderAdapter);
        makeData();
        //
        show_orderNumber = view.findViewById(R.id.assembly_numA);
        show_sourceOrderNumber=view.findViewById(R.id.assembly_numB);
        show_masterPartNumber=view.findViewById(R.id.assembly_numC);
        show_MotherPartProductName=view.findViewById(R.id.assembly_numD);
        Intent getintent = getActivity().getIntent();
        show_orderNumber.setText(getintent.getStringExtra("assembly_orderNumber"));
        show_sourceOrderNumber.setText(getintent.getStringExtra("numB"));
        show_masterPartNumber.setText(getintent.getStringExtra("assembly_masterPartNumber"));
        show_MotherPartProductName.setText(getintent.getStringExtra("assembly_MotherPartProductName"));

        //
//        orderNumber.setText("1MO18120"+String.valueOf(new Random().nextInt(89999)+10000));
//        masterPartNumber.setText("1SO1811"+String.valueOf(new Random().nextInt(999999)));
//        sourceOrder.setText("F"+String.valueOf(new Random().nextInt(99999))
//                +String.valueOf(new Random().nextInt(2) == 0 ? "ATN" : "M")
//                +"-"+String.valueOf(new Random().nextInt(2) == 0 ?"1A":"2"));
//
//
//        MotherPartProductName.setText("EP338T砂漆淺灰/EP340T砂漆灰系統櫃組合---26下箱垃圾桶");

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
       assemblyOrderAdapter.notifyDataSetChanged(); // 通知 Adapter 数据已更改
    }
}