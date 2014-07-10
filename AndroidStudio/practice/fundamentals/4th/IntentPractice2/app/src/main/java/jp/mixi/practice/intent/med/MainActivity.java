
package jp.mixi.practice.intent.med;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String ACTION_FIRST = "jp.mixi.practice.intent.med.android.intent.action.FIRST";
    public static final String ACTION_SECOND = "jp.mixi.practice.intent.med.android.intent.action.SECOND";
    public static final String ACTION_THIRD = "jp.mixi.practice.intent.med.android.intent.action.THIRD";

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ACTION_FIRST))     Log.v(TAG, "ACTION_FIRST received");
            if(intent.getAction().equals(ACTION_SECOND))    Log.v(TAG, "ACTION_SECOND received");
            if(intent.getAction().equals(ACTION_THIRD))     Log.v(TAG, "ACTION_THIRD received");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button1 = findViewById(R.id.CallAction1);
        View button2 = findViewById(R.id.CallAction2);
        View button3 = findViewById(R.id.CallAction3);

        // TODO それぞれ、Broadcast を受け取ったら Log.v(String, String) を利用して、ログ出力にどの Action を受信したかを表示する処理を書くこと
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_FIRST);
        filter.addAction(ACTION_SECOND);
        filter.addAction(ACTION_THIRD);
        registerReceiver(receiver, filter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_FIRST を呼び出す処理を書く
                Intent intent = new Intent();
                intent.setAction(ACTION_FIRST);
                sendBroadcast(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_SECOND を呼び出す処理を書く
                Intent intent = new Intent();
                intent.setAction(ACTION_SECOND);
                sendBroadcast(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO ここに、ACTION_THIRD を呼び出す処理を書く
                Intent intent = new Intent();
                intent.setAction(ACTION_THIRD);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);

        super.onStop();
    }
}