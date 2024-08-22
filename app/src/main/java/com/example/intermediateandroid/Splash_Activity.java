package com.example.intermediateandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = sharedPreferences.getBoolean("flag",false);

                Intent intent;
                if(check)
                {
                    intent = new Intent(Splash_Activity.this,Home_Activity.class);
                }
                else
                {
                    intent = new Intent(Splash_Activity.this,Login_Activity.class);
                }
                startActivity(intent);
            }
        },3000);
    }
}