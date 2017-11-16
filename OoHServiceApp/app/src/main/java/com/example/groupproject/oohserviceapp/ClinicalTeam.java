package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created on 14/11/2017.
 */

public class ClinicalTeam extends AppCompatActivity {

    Button addNewPatientButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicalteam);

        addNewPatientButton = (Button) findViewById(R.id.button5);

        // Create click listener for add new patient button
        addNewPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Track List Activity
                Intent EditPatient = new Intent(v.getContext(), EditPatient.class);
                startActivity(EditPatient);
            }
        });
    }
}
