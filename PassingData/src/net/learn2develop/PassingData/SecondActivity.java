package net.learn2develop.PassingData;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.URL;

/**
 * Created by twer on 12/15/14.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);

        Toast.makeText(this,getIntent().getStringExtra("str1"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,getIntent().getStringExtra("age1"),Toast.LENGTH_SHORT).show();

        Bundle bundle=getIntent().getExtras();

        Toast.makeText(this,bundle.getString("str2"),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,String.valueOf(bundle.getInt("age2")),Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        Intent intent=new Intent();
        intent.putExtra("age3","45");
        intent.setData(Uri.parse("Something passed back to main activity"));
        setResult(RESULT_OK,intent);
        finish();
    }
}
