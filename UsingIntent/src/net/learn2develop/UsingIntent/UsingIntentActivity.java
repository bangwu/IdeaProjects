package net.learn2develop.UsingIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UsingIntentActivity extends Activity {
    int request_code = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void btn1_onClick(View view) {
//        startActivity(new Intent("net.learn2develop.UsingIntent.SecondActivity"),request_code);
        startActivityForResult(new Intent("net.learn2develop.UsingIntent.SecondActivity"), request_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_code) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
