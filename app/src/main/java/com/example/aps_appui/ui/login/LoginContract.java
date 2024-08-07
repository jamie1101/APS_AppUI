package com.example.aps_appui.ui.login;

import android.content.Intent;

public interface LoginContract {
    interface view{
        void tomenu();
    }
    interface presenter{
        void getLoginData(String account,String password);
    }
    interface  modle{

    }

}
