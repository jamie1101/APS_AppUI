package com.example.aps_appui.ui.login;

import android.content.Intent;

import com.example.aps_appui.ui.menu.MenuActivity;

public class LoginPresenter implements LoginContract.presenter{
    private LoginContract.view callback;
    public LoginPresenter(LoginContract.view view){
        this.callback=view;
    }
    @Override
    public  void getLoginData(String account,String password) {
        callback.tomenu();
    }
}
