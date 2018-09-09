package com.example.dell.shopwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.materialrangebar.IRangeBarFormatter;
import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {
private RangeBar rangebar;
private Button button;
private EditText t1,t2,t3,t4;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
t1=findViewById(R.id.editText);
t2=findViewById(R.id.editText2);
t3=findViewById(R.id.editText3);
        t4=findViewById(R.id.editText4);
         final String company,manuf,min,max;


           /* rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
                @Override
                public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                                  int rightPinIndex, String leftPinValue, String rightPinValue) {
                }
            });

            rangebar.setFormatter(new IRangeBarFormatter() {
                @Override
                public String format(String s) {
                    // Transform the String s here then return s
                    return null;
                }
            });
    */

        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),activity1.class);
                i.putExtra("comp",t1.getText().toString());
                i.putExtra("model",t2.getText().toString());
                i.putExtra("minp",t3.getText().toString());
                i.putExtra("maxp",t4.getText().toString());

                startActivity(i);

            }
        });

    }



}
