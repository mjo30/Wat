package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

// this is a class that user will see when app is started
public class WelcomeScreen extends AppCompatActivity {

    @Override
    // sets appropriate layout for page
    // enables user to see login page after clicking any part of the screen
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_welcome_screen2);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeScreen.this, LoginActivityPage.class));
            }
        });
    }
}
