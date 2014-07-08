
package jp.mixi.practice.listview.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> objects = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            objects.add("hoge" + i);
        }

        CustomListItemAdapter customListItemAdapter = new CustomListItemAdapter(this, objects);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(customListItemAdapter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView) findViewById(R.id.listView)).smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
