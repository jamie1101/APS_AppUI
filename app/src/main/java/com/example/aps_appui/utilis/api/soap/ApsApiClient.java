package com.example.aps_appui.utilis.api.soap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApsApiClient {
    public Retrofit myApsApi(){
        return new Retrofit.Builder()
                .baseUrl("http://10.20.1.2:9000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
