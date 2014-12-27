package net.learn2develop.Notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationsActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.cancel(getIntent().getExtras().getInt("notificationID"));
    }

    public void onClick(View view){
        displayNotification();
    }

    private void displayNotification() {
        Intent intent = new Intent(this,NotificationsView.class);
        intent.putExtra("notificationID",1);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.ic_launcher,"Reminder:Metting starts in 5 miniutes",System.currentTimeMillis());
        CharSequence from = "System alarm";
        CharSequence message = "Meeting with customer at 3pm";

        notification.setLatestEventInfo(this,from,message,pendingIntent);

        notification.vibrate = new long[]{100,250,100,500};
        notificationManager.notify(1,notification);

    }
}
