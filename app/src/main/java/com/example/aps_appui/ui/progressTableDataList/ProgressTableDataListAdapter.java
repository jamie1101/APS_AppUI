package com.example.aps_appui.ui.progressTableDataList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps_appui.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ProgressTableDataListAdapter extends RecyclerView.Adapter<ProgressTableDataListAdapter.ViewHolder> {
    private ArrayList<HashMap<String, String>> arrayList;
    private Activity activity;
    public ProgressTableDataListAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.arrayList = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_progress_table_data_list, parent, false);
        return new ProgressTableDataListAdapter.ViewHolder(view);

    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ProgressTableDataListAdapter.ViewHolder holder, int position) {
        HashMap<String, String> item = arrayList.get(position);
        holder.tx0.setText(item.get("number"));
        holder.tx1.setText(item.get("mo_id"));
        holder.tx2.setText(item.get("so_id"));
        holder.tx3.setText(item.get("item_id"));
        holder.tx4.setText(item.get("material_name")); // 假設你有這個key
        holder.tx5.setText(item.get("qty"));
        holder.tx6.setText(item.get("complete_date"));
        holder.tx7.setText(item.get("online_date"));
        holder.tx8.setText(item.get("tech_routing_name"));
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public void updateData(ArrayList<HashMap<String, String>> newData) {
        this.arrayList.clear();
        this.arrayList.addAll(newData);
        notifyDataSetChanged();
    }

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
