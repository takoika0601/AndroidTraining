
package jp.mixi.assignment.notification.beg;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO ここで通知を表示する
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                // タイトル
                .setContentTitle("NotificationAssignment")
                // 詳細メッセージ
                .setContentText("Notification Message")
                // アイコン
                .setSmallIcon(R.drawable.ic_launcher)
                // Ticker
                .setTicker("Message received")
                .setOnlyAlertOnce(true)
                .build();
        notification.defaults |= Notification.DEFAULT_VIBRATE;

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }
}