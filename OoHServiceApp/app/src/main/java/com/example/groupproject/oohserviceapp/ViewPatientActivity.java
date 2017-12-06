package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created on 01/12/2017.
 */

public class ViewPatientActivity extends AppCompatActivity {

    TextView firstName, surname, address, chiNumber, dob, height, weight, team;
    ImageButton homeButton;

    Button viewMapfromPa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewablepatient);

        viewMapfromPa = (Button) findViewById(R.id.mapbutton);



        viewMapfromPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start clinical team Activity
                Intent clinicalteamScreen = new Intent(v.getContext(), MapsActivity.class);
                startActivity(clinicalteamScreen);
            }
        });











        // Getting the resource id for each textView
        firstName = (TextView) findViewById(R.id.textView15);
        surname = (TextView) findViewById(R.id.textView16);
//        team = (TextView) findViewById(R.id.textAddress);
        chiNumber = (TextView) findViewById(R.id.textView14);
        address = (TextView) findViewById(R.id.textView17);
        dob = (TextView) findViewById(R.id.textView18);
        height = (TextView) findViewById(R.id.textView23);
        weight = (TextView) findViewById(R.id.textView19);


        // Unloading the bundle to get string values, to put data into appropriate textView
        Bundle extras = getIntent().getExtras();

        String firstnameString = extras.getString("firstName");
        firstName.setText(firstnameString);

        String surnameString = extras.getString("surname");
        surname.setText(surnameString);

//        String teamString = extras.getString("team");
//        team.setText(teamString);

        String chiNumberString = extras.getString("chiNumber");
        chiNumber.setText(chiNumberString);

        String addressString = extras.getString("address");
        address.setText(addressString);

        String dobString = extras.getString("dob");
        dob.setText(dobString);

        String heightString = extras.getString("height");
        height.setText(heightString);

        String weightString = extras.getString("weight");
        weight.setText(weightString);


        // Button to allow the user to navigate to the main activity of the application
        homeButton = (ImageButton) findViewById(R.id.imageButtonpd1);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hi");
                Intent HomeScreen = new Intent(v.getContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });
    }
}
