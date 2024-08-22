package com.example.intermediateandroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Accelerometer_SensorActivity extends AppCompatActivity implements SensorEventListener {

    TextView value_x,value_y,value_z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accelerometer_sensor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // get id
        value_x = findViewById(R.id.accelerometer_sensor_value_x);
        value_y = findViewById(R.id.accelerometer_sensor_value_y);
        value_z = findViewById(R.id.accelerometer_sensor_value_z);

        SensorManager sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null)
        {
            Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(sensor!=null)
            {
                sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        else
        {
            Toast.makeText(Accelerometer_SensorActivity.this,"Your sensor can't work",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            value_x.setText("X = "+event.values[0]);
            value_y.setText("Y = "+event.values[1]);
            value_z.setText("Z = "+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}