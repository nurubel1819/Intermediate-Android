package com.example.intermediateandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google_map_btn,get_api,web_view,shared_preference,database,take_picture,audion,video;
    Button accelerometer_sensor,proximity_sensor,light_sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //take id
        google_map_btn = findViewById(R.id.google_map);
        get_api = findViewById(R.id.get_api);
        web_view = findViewById(R.id.web_view);
        shared_preference = findViewById(R.id.shared_preference);
        database = findViewById(R.id.database);
        take_picture = findViewById(R.id.take_picture);
        audion = findViewById(R.id.audion);
        video = findViewById(R.id.video_player);
        accelerometer_sensor = findViewById(R.id.accelerometer_sensor);
        proximity_sensor = findViewById(R.id.proximity_sensor);
        light_sensor = findViewById(R.id.light_sensor);

        //Action in use this button
        google_map_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        get_api.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Get_API_Activity.class);
                startActivity(intent);
            }
        });
        web_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Web_view_Activity.class);
                startActivity(intent);
            }
        });
        shared_preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Splash_Activity.class);
                startActivity(intent);
            }
        });
        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DB_Activity.class);
                startActivity(intent);
            }
        });
        take_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Take_picture_Activity.class);
                startActivity(intent);
            }
        });
        audion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Audio_Music_Activity.class);
                startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Video_Activity.class);
                startActivity(intent);
            }
        });
        accelerometer_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Accelerometer_SensorActivity.class);
                startActivity(intent);
            }
        });
        proximity_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Proximity_SensorActivity.class);
                startActivity(intent);
            }
        });
        light_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Light_Sensor_Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Alarm_Activity.class));
            }
        });
    }
}