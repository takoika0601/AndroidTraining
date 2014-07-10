package jp.mixi.practice.notification.beg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by takoika0601 on 2014/07/04.
 */
public class SubActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText("SubActivity launched");
    }
}
