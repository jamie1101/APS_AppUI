package com.example.aps_appui.ui.login;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;
import com.example.aps_appui.utilis.api.soap.response.ApsAuthResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsLoginResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginPresenter implements LoginContract.presenter {
    private LoginContract.view callback;
    private GetApi getApi;
    private LoginModel loginModel;
    private  SharedPreferences sharedPreferences;;
    public LoginPresenter(LoginContract.view view,Context context) {
        this.callback = view;
        this.getApi = new ApsApiClient().myApsApi().create(GetApi.class);
        this.loginModel = new LoginModel(context);
        this.sharedPreferences = context.getSharedPreferences("data_name", MODE_PRIVATE);
    }


    @Override
    public void getLoginData(String account, String password) {
        // 步驟一：先取得 Token
        getApi.getLoginApi(account, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApsLoginResponse>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(ApsLoginResponse tokenResponse) {
                        String token = tokenResponse.getToken();
                        sharedPreferences.edit().putString("token", token).apply();
                        // 步驟二：用 Token 呼叫 getAuthApi
                        checkLoginWithToken(token, account);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("LoginPresenter", "onError: " + e.getMessage());
                        callback.showError("取得 Token 失敗，請稍後再試");
                    }

                    @Override
                    public void onComplete() {
                        // 取得 Token 完成時的處理（可選）
                    }
                });
    }

    // 步驟二：使用取得的 Token 調用 getAuthApi
    private void checkLoginWithToken(String token, String inputAccount) {
        getApi.getAuthApi(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApsAuthResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }
                    @Override
                    public void onNext(ApsAuthResponse response) {
                        String data_account = response.getAccount();
                        String data_name = response.getName();
                        sharedPreferences.edit().putString("data_account", data_account).apply();
                        sharedPreferences.edit().putString("customer_name", data_name).apply();

                        // 驗證帳號與使用者輸入的帳號是否一致
                        if (inputAccount.equals(data_account)) {
                            callback.tomenu(); // 驗證成功，進入下一頁
                        } else {
                            callback.showToast("帳號不正確");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.showError("登入失敗，請稍後再試");
                    }

                    @Override
                    public void onComplete() {
                        // API 請求完成時的處理（可選）
                    }
                });
    }
}
