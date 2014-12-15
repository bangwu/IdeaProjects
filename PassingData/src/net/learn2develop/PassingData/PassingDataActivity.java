package net.learn2develop.PassingData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PassingDataActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View view) {
        Intent intent = new Intent("net.learn2develop.PassingData.SecondActivity");

        intent.putExtra("str1", "This is a string");
        intent.putExtra("age1", "25");

        Bundle bundle = new Bundle();

        bundle.putString("str2", "This is a another string");
        bundle.putInt("age2", 35);

        intent.putExtras(bundle);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("age3"), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
