package com.example.gaurav.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessanginService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String msg = "none";
        if (remoteMessage.getNotification()!= null) {
            msg = remoteMessage.getNotification().getBody();
        } else if (remoteMessage.getData() != null) {
            msg = remoteMessage.getData().get("MyName");
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentText(msg)
                .setSubText("MyName")
                .setColor(Color.BLUE)
                .setContentTitle("Gaurav")
                .setSmallIcon(R.mipmap.ic_launcher);
        PendingIntent pi = PendingIntent.getActivities(
                this,
                123
                , new Intent[]
                        {new Intent(this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)}, 0);
        builder.setContentIntent(pi);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(11, builder.build());
    }
}
