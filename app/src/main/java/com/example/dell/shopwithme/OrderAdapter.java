package com.example.dell.shopwithme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by DELL on 09-09-2018.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{
    private List<Order> orderList;

    public OrderAdapter( List<Order> orderList) {this.orderList=orderList;
    }

    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderAdapter.OrderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(OrderAdapter.OrderViewHolder holder, int position) {
      holder.model.setText("Model : "+orderList.get(position).getModel());
      holder.quantity.setText("Quantity : "+orderList.get(position).getQuantity());
      holder.username.setText("Username : "+orderList.get(position).getUsername());
        holder.username.setText("Invoice : "+orderList.get(position).getInvoicenumber());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView model,username,quantity,invoice;
        public OrderViewHolder(View itemView) {
            super(itemView);
            model=itemView.findViewById(R.id.model_cart);
            username=itemView.findViewById(R.id.usern);
            quantity=itemView.findViewById(R.id.quanti);
            invoice=itemView.findViewById(R.id.invoice);
        }
    }
}
