package com.example.aps_appui.ui.menu.fragment.listadapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.thisLevelOfOrder.ThisLevelOfOrderActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class TodayprogressAdapter extends RecyclerView.Adapter<TodayprogressAdapter.ViewHolder>{
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
                .inflate(R.layout.fragment_todayprogress_listadapter, parent, false);
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
            Intent intent=new Intent(activity, ThisLevelOfOrderActivity.class);
            intent.putExtra("num",List.get(position).get("num"));
            intent.putExtra("numA",List.get(position).get("numA"));
            intent.putExtra("numB",List.get(position).get("numB"));
            intent.putExtra("numC",List.get(position).get("numC"));
            intent.putExtra("numD",List.get(position).get("numD"));
            intent.putExtra("amount",List.get(position).get("amount"));
            intent.putExtra("ClosingDate",List.get(position).get("ClosingDate"));
            intent.putExtra("PlanBegins",List.get(position).get("PlanBegins"));
            intent.putExtra("group",List.get(position).get("group"));
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
