package net.learn2develop.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends Activity {
    CharSequence[] items={"Google","Apple","Microsoft"};
    boolean[] itemsChecked = new boolean[items.length];

    ProgressDialog progressDialog;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onClick(View v){
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_launcher)
                        .setTitle("This is a dialog with simple test")
                        .setPositiveButton("OK",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"OK is clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"Cancel is Clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(getBaseContext(),items[which]+(isChecked? "checked":"unchecked"),Toast.LENGTH_SHORT).show();
                            }
                        }).create();
            case 1:
                progressDialog=new ProgressDialog(this);
                progressDialog.setIcon(R.drawable.ic_launcher);
                progressDialog.setTitle("Downloads...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK",
                        new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getBaseContext(),"Cancel clicked",Toast.LENGTH_SHORT).show();
                            }
                        });
                return progressDialog;
        }
        return null;
    }

    public void btn2_onClick(View view){
        final ProgressDialog dialog=ProgressDialog.show(
                this,"Dialog something","Please wait...",true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    dialog.dismiss();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void btn3_onClick(View view){
        showDialog(1);
        progressDialog.setProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=15;i++){
                    try {
                        Thread.sleep(5000);
                        progressDialog.incrementProgressBy((100)/15);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                progressDialog.dismiss();
            }
        }).start();
    }
}
