package com.example.aps_appui.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.menu.MenuActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    private EditText acccount;
    private EditText password;
    private Button button;



    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        acccount=findViewById(R.id.login_account_et);
        password=findViewById(R.id.login_password_et);
        button=findViewById(R.id.login_button_bt);
        presenter=new LoginPresenter(this);
    }
    public void buttonOnClick(View view){
        presenter.getLoginData(acccount.getText().toString(),password.getText().toString());
    }

    @Override
    public void tomenu(){
        Intent intent1=new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent1);
    }

}