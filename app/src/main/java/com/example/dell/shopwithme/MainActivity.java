package com.example.dell.shopwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.appyvet.materialrangebar.IRangeBarFormatter;
import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {
private RangeBar rangebar;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            rangebar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
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
        } catch (RuntimeException e) {


        }


        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m2a=new Intent(getApplicationContext(),activity1.class);
                startActivity(m2a);

            }
        });
    }
}
