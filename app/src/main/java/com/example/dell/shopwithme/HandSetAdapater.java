package com.example.dell.shopwithme;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 08-09-2018.
 */

public class HandSetAdapater extends RecyclerView.Adapter<HandSetAdapater.HSViewHolder> {

    private List<HandSet> phonelist;
    private Context context;

    public HandSetAdapater(Context context, List<HandSet> phoneList) {
        this.phonelist = phoneList;
        this.context = context;
    }

    public class HSViewHolder extends RecyclerView.ViewHolder {
        ImageView imgp;
        TextView model, manufacture, price;

        public HSViewHolder(View itemView) {
            super(itemView);
            imgp = itemView.findViewById(R.id.image12);
            model = itemView.findViewById(R.id.mod);
            manufacture = itemView.findViewById(R.id.manu);
            price = itemView.findViewById(R.id.amt);
        }
    }

    @Override
    public HandSetAdapater.HSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.card_main, parent, false);
        return new HSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HandSetAdapater.HSViewHolder holder, int position) {
        HandSet handset = phonelist.get(position);
        Glide.with(holder.imgp.getContext()).load(phonelist.get(position).getImage()).into(holder.imgp);
        holder.model.setText(handset.getModel());
        holder.manufacture.setText(handset.getManufacturer());
        holder.price.setText(String.valueOf(handset.getPrice()));


    }


    @Override
    public int getItemCount() {
        return phonelist.size();
    }

    public void givingValue(final String phone){
        AlertDialog.Builder dialog=new AlertDialog.Builder(context);

        View view= LayoutInflater.from(context).inflate(R.layout.dialogpops, null);
        dialog.setView(view);

        final EditText username=view.findViewById(R.id.yes);
        final EditText quantity=view.findViewById(R.id.no);

        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Api.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api =retrofit.create(Api.class);
                                Call<Order> call=api.getorder(phone ,username.getText().toString(), quantity.getText().toString());
                call.enqueue(new Callback<Order>() {
                    @Override
                    public void onResponse(Call<Order> call, Response<Order> response) {
                        Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Order> call, Throwable t) {
                        Toast.makeText(context,t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.setTitle("Details:");
        AlertDialog alert=dialog.create();

        alert.show();
    }

}
