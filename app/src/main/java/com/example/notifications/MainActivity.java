package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putString("first", "This is the first");
        bundle.putString("second", "this is the second");
        bundle.putString("third", "this is the third");
        intent.putExtras(bundle);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Set the alarm to start at your chosen time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        //you'll need to configure the timing yourself. In this case for infiniitely repeating alarms
        //i don't care so i'll fire at will

        // setRepeating() lets you specify a precise custom interval--in this case,
        // every one minute.
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60, alarmIntent);


    }

}
