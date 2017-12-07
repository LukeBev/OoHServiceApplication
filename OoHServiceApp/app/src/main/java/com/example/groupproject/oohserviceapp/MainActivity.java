package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button hubManagerButton, clinicalTeamButton, startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get resources
        hubManagerButton = (Button) findViewById(R.id.buttonhubmanager);
        clinicalTeamButton = (Button) findViewById(R.id.buttononcall);
        startGameButton = (Button) findViewById(R.id.buttontimewaster);


        // Create click listener for hub manager button
        hubManagerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start hub manager Activity
                Intent hubManScreen = new Intent(v.getContext(), HubManagerActivity.class);
                startActivity(hubManScreen);
            }
        });


        // Create click listener for timewaster button
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Time Waster Activity
                Intent gameScreen = new Intent(v.getContext(), StartGameActivity.class);
                startActivity(gameScreen);
            }
        });

        // Create click listener for clinical team button
        clinicalTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Clinical team Activity
                Intent clinicalTeamScreen = new Intent(v.getContext(), ClinicalTeamActivity.class);
                startActivity(clinicalTeamScreen);
            }
        });
    }
}
