package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hubManagerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hubManagerButton = (Button) findViewById(R.id.button2);

        // Create click listener for trackSelectionButton
        hubManagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Track List Activity
                Intent hubManScreen = new Intent(v.getContext(), HubManagerActivity.class);
                startActivity(hubManScreen);
            }
        });
    }
}
