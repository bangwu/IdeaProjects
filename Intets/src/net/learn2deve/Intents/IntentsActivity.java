package net.learn2deve.Intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class IntentsActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClickWebBrowser(View view){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void onClickMakeCall(View view){
        Intent intent= new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+8618062547292"));
        startActivity(intent);
    }

    public void onClickShowMap(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:37.8888,-122.4816"));
        startActivity(intent);
    }
}
