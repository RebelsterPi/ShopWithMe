package com.example.dell.shopwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity1 extends AppCompatActivity {
    private RecyclerView rcv;
    private List<HandSet> phoneList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);


       /*ApiClient*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rcv = findViewById(R.id.rv3);
        rcv.setLayoutManager(new GridLayoutManager(this, 2));


        Api api = retrofit.create(Api.class);
        Call<List<HandSet>> call = api.getPhone();
        call.enqueue(new Callback<List<HandSet>>() {
            @Override
            public void onResponse(Call<List<HandSet>> call, Response<List<HandSet>> response) {
                List<HandSet> phones = response.body();
                for (HandSet hs : phones) {
                    String model = hs.getModel();
                    String manufacture = hs.getManufacturer();
                    String price = hs.getPrice();
                    String image = hs.getImage();
                    phoneList.add(new HandSet(model, manufacture, price, image));

                }
                rcv.setAdapter(new HandSetAdapater(getApplicationContext(), phoneList));

            }

            @Override
            public void onFailure(Call<List<HandSet>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "hmm..", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
    /*menu*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option, menu);
        return (super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.query) {
            startActivity(new Intent(activity1.this, MainActivity.class));
            return (true);
        }
        return (super.onOptionsItemSelected(item));
    }
}