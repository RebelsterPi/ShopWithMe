package com.example.dell.shopwithme;

import android.provider.ContactsContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DELL on 06-09-2018.
 */

public interface Api {
    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";
    @GET("get-items")
    Call<List<HandSet>>getPhone();
    @GET("get-items")
    Call<List<HandSet>>getPhone(@Query("model") String model,
                                @Query("manufacturer") String manufacture,
                                @Query("min") String min,
                                @Query("max") String max
                               );
   // @GET("buy")
    //Call<Order>getorder();

    @GET("buy")
        Call<Order>getorder(@Query("model") String model,
                            @Query("username") String username,
                            @Query("qty") String qty);

    @GET("getSalesRecords")
    Call<List<Order>> getPurchaces();

}

