package com.example.aps_appui.ui.login;

import android.content.Intent;


public interface LoginContract {
    interface view {
        void tomenu();
        void showError(String message);
        void showToast(String message);
    }

    interface presenter {
        void getLoginData(String account, String password);
    }

    interface model {

    }
}

