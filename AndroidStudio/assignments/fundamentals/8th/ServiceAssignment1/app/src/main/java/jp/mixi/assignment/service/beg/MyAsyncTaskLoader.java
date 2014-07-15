package jp.mixi.assignment.service.beg;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {

    public static final String TAG = MyAsyncTaskLoader.class.getSimpleName();

    private SharedPreferences preferences;
    private String mCachedData;

    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        preferences = getContext().getSharedPreferences("ServiceAssignment", Activity.MODE_PRIVATE);
        mCachedData = preferences.getString("preference", "No Save Data.");
/*
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Log.e(TAG, "interrupted!: ", e);
        }
*/
        return mCachedData;
    }

    @Override
    public void deliverResult(String data) {
        if (isReset()) {
            if (mCachedData != null)    mCachedData = null;

            return;
        }

        mCachedData = data;

        if (isStarted())    super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {


        if (mCachedData != null) {
            deliverResult(mCachedData);
            return;
        }

        if (takeContentChanged() || mCachedData == null)    forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
        super.onStopLoading();
    }

    @Override
    protected void onReset() {
        onStopLoading();
        super.onReset();
    }
}
