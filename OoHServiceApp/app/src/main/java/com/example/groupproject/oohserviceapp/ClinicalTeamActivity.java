package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class ClinicalTeamActivity extends AppCompatActivity {

    private ArrayList<ArrayList<String>> myDetailLists = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> customDetailLists = new ArrayList<ArrayList<String>>();
    private ArrayList<String> tempfirstnameList = new ArrayList<String>();
    private ArrayList<String> tempsurnameList = new ArrayList<String>();
    private ArrayList<String> tempteamList = new ArrayList<String>();
    private ArrayList<String> tempChiNumberList = new ArrayList<String>();
    private ArrayList<String> tempAddressList = new ArrayList<String>();
    private ArrayList<String> tempDobList = new ArrayList<String>();
    private ArrayList<String> tempHeightList = new ArrayList<String>();
    private ArrayList<String> tempWeightList = new ArrayList<String>();

    Button callHubManager, pickTeam;
    ImageButton ctHomeButton;
    ListView patientListView;
    EditText editTeamSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicalteam);

        // Get resource id
        editTeamSelect = (EditText) findViewById(R.id.edit_team_select);
        callHubManager = (Button) findViewById(R.id.button5);
        pickTeam = (Button) findViewById(R.id.pickTeam);
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

        // Get data from database method call
        getDatabase();

        // Create new instance of DatabaseWorker class
        final DatabaseWorker db = new DatabaseWorker(this);

        // Select team button
        pickTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teamSelection = editTeamSelect.getText().toString();
                if (teamSelection.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a team number 1-10", Toast.LENGTH_LONG).show();
                } else {
                    // Once team is input and recieved, the database is queried again with a WHERE clause finding "team_number" equals input
                    myDetailLists.clear();
                    myDetailLists = db.fetchSpecificDetails(teamSelection);

                    tempfirstnameList.clear();
                    tempsurnameList.clear();
                    tempteamList.clear();
                    tempfirstnameList = myDetailLists.get(0);
                    tempsurnameList = myDetailLists.get(1);
                    tempteamList = myDetailLists.get(2);

                    customDetailLists.clear();

                    // Creating a custom arrayList of arrayLists to pass to the custom created ListView adapter
                    for (int j = 0; j<tempfirstnameList.size(); j++) {

                        String f = tempfirstnameList.get(j);
                        String s = tempsurnameList.get(j);
                        String t = tempteamList.get(j);
                        ArrayList temp = new ArrayList<String>();
                        temp.add(f);
                        temp.add(s);
                        temp.add(t);

                        customDetailLists.add(temp);
                    }

                    tempChiNumberList.clear();
                    tempAddressList.clear();
                    tempDobList.clear();
                    tempHeightList.clear();
                    tempWeightList.clear();
                    tempChiNumberList = myDetailLists.get(3);
                    tempAddressList = myDetailLists.get(4);
                    tempDobList = myDetailLists.get(5);
                    tempHeightList = myDetailLists.get(6);
                    tempWeightList = myDetailLists.get(7);

                    // Create The Adapter with passing ArrayList<ArrayList<String>> as 3rd parameter
                    PatientListAdapter arrayAdapterTwo =
                            new PatientListAdapter(getApplicationContext(),R.layout.patient_list_items, customDetailLists);
                    // Set The Adapter
                    patientListView = (ListView) findViewById(R.id.clinical_names_list);
                    patientListView.setAdapter(arrayAdapterTwo);

                    // Creating a listener for when an item from the generated list is selected
                    patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(ClinicalTeamActivity.this, ViewPatientActivity.class);

                            // Storing details of the currently selected position in the list
                            intent.putExtra("firstName", tempfirstnameList.get(position));
                            intent.putExtra("surname", tempsurnameList.get(position));
                            intent.putExtra("team", tempteamList.get(position));
                            intent.putExtra("chiNumber", tempChiNumberList.get(position));
                            intent.putExtra("address", tempAddressList.get(position));
                            intent.putExtra("dob", tempDobList.get(position));
                            intent.putExtra("height" ,tempHeightList.get(position));
                            intent.putExtra("weight", tempWeightList.get(position));
                            intent.putExtra("position", position);

                            // Start ViewPatientActivity
                            startActivity(intent);
                        }
                    });

                    Toast.makeText(getApplicationContext(), "Team selection updated!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void getDatabase() {

        final DatabaseWorker dbwork = new DatabaseWorker(this);

        // Fetching arrayLists from the Arraylist that was constructed with Database data
        myDetailLists = dbwork.fetchDetails();

        // Assigning each arrayList within the arrayList<arrayList<String>> to a specfic variable to manipulate
        tempfirstnameList = myDetailLists.get(0);
        tempsurnameList = myDetailLists.get(1);
        tempteamList = myDetailLists.get(2);

        // Creating a custom arrayList of arrayLists to pass to the custom created ListView adapter
        for (int j = 0; j<tempfirstnameList.size(); j++) {

            String f = tempfirstnameList.get(j);
            String s = tempsurnameList.get(j);
            String t = tempteamList.get(j);
            ArrayList temp = new ArrayList<String>();
            temp.add(f);
            temp.add(s);
            temp.add(t);

            customDetailLists.add(temp);
        }

        // Continue assigning of arrayLists from arrayList<arrayList<String>>
        tempChiNumberList = myDetailLists.get(3);
        tempAddressList = myDetailLists.get(4);
        tempDobList = myDetailLists.get(5);
        tempHeightList = myDetailLists.get(6);
        tempWeightList = myDetailLists.get(7);


        // Create The Adapter with passing ArrayList<ArrayList<String>> as 3rd parameter
        PatientListAdapter arrayAdapter =
                new PatientListAdapter(this,R.layout.patient_list_items, customDetailLists);
        // Set The Adapter
        patientListView = (ListView) findViewById(R.id.clinical_names_list);
        patientListView.setAdapter(arrayAdapter);

        // Creating a listener for when an item from the generated list is selected
        patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClinicalTeamActivity.this, ViewPatientActivity.class);

                // Storing details of the currently selected position in the list
                intent.putExtra("firstName", tempfirstnameList.get(position));
                intent.putExtra("surname", tempsurnameList.get(position));
                intent.putExtra("team", tempteamList.get(position));
                intent.putExtra("chiNumber", tempChiNumberList.get(position));
                intent.putExtra("address", tempAddressList.get(position));
                intent.putExtra("dob", tempDobList.get(position));
                intent.putExtra("height" ,tempHeightList.get(position));
                intent.putExtra("weight", tempWeightList.get(position));
                intent.putExtra("position", position);

                // Start ViewPatientActivity
                startActivity(intent);
            }
        });
    }


}
