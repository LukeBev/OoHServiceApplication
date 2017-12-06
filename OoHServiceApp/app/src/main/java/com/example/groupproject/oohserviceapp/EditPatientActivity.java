package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * Created on 14/11/2017.
 */

public class EditPatientActivity extends AppCompatActivity {

    Button saveNewPatientButton;
    ImageButton epHomeButton;
    EditText editTeamText, editCHIText, editFirstNameText, editSurnameText, editAddressText, editDobText, editHeightText, editWeightText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editablepatient);

        editTeamText = (EditText) findViewById(R.id.editTextTeam);
        editCHIText = (EditText) findViewById(R.id.editTextCHINumber);
        editFirstNameText = (EditText) findViewById(R.id.editTextFName);
        editSurnameText = (EditText) findViewById(R.id.editTextSurname);
        editAddressText = (EditText) findViewById(R.id.editTextAddress);
        editDobText = (EditText) findViewById(R.id.editTextDob);
        editHeightText = (EditText) findViewById(R.id.editTextHeight);
        editWeightText = (EditText) findViewById(R.id.editTextWeight);


        final DatabaseWorker db = new DatabaseWorker(this);

        String team, chi, firstName, surname, address, dob, height, weight;

        saveNewPatientButton = (Button) findViewById(R.id.buttonsavePatient);

        // Listener for when submit button clicked for inserting new patient to the database
        saveNewPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String team = editTeamText.getText().toString();
                String chi = editCHIText.getText().toString();
                String firstName = editFirstNameText.getText().toString();
                String surname = editSurnameText.getText().toString();
                String address = editAddressText.getText().toString();
                String dob = editDobText.getText().toString();
                String height = editHeightText.getText().toString();
                String weight = editWeightText.getText().toString();

                // Checking for any empty fields before inserting to database
                if (team.isEmpty() || chi.isEmpty() || firstName.isEmpty() || surname.isEmpty() || address.isEmpty() || dob.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields before adding patient!", Toast.LENGTH_LONG).show();
                } else {
                    // Method call to the database worker class, to allow for insertion to the database.
                    db.insertDetails(team, chi, firstName, surname, address, dob, height, weight);
                    Toast.makeText(getApplicationContext(), "Patient has been added to the system!", Toast.LENGTH_LONG).show();

                    // Clear the editText fields
                    editTeamText.setText("");
                    editCHIText.setText("");
                    editFirstNameText.setText("");
                    editSurnameText.setText("");
                    editAddressText.setText("");
                    editDobText.setText("");
                    editHeightText.setText("");
                    editWeightText.setText("");
                }
            }
        });



        // Create click listener for home button
        epHomeButton = (ImageButton) findViewById(R.id.imageButtonep);
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
