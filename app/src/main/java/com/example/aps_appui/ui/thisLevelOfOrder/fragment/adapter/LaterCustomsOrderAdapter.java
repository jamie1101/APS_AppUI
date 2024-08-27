package com.example.aps_appui.ui.thisLevelOfOrder.fragment.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps_appui.R;

import java.util.ArrayList;
import java.util.HashMap;

public class LaterCustomsOrderAdapter extends RecyclerView.Adapter<LaterCustomsOrderAdapter.ViewHolder> {
    private ArrayList<HashMap<String, String>> List;
    private Activity activity;

    public LaterCustomsOrderAdapter(ArrayList<HashMap<String, String>> list, FragmentActivity activity) {
        this.List =list;
        this.activity = activity;
    }


    @NonNull
    @Override
    public LaterCustomsOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_later_customs_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaterCustomsOrderAdapter.ViewHolder holder, int position) {
        holder.tx1.setText(List.get(position).get("num1"));
        holder.tx2.setText(List.get(position).get("num2"));
        holder.tx3.setText(List.get(position).get("num3"));
        holder.tx4.setText(List.get(position).get("num4"));
        holder.tx5.setText(List.get(position).get("num5"));
        holder.tx6.setText(List.get(position).get("num6"));
        holder.tx7.setText(List.get(position).get("num7"));
        holder.tx8.setText(List.get(position).get("num8"));
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tx1 = itemView.findViewById(R.id.num1);
            tx2 = itemView.findViewById(R.id.num2);
            tx3 = itemView.findViewById(R.id.num3);
            tx4 = itemView.findViewById(R.id.num4);
            tx5 = itemView.findViewById(R.id.num5);
            tx6 = itemView.findViewById(R.id.num6);
            tx7 = itemView.findViewById(R.id.num7);
            tx8 = itemView.findViewById(R.id.num8);
        }
    }
}
