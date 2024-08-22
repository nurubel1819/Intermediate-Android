package com.example.intermediateandroid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Alarm_Activity extends AppCompatActivity {
    static final int ALARM_REQUEST_CODE = 100;

    EditText time_text;
    Button set_alarm,stop_alarm_tome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alarm);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //get id
        time_text = findViewById(R.id.set_alarm_time);
        set_alarm = findViewById(R.id.set_alarm);
        stop_alarm_tome = findViewById(R.id.stop_alarm_tome);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        set_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(time_text.getText().toString());

                long trigger_time = System.currentTimeMillis()+(time*1000);

                Intent intent_broadcast = new Intent(Alarm_Activity.this,my_broadcast_receiver.class);
                Toast.makeText(Alarm_Activity.this,"hi",Toast.LENGTH_LONG).show(); //use for text
                PendingIntent pi = PendingIntent.getBroadcast(Alarm_Activity.this,0,intent_broadcast,0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,trigger_time,pi);
                //alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,trigger_time,5000,pi);
            }
        });

        stop_alarm_tome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}