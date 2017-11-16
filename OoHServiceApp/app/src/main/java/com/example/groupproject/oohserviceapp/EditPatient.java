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

public class EditPatient extends AppCompatActivity {

    Button saveNewPatientButton;
    ImageButton epHomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editablepatient);

        saveNewPatientButton = (Button) findViewById(R.id.buttonsavePatient);
        epHomeButton = (ImageButton) findViewById(R.id.imageButtonep);

        // Create click listener for home button
        epHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Home Screen
                Intent HomeScreen = new Intent(v.getContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });
    }
}
