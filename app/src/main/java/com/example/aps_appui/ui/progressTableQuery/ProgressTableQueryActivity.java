package com.example.aps_appui.ui.progressTableQuery;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.login.LoginModel;
import com.example.aps_appui.ui.progressTableDataList.ProgressTableDataListActivity;
import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class ProgressTableQueryActivity extends AppCompatActivity implements ProgressTableQueryContract.View{
    private Button progress_back, confirm, date_button, so_id_button, customer_button;
    private EditText show_date;
    private TextView people_name;
    private ProgressTableQueryContract.Presenter presenter;
    private Spinner spinner;
    private GetApi getApi;
    private ApsApiClient apsApiClient;
    private String token;
    private EditText  input_so_id;
    private EditText input_name;
   private SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_progress_table_query);

        // 初始化 View
        date_button = findViewById(R.id.date_button);
        so_id_button = findViewById(R.id.so_id_button);
        customer_button = findViewById(R.id.customer_name_button);
        confirm = findViewById(R.id.button7);
        show_date = findViewById(R.id.show_date);
        people_name = findViewById(R.id.people_Name_ProgressTableQuery);
        progress_back = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        input_name = findViewById(R.id.editCustomerName);
        input_so_id=findViewById(R.id.inputSoIdButton);
        //api
        apsApiClient = new ApsApiClient();
        getApi = apsApiClient.myApsApi().create(GetApi.class);

        // 初始化 Presenter
        presenter = new ProgressTableQueryPresenter(this, new LoginModel(this), new ApsApiClient(), this);

        // 初始化 Spinner
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"點焊"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // 按鈕點擊事件
        progress_back.setOnClickListener(view -> finish());

        confirm.setOnClickListener(view -> presenter.onConfirmButtonClicked());

        date_button.setOnClickListener(view -> presenter.onDateButtonClicked());

        customer_button.setOnClickListener(view -> {
            // 取得 input_name 中的內容作為模糊查詢關鍵字
            String inputCustomerName = input_name.getText().toString().trim();
            presenter.onCustomerButtonClicked(inputCustomerName);
            Log.e("ProgressTable", "onCreate: ");
        });
        so_id_button.setOnClickListener(view -> {
            String inputSoId=input_so_id.getText().toString().trim();
            presenter.onSoIdButtonClicked(inputSoId);
        });

        // 加載用戶數據
        presenter.loadUserData();
    }
    @Override
    public void showCustomerList(String[] customerNames) {
        Log.e("TAG", "showCustomerList: ");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("選擇客戶名");
        // 設定單選列表，讓用戶選擇客戶名稱
        builder.setSingleChoiceItems(customerNames, -1, (dialog, which) -> {// 取得使用者選擇的客戶名稱
        String selectedCustomer = customerNames[which];
        sharedPreferences=getSharedPreferences("data_name",MODE_PRIVATE);
        sharedPreferences.edit().putString("selectedCustomer",selectedCustomer).apply();
        input_name.setText(selectedCustomer); // 將選擇的名稱顯示在 input_name 這個 EditText
        dialog.dismiss(); // 選擇後關閉對話框
        });
        // 顯示對話框
        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
    @Override
    public  void showSoIdList(String[] soId) {
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("選擇單號");

        // 設定單選列表，讓用戶選擇單號
        builder2.setSingleChoiceItems(soId, -1, (dialog, which) -> {
            // 取得使用者選擇的單號
            String selectedSoId = soId[which];
            sharedPreferences=getSharedPreferences("data_name",MODE_PRIVATE);
            sharedPreferences.edit().putString("selectedSoId",selectedSoId).apply();
            input_so_id.setText(selectedSoId); // 將選擇的單號顯示在 input_so_id 這個 EditText
            dialog.dismiss(); // 選擇後關閉對話框
        });
        // 顯示對話框
        builder2.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
        builder2.create().show();

    }
    @Override
    public void showSelectedDate(String date) {
        show_date.setText(date);
    }

    @Override
    public void navigateToProgressTableDataList() {
        Intent intent = new Intent(this, ProgressTableDataListActivity.class);
        startActivity(intent);
    }

    @Override
    public void showName(String name) {
        people_name.setText(name);
    }
}