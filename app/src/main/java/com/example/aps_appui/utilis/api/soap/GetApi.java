package com.example.aps_appui.utilis.api.soap;

import com.example.aps_appui.utilis.api.soap.response.ApsAuthResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsLoginResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsManufactureResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsSearchCustomerResponse;
import com.example.aps_appui.utilis.api.soap.response.ApsSoIdResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetApi {
    @POST("auth/login")
    Observable<ApsLoginResponse> getLoginApi(
            @Query("account") String name,
            @Query("password") String account
    );

    @GET("auth")
    Observable<ApsAuthResponse> getAuthApi(
            @Query("token") String token
    );
    @GET("app-search-customer")
    Observable<List<ApsSearchCustomerResponse>>getCustomer_name(
            @Query("customer_name") String customer_name,
            @Query("token") String token
    );
    @GET("app-search-so")
    Observable<List<ApsSoIdResponse>>getSoId(
            @Query("so_id") String so_id,
            @Query("token") String token
    );
    @GET("get-manufacture")
    Observable<List<ApsManufactureResponse>>getManufacture(
            @Query("customer") String customer,
            @Query("sale_order") String sale_order,
            @Query("token") String token
    );

}
