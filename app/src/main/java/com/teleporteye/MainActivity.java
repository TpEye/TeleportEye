package com.teleporteye;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;


public class MainActivity extends Activity {

    // Reference for facebook button.
    ImageButton btnFacebook;

    // Reference for google button.
    ImageButton btnGoogle;

    // Reference for twitter button.
    ImageButton btnTwitter;

    SocialAuthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hide title bar.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set main layot to this activity.
        setContentView(R.layout.activity_main);

        adapter = new SocialAuthAdapter(new ResponseListener());
        adapter.addProvider(SocialAuthAdapter.Provider.FACEBOOK, R.drawable.facebook);

        // Get facebook button instance.
        btnFacebook = (ImageButton) findViewById(R.id.facebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.authorize(MainActivity.this, SocialAuthAdapter.Provider.FACEBOOK);
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

    private final class ResponseListener implements DialogListener    {
        public void onComplete(Bundle values) {
            Profile profileMap =  adapter.getUserProfile();

            Toast.makeText(MainActivity.this, profileMap.getFirstName() + " " + profileMap.getLastName(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SocialAuthError socialAuthError) {
            try{
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
            catch (Exception ex) {
                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBack() {
            Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
        }
    }
}


