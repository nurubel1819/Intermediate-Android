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

public class Light_Sensor_Activity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_light_sensor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null)
        {
            Sensor light_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            if(light_sensor!=null)
            {
                sensorManager.registerListener(Light_Sensor_Activity.this,light_sensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
            else
            {
                Toast.makeText(Light_Sensor_Activity.this,"sensor can't work",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(Light_Sensor_Activity.this,"sensor manager can't find value",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT)
        {
            ((TextView)findViewById(R.id.light_sensor_value)).setText("value = "+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}