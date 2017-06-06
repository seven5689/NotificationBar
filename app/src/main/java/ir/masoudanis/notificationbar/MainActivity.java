package ir.masoudanis.notificationbar;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    PendingIntent pi;
    Intent intent;
    NotificationManager notificationManager;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        intent = new Intent(this, MainActivity.class);
        pi = PendingIntent.getActivities(this, (int) System.currentTimeMillis(), new Intent[] {intent}, 0);

    }

    public void onNotifiButtonCl(View v){
         notification = new Notification.Builder(MainActivity.this)
                 .setContentTitle("Content title text")
                 .setContentText("context text")
                 .setSmallIcon(R.drawable.ic_action_name)
                 .setContentIntent(pi)
                 .setAutoCancel(true)
                 .build();

        notificationManager.notify(0, notification);
        finish();
    }
}
