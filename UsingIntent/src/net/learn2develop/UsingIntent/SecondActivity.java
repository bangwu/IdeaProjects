package net.learn2develop.UsingIntent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by twer on 12/14/14.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
    }

    public void second_btn1_onClick(View view) {
        Intent intent = new Intent();
        EditText text_userName = (EditText) findViewById(R.id.text_userName);
        intent.setData(Uri.parse(text_userName.getText().toString()));
        setResult(RESULT_OK, intent);
        finish();
    }
}
