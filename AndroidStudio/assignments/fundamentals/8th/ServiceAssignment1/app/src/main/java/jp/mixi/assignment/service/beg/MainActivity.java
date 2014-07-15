package jp.mixi.assignment.service.beg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<String>{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button            button   = (Button)   findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText1);
                String str = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("preference", str);

                startService(intent);
            }
        });

        LoaderManager manager = getSupportLoaderManager();
        Bundle argsForLoader = new Bundle();
        argsForLoader.putString("hoge", "hoge");

        manager.initLoader(0, argsForLoader, MainActivity.this);
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case 0:
                return new MyAsyncTaskLoader(this);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String result) {
        TextView textView = (TextView) findViewById(R.id.textView1);
        textView.setText(result);
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
