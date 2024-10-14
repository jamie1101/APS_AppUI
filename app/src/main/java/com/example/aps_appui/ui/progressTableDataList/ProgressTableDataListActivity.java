package com.example.aps_appui.ui.progressTableDataList;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.login.LoginModel;
import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ProgressTableDataListActivity extends AppCompatActivity implements ProgressTableDataListContract.View {
    private Button back;
    private TextView peopleName;
    private SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private  ProgressTableDataListAdapter adapter;
    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    private ProgressTableDataListPresenter presenter;

    private String customer,sale_order,token;
    public ProgressTableDataListActivity() {
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_progress_table_data_list);
        presenter = new ProgressTableDataListPresenter(this,this,this);
        sharedPreferences=getSharedPreferences("data_name",MODE_PRIVATE);
        customer=sharedPreferences.getString("selectedCustomer","default_value");
        sale_order=sharedPreferences.getString("selectedSoId","default_value");
        token=sharedPreferences.getString("token","default_value");
        presenter.getManufacture(customer,sale_order,token);

        peopleName = findViewById(R.id.people_Name_Progress_table_data_list);
        sharedPreferences= getSharedPreferences("data_name", MODE_PRIVATE);
        String name =sharedPreferences.getString("customer_name", "default_name");
        peopleName.setText(name);
        back=findViewById(R.id.progressDataListBack);
        back.setOnClickListener(view -> {
            finish();
        });
        recyclerView = findViewById(R.id.progressTableDataListRecycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new ProgressTableDataListAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
    public void updateAdapter(ArrayList<HashMap<String, String>> data) {

        adapter.updateData(data);
    }


}