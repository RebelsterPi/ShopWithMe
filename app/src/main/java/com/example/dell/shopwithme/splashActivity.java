package com.example.dell.shopwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread mt= new Thread()
        {@Override
            public void run(){
            try{
                sleep(1800);
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                finish();
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        };
        mt.start();
    }
}
