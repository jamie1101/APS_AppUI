package com.example.aps_appui.ui.progressTableQuery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aps_appui.R;
import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;


public class ProgressTableQueryActivity extends AppCompatActivity implements ProgressTableQueryContract.view{

    private Button progress_back;
    private  Button confirm;
    private  Button date_button,order_number_button,client_button;
    private EditText show_date;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_progress_table_query);


        Spinner spinner=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,new String[]{
                "點焊"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //返回
        progress_back=findViewById(R.id.button);
        progress_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirm=findViewById(R.id.button7);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        date_button=findViewById(R.id.date_button);
        order_number_button=findViewById(R.id.order_number_button);
        client_button=findViewById(R.id.client_button);

        show_date=findViewById(R.id.show_date);

        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取得當前的日期
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // 創建日期選擇對話框
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                // 當日期選擇後，這裡可以處理選擇的日期
                                // 比如顯示在TextView或者儲存到變量中
                                String selectedDate = year + "/" + (month + 1) + "/" + day;
                                // 假設有個TextView顯示選中的日期
                                show_date.setText(selectedDate);
                            }
                        }, year, month, day);

                // 顯示日期選擇對話框
                datePickerDialog.show();
            }
        });
    }
}