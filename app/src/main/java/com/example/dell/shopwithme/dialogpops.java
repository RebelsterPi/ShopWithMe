package com.example.dell.shopwithme;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DELL on 09-09-2018.
 */

public class dialogpops extends DialogFragment implements View.OnClickListener {
EditText gettinguser,gettingquantity;
    Button confirm, cancel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
 View view=inflater.inflate(R.layout.dialogpops,null);
 confirm.setOnClickListener(this);
 cancel.setOnClickListener(this);
 setCancelable(false);
 return view;
    }

        @Override
    public void onClick(View view) {
  if(view.getId()==R.id.yes) {
      Toast.makeText(getActivity(), "confirmed", Toast.LENGTH_SHORT).show();
  }else{
      Toast.makeText(getActivity(), "canceled", Toast.LENGTH_SHORT).show();
  } }
}
