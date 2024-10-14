package com.example.aps_appui.ui.progressTableDataList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.aps_appui.utilis.api.soap.ApsApiClient;
import com.example.aps_appui.utilis.api.soap.GetApi;
import com.example.aps_appui.utilis.api.soap.response.ApsManufactureResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ProgressTableDataListPresenter implements ProgressTableDataListContract.Presenter {
    private final static String TAG = "ProgressTableDataListPresenter";
    private GetApi getApi;
    private ApsApiClient apiClient;
    private Activity activity;
    public ProgressTableDataListPresenter(ProgressTableDataListContract.View view, Context context, Activity activity) {
        this.getApi = new ApsApiClient().myApsApi().create(GetApi.class);
        this.activity = activity;
    }

    public void getManufacture(String customer,String sale_order, String token) {
        Log.e(TAG, "getManufacture sale_order: "  + sale_order);
        Log.e(TAG, "getManufacture customer: "  + customer);
        Log.e(TAG, "getManufacture token: "  + token);
        getApi.getManufacture(customer,sale_order,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ApsManufactureResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }
                    @Override
                    public void onNext(@NonNull List<ApsManufactureResponse> apsManufactureResponse) {
                        ArrayList<HashMap<String, String>> dataList = new ArrayList<>();

                        for (ApsManufactureResponse response : apsManufactureResponse) {
                            HashMap<String, String> data = new HashMap<>();
                            data.put("number", String.valueOf(dataList.size() + 1));
                            data.put("so_id", sale_order);
                            data.put("mo_id", response.getMo_id());
                            data.put("item_id", response.getItem_id());
                            data.put("item_name", response.getItem_name());
                            data.put("qty", response.getQty());
                            data.put("online_date", response.getOnline_date());
                            data.put("complete_date", response.getComplete_date());
                            data.put("tech_routing_name", response.getTech_routing_name());
                            data.put("unit_id", response.getUnit_id());
                            data.put("material_id", response.getMaterial_id());
                            // 加入其他需要的資料
                            dataList.add(data);
                        }
                        Log.e(TAG, "getManufacture dataList: " + dataList);

                        // 更新 RecyclerView 的資料
                        activity.runOnUiThread(() -> {
                            if (activity instanceof ProgressTableDataListActivity) {
                                Log.e(TAG, "updateAdapter: ");
                                ((ProgressTableDataListActivity) activity).updateAdapter(dataList);
                            }
                        });


                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("tag"," dataList"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
