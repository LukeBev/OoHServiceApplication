package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created on 14/11/2017.
 */

public class HubManagerActivity extends AppCompatActivity {

    Button addNewPatientButton;
    ImageButton hubHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubmanager);

        addNewPatientButton = (Button) findViewById(R.id.button6);
        hubHomeButton = (ImageButton) findViewById(R.id.imageButtonhub);

        // Create click listener for add new patient button
        addNewPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Edit Patient Screen
                Intent EditPatient = new Intent(v.getContext(), EditPatientActivity.class);
                startActivity(EditPatient);
            }
        });

        // Create click listener for home button.
        hubHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Home Screen
                Intent HomeScreen = new Intent(v.getContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });
    }
}

