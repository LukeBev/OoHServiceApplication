package com.example.groupproject.oohserviceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created on 14/11/2017.
 */

public class HubManagerActivity extends AppCompatActivity {

    Button hubManBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubmanager);

        hubManBut = (Button) findViewById(R.id.button);
    }
}
