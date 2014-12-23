package net.learn2develop.DynicFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

public class DynicFragmentActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        WindowManager wm = getWindowManager();
        Display display = wm.getDefaultDisplay();
        if (display.getWidth() > display.getHeight()) {
            Fragment1 fragment1 = new Fragment1();
            fragment1.getId();
            fragmentTransaction.replace(R.id.content, fragment1);
        } else {
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.replace(R.id.content, fragment2);
        }
        fragmentTransaction.commit();
    }
}
