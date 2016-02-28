package com.teleporteye;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    // Reference for facebook button.
    ImageButton btnFacebook;

    // Reference for google button.
    ImageButton btnGoogle;

    // Reference for twitter button.
    ImageButton btnTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set main layot to this activity.
        setContentView(R.layout.activity_main);

        // Get facebook button instance.
        btnFacebook = (ImageButton) findViewById(R.id.facebookButton);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Facebook", Toast.LENGTH_SHORT).show();
            }
        });

        // Get google button instance.
        btnGoogle = (ImageButton) findViewById(R.id.googleButton);
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Google", Toast.LENGTH_SHORT).show();
            }
        });

        // Get google button instance.
        btnTwitter = (ImageButton) findViewById(R.id.twitterButton);
        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Titter", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
