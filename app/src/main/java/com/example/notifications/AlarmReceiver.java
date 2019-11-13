package com.example.notifications;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // this method can be used to run any task that should fire and return a result. ie fetch notifications

        System.out.println("I am inside the reciever");
        Bundle received = intent.getExtras();
        String first = received.getString("first");
        String second = received.getString("second");
        String third = received.getString("third");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel")
                .setSmallIcon(R.drawable.flutter_logo)
                .setContentTitle(first)
                .setContentText(second)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(third))
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());

        System.out.println("the builder has built the notification and i'm displayed");

    }
}
