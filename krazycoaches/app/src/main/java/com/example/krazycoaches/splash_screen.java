package com.example.krazycoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class splash_screen extends AppCompatActivity {
    CountDownTimer splashTime;
    int splash_timer;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splash_timer = 3000;
        context = this;
        splashTime = new CountDownTimer(splash_timer,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent toSelection = new Intent(context,MainActivity.class);
                startActivity(toSelection);

            }
        }.start();
    }
}