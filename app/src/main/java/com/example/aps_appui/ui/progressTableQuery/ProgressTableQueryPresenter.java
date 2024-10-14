package com.example.aps_appui.ui.progressTableQuery;

import static androidx.fragment.app.FragmentManager.TAG;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.util.Log;
import android.widget.TextView;

import com.example.aps_appui.ui.login.LoginModel;
import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;
import com.example.aps_appui.utilis.api.soap.response.ApsSearchCustomerResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsSoIdResponse;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProgressTableQueryPresenter implements ProgressTableQueryContract.Presenter{
private static final String TAG = "ProgressTableQueryPresenter";
    private ProgressTableQueryContract.View view;
    private LoginModel loginModel;
    private ApsApiClient apsApiClient;
    private GetApi getApi;
    private String token;
    private String people_name;
    private SharedPreferences sharedPreferences;
    public ProgressTableQueryPresenter(ProgressTableQueryContract.View view, LoginModel loginModel, ApsApiClient apsApiClient ,Context context) {
        this.view = view;
        this.loginModel = loginModel;
        this.apsApiClient = apsApiClient;
        this.getApi = new ApsApiClient().myApsApi().create(GetApi.class);
        this.sharedPreferences = context.getSharedPreferences("data_name", Context.MODE_PRIVATE);
        this.token = sharedPreferences.getString("token", "");
        this.people_name = sharedPreferences.getString("customer_name", "");

    }

    @Override
    public void onDateButtonClicked() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(((Context) view),
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedYear + "/" + (selectedMonth + 1) + "/" + selectedDay;
                    sharedPreferences.edit().putString("selectedDate", selectedDate).apply();
                    view.showSelectedDate(selectedDate);
                }, year, month, day);
        datePickerDialog.show();
    }
    @Override
    public void getCustomerName(String customer_name,String token) {
        Log.e(TAG, "getCustomerName: " + customer_name);
        Log.e(TAG, "getCustomerName token: " + token);

        // 調用 API 進行模糊查詢
        getApi.getCustomer_name(customer_name, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ApsSearchCustomerResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull List<ApsSearchCustomerResponse> apsSearchCustomerResponses) {
                        Log.e(TAG, "onNext: " + apsSearchCustomerResponses.toString());

                        String[] customer_names = new String[apsSearchCustomerResponses.size()];
                        for (int i = 0; i < apsSearchCustomerResponses.size(); i++) {
                            customer_names[i] = apsSearchCustomerResponses.get(i).get_customer_name();
                        }
                        view.showCustomerList(customer_names);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {}
                });
    }
    @Override
    public void getSoId(String so_id,String token) {
        getApi.getSoId(so_id,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ApsSoIdResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<ApsSoIdResponse> apsSoIdResponse) {
                        String[] so_id = new String[apsSoIdResponse.size()];
                        for (int i = 0; i < apsSoIdResponse.size(); i++) {
                            so_id[i] = apsSoIdResponse.get(i).getSo_id();
                        }
                        view.showSoIdList(so_id);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    @Override
    public void onConfirmButtonClicked() {
        view.navigateToProgressTableDataList();
    }

    @Override
    public void onCustomerButtonClicked(String inputCustomerName) {
        Log.e(TAG, "onCustomerButtonClicked: " + inputCustomerName);
        getCustomerName(inputCustomerName, token);
    }
    @Override
    public  void onSoIdButtonClicked(String inputSoId){
        getSoId(inputSoId,token);
    }
    @Override
    public void loadUserData() {
        view.showName(people_name);
    }
}

