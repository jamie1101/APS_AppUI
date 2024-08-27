package com.example.aps_appui.ui.menu.fragment.listadapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.thisLevelOfOrder.ThisLevelOfOrderActivity;
import com.example.aps_appui.ui.thisLevelOfOrder.fragment.InsideThisLevelOfOrderFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TodayprogressAdapter extends RecyclerView.Adapter<TodayprogressAdapter.ViewHolder>{
    private String pr_orderNumber,pr_masterPartNumber,pr_sourceOrder,pr_MotherPartProductName;
    private String later_orderNumber,later_masterPartNumber,later_sourceOrder,later_MotherPartProductName;
    private String assembly_orderNumber,assembly_masterPartNumber,assembly_sourceOrder,assembly_MotherPartProductName;
    private String this_orderNumber,this_masterPartNumber,this_sourceOrder,this_MotherPartProductName;
    private ArrayList<HashMap<String, String>> List;
    private Activity activity;

    // 正确的构造函数
    public TodayprogressAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.List = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_todayprogress, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tx0.setText(List.get(position).get("num"));
        holder.tx1.setText(List.get(position).get("numA"));
        holder.tx2.setText(List.get(position).get("numB"));
        holder.tx3.setText(List.get(position).get("numC"));
        holder.tx4.setText(List.get(position).get("numD"));
        holder.tx5.setText(List.get(position).get("amount"));
        holder.tx6.setText(List.get(position).get("ClosingDate"));
        holder.tx7.setText(List.get(position).get("PlanBegins"));
        holder.tx8.setText(List.get(position).get("group"));
        //點擊事件傳送資料
        holder.view08.setOnClickListener((v)->{
            pr_orderNumber="1MO18120"+String.valueOf(new Random().nextInt(89999)+10000);
//            pr_sourceOrder="1SO1811"+String.valueOf(new Random().nextInt(999999));   //五筆來源資料都一樣所以不用設
            pr_masterPartNumber="F"+String.valueOf(new Random().nextInt(99999))
                    +String.valueOf(new Random().nextInt(2) == 0 ? "ATN" : "M")
                    +"-"+String.valueOf(new Random().nextInt(2) == 0 ?"1A":"2");
            pr_MotherPartProductName="ATN260011  垃圾桶系統櫃門片0.8*613.7*236.3mm-沖床組(6折)";
            //當階製令的抓todayadapter的資料
            this_MotherPartProductName="ATN260011  系統櫃(垃圾筒) -抽屜+垃圾筒固定片*4pcs";
            //
            later_orderNumber="1MO18120"+String.valueOf(new Random().nextInt(89999)+10000);
//            later_sourceOrder="1SO1811"+String.valueOf(new Random().nextInt(999999));
            later_masterPartNumber="F"+String.valueOf(new Random().nextInt(99999))
                    +String.valueOf(new Random().nextInt(2) == 0 ? "ATN" : "M")
                    +"-"+String.valueOf(new Random().nextInt(2) == 0 ?"1A":"2");
            later_MotherPartProductName="EP340T砂漆灰-ATN260011 系統櫃(垃圾桶)抽屜(21.8)塗裝";
            //裝置配令的亂數
            assembly_orderNumber="1MO18120"+String.valueOf(new Random().nextInt(89999)+10000);
//            assembly_sourceOrder="1SO1811"+String.valueOf(new Random().nextInt(999999));
            assembly_masterPartNumber="F"+String.valueOf(new Random().nextInt(99999))
                    +String.valueOf(new Random().nextInt(2) == 0 ? "ATN" : "M")
                    +"-"+String.valueOf(new Random().nextInt(2) == 0 ?"1A":"2");
            assembly_MotherPartProductName="EP338T砂漆淺灰/EP340T砂漆灰系統櫃組合---26下箱垃圾桶櫃";


            Intent intent=new Intent(activity,ThisLevelOfOrderActivity.class); //intent 必須在這先創好activity跟分頁fragment要使用到的亂數
//            這樣Activity裡面的fragment 5頁分頁在抓activity的訂單編號、來源訂單、母件編號、跟母件品名可以使用intent.getActivity.getintent()輕鬆抓到

            intent.putExtra("numA",List.get(position).get("numA"));
            intent.putExtra("numB",List.get(position).get("numB"));
            intent.putExtra("numC",List.get(position).get("numC"));
            intent.putExtra("numD",List.get(position).get("numD"));


            //
            intent.putExtra("this_MotherPartProductName", this_MotherPartProductName);
            //

            intent.putExtra("pr_orderNumber", pr_orderNumber);
//            intent.putExtra("pr_sourceOrder", pr_sourceOrder);
            intent.putExtra("pr_masterPartNumber", pr_masterPartNumber);
            intent.putExtra("pr_MotherPartProductName", pr_MotherPartProductName);

            intent.putExtra("later_orderNumber", later_orderNumber);
//            intent.putExtra("later_sourceOrder", later_sourceOrder);
            intent.putExtra("later_masterPartNumber", later_masterPartNumber);
            intent.putExtra("later_MotherPartProductName", later_MotherPartProductName);

            intent.putExtra("assembly_orderNumber", assembly_orderNumber);
//            intent.putExtra("assembly_sourceOrder", assembly_sourceOrder);
            intent.putExtra("assembly_masterPartNumber", assembly_masterPartNumber);
            intent.putExtra("assembly_MotherPartProductName", assembly_MotherPartProductName);
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    // 绑定组件
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tx0, tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
        private  View view08;
        public ViewHolder(View itemView) {
            super(itemView);
            tx0 = itemView.findViewById(R.id.today_tx0);
            tx1 = itemView.findViewById(R.id.today_tx1);
            tx2 = itemView.findViewById(R.id.today_tx2);
            tx3 = itemView.findViewById(R.id.today_tx3);
            tx4 = itemView.findViewById(R.id.today_tx4);
            tx5 = itemView.findViewById(R.id.today_tx5);
            tx6 = itemView.findViewById(R.id.today_tx6);
            tx7 = itemView.findViewById(R.id.today_tx7);
            tx8 = itemView.findViewById(R.id.today_tx8);

            view08=itemView;
        }
    }
}
