package com.example.dell.shopwithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GridView gridview =findViewById(R.id.gridview);



        Api api= retrofit.create(Api.class);
        Call<List<HandSet>> call=api.getPhone();
        call.enqueue(new Callback<List<HandSet>>() {
            @Override
            public void onResponse(Call<List<HandSet>> call, Response<List<HandSet>> response) {
             List<HandSet> phones=response.body();
             for(HandSet hs:phones){
                 Log.d("model",hs.getModel());

             }
            }

            @Override
            public void onFailure(Call<List<HandSet>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "hmm..", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
/* <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:id="@+id/rv3"
        android:layout_height="match_parent"
        android:layout_alignParentTop="true" /> */