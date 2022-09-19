package com.example.mbsconnects.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.mbsconnects.MainActivity;

import com.example.mbsconnects.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class FirebaseService extends FirebaseMessagingService {
    private final String CHANNEL_ID="channelID";




    @Override
    public void onMessageReceived(@NonNull RemoteMessage remotemessage) {
        super.onMessageReceived(remotemessage);


    
        Intent intent=new Intent(this, MainActivity.class);
        NotificationManager manager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notificationId=new Random().nextInt();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(manager);
        }


        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent intent1=PendingIntent.getActivities(this,0, new Intent[]{intent},PendingIntent.FLAG_ONE_SHOT);

        Notification notification;

        notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("New notification")
                .setContentText("New Upload have taken place, please check out notification to know more")
                .setSmallIcon(R.drawable.alert)
                .setAutoCancel(true)
                .setContentIntent(intent1)

                .build();
        manager.notify(notificationId,notification);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(NotificationManager manager) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "channelName", NotificationManager.IMPORTANCE_HIGH);
        channel.setDescription("My Description");
        channel.enableLights(true);
        channel.setLightColor(R.color.white);

        manager.createNotificationChannel(channel);

    }
}
