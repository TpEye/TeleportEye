package com.teleporteye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }
}
