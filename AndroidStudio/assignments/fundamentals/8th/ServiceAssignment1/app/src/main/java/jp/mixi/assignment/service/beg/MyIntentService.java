package jp.mixi.assignment.service.beg;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName();

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MyIntentService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        preferences = getSharedPreferences("ServiceAssignment", Activity.MODE_PRIVATE);
        editor = preferences.edit();

        editor.putString("preference", intent.getExtras().getString("preference"));
        editor.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
