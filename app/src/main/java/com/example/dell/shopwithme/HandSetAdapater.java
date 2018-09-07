package com.example.dell.shopwithme;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

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
            imgp = itemView.findViewById(R.id.img);
            model = itemView.findViewById(R.id.mod);
            manufacture = itemView.findViewById(R.id.manu);
            price = itemView.findViewById(R.id.amt);
        }
    }

    @Override
    public HandSetAdapater.HSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.content_main, parent, false);
        return new HSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HandSetAdapater.HSViewHolder holder, int position) {
        HandSet handset = phonelist.get(position);
        Glide.with(holder.imgp.getContext()).load(phonelist.get(position).getImage()).into(holder.imgp);
        holder.model.setText(handset.getModel());
        holder.manufacture.setText(handset.getManufacturer());
        holder.price.setText(handset.getPrice());


    }

    @Override
    public int getItemCount() {
        return phonelist.size();
    }

}
