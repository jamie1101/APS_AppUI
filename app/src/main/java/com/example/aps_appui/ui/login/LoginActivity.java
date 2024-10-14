package com.example.aps_appui.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aps_appui.R;
import com.example.aps_appui.ui.menu.MenuActivity;
import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;
import com.example.aps_appui.utilis.api.soap.response.ApsAuthResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsLoginResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity implements LoginContract.view {
    private EditText acccount;
    private EditText password;
    private Button button;
    private GetApi getApi;
    private ApsApiClient apsApiClient;
    private LoginPresenter presenter;
    private String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        acccount = findViewById(R.id.login_account_et);
        password = findViewById(R.id.login_password_et);
        button = findViewById(R.id.login_button_bt);

        presenter = new LoginPresenter(this,this);

        apsApiClient = new ApsApiClient();
        getApi = apsApiClient.myApsApi().create(GetApi.class);

        // 設定按鈕點擊事件
        button.setOnClickListener(view -> {
            String inputAccount = acccount.getText().toString();
            String inputPassword = password.getText().toString();
            presenter.getLoginData(inputAccount, inputPassword); // 呼叫 presenter 的方法
        });
    }

    @Override
    public void tomenu() {
        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
