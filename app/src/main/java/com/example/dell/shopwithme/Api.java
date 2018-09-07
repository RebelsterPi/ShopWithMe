package com.example.dell.shopwithme;

import android.provider.ContactsContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 06-09-2018.
 */

public interface Api {
    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";
    @GET("get-items")
    Call<List<HandSet>>getPhone(

    );

}
