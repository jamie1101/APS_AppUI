package com.example.aps_appui.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.login.LoginModel;

public class SettingActivity extends AppCompatActivity implements SettingContract.view{
    private TextView setting_name;
    private Button setting_bt;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        setting_name=findViewById(R.id.people_Name_Setting);
        sharedPreferences=getSharedPreferences("data_name",MODE_PRIVATE);
        String name=sharedPreferences.getString("customer_name","default_value");
        setting_name.setText(name);

        setting_bt=findViewById(R.id.button6);
        setting_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}