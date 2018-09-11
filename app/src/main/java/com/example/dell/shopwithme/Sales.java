package com.example.dell.shopwithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sales extends AppCompatActivity {
    private RecyclerView rcvcart;
    RecyclerView.LayoutManager layout;
    OrderAdapter oadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
       /*apiClient*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api= retrofit.create(Api.class);
        rcvcart=findViewById(R.id.rv_cart);
        Call<List<Order>>call =api.getPurchaces();


        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                 List<Order> orderList = response.body();
                rcvcart.setLayoutManager(layout);
                layout=new LinearLayoutManager(getApplicationContext());

                oadapter=new OrderAdapter(getApplicationContext(),orderList);
                rcvcart.setAdapter(oadapter);

            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Log.v("url",call.request().url().toString());
                Toast.makeText(Sales.this, "dude you spent a lot of money", Toast.LENGTH_SHORT).show();
            }
        });






    }
}
