package net.learn2develop.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by twer on 12/15/14.
 */
public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment2,container,false);
    }

    @Override
    public void onStart(){
        super.onStart();
        Button button = (Button) getActivity().findViewById(R.id.btnGetText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textView = (TextView) getActivity().findViewById(R.id.lb1Fragment1);
                Toast.makeText(getActivity(),textView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
