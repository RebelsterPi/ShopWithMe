package com.example.dell.shopwithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Sales extends AppCompatActivity {
    private RecyclerView rcvcart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
       /*apiClient*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api2= retrofit.create(Api.class);
        rcvcart=findViewById(R.id.rv_cart);
        Call<List<Order>>callorder =api2.getorder();
        callorder.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                List<Order> callorder = response.body();
                rcvcart.setAdapter(new OrderAdapter(getApplicationContext(),callorder));
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(Sales.this, "dude you spent a lot of money", Toast.LENGTH_SHORT).show();
            }
        });






    }
}
