package com.demo.libraries;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    FragmentTransaction fragmentTransaction;
    NewFragment newFragment;
    TextView textView;
    Button buttonClick;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick = (Button) findViewById(R.id.buttonClick);
        textView = (TextView) findViewById(R.id.textViewActivity);
        newFragment = new NewFragment();
        onButtonClick();
    }

    private void onButtonClick() {
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainActivity, newFragment).commit();
                buttonClick.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.demo.libraries.R.menu.main, menu);
        return true;
    }


}

