package com.example.groupproject.oohserviceapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ResourceBundle;

/**
 * Created on 14/11/2017.
 * edited 21/11/2017.
 */

public class ClinicalTeamActivity extends AppCompatActivity {

    Button callHubManager;
    ImageButton ctHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicalteam);

        callHubManager = (Button) findViewById(R.id.button5);
        ctHomeButton = (ImageButton) findViewById(R.id.imageButtonct);
        // Create click listener for add new patient button
        callHubManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start call
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:08000000000" ));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
                // Home button, linking to mainActivity
                ctHomeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Go to Home Screen
                        Intent HomeScreen = new Intent(v.getContext(), MainActivity.class);
                        startActivity(HomeScreen);
                    }
                });
            }
        }
