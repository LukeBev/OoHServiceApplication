package com.example.groupproject.oohserviceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created on 01/12/2017.
 */

public class PatientListAdapter extends ArrayAdapter<ArrayList<String>> {

    // Initialising list of patientDetails objects
    ArrayList<ArrayList<String>> pD;
    ArrayList<String> firstNameList, surnameNameList, teamList, patientDetails;

    public PatientListAdapter(Context context, int resource, ArrayList<ArrayList<String>> objects) {
        super(context, resource, objects);
        pD = objects;
    }

    /**
     * Creating a custom adapter to give the ability to display
     * first name and surnname and team number.
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.patient_list_items, parent, false);
        }

        patientDetails = pD.get(position);

        String firstName = patientDetails.get(0);
        String surname = patientDetails.get(1);
        String team = patientDetails.get(2);


        // Getting id for names and team number
        TextView textViewName = (TextView) convertView.findViewById(R.id.nameText);
        TextView textViewTeam = (TextView) convertView.findViewById(R.id.teamText);

        // Setting the text for firstname, surname and team number on the custom ListView
        textViewName.setText(firstName + " " + surname);
        textViewTeam.setText("Team: " + team);

        return convertView;
    }
}
