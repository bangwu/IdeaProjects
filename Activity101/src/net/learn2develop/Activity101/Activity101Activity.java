package net.learn2develop.Activity101;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

public class Activity101Activity extends Activity {
    private String tag = "Lifecycle";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        Log.d(tag, "In the onCreate() event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In the on Restart() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }

    public void onClick(View view) {
        showDialog(0);
    }
}
