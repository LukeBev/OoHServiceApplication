package com.example.groupproject.oohserviceapp;

/**
 * Created on 01/12/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseWorker extends SQLiteAssetHelper {

    // Initialising database variables
    private static final String DATABASE_NAME = "testerDBv5.db";
    private static final int DATABASE_VERSION = 1;

    // Initialising the list to hold other list
    private ArrayList<ArrayList<String>> listOflists= new ArrayList<ArrayList<String>>();

    // Initialising lists to hold a collection of field data from database query
    private ArrayList<String> firstNameList = new ArrayList<String>();
    private ArrayList<String> surnameList = new ArrayList<String>();
    private ArrayList<String> teamList = new ArrayList<String>();
    private ArrayList<String> chiNumberList = new ArrayList<String>();
    private ArrayList<String> addressList = new ArrayList<String>();
    private ArrayList<String> dobList = new ArrayList<String>();
    private ArrayList<String> heightList = new ArrayList<String>();
    private ArrayList<String> weightList = new ArrayList<String>();


    public DatabaseWorker(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public ArrayList<ArrayList<String>> fetchDetails() {
        SQLiteDatabase database = getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "first_name", "surname", "address", "team_number", "chi_number", "date_of_birth", "height", "weight"};
        String sqlTable = "people";

        // Build query, selects all rows
        queryBuilder.setTables(sqlTable);
        Cursor cur = queryBuilder.query(database, sqlSelect, null, null,
                null, null, null);

        // Initialise temporary variables to hold each field in a row of data
        String firstname, surname, team, chiNumber, address, dob, height, weight = "init";

        // Move to first row
        cur.moveToFirst();

        // Loop around all rows, packaging each field from a row into a collection of the same type of fields
        for (int i = 0; i<cur.getCount(); i++) {

            firstname = cur.getString(cur.getColumnIndex("first_name"));
            System.out.println("FIRSTNAME: " + firstname);
            firstNameList.add(firstname);
            System.out.println("FIRSTNAME LIST: " + firstNameList);

            surname = cur.getString(cur.getColumnIndex("surname"));
            System.out.println("SURNAME: " + surname);
            surnameList.add(surname);
            System.out.println("SURNAME LIST: " + surnameList);

            team = cur.getString(cur.getColumnIndex("team_number"));
            System.out.println("TEAM: " + team);
            teamList.add(team);
            System.out.println("TEAM LIST: " + teamList);

            chiNumber = cur.getString(cur.getColumnIndex("chi_number"));
            System.out.println("CHI: " + chiNumber);
            chiNumberList.add(chiNumber);
            System.out.println("CHI LIST: " + chiNumberList);

            address = cur.getString(cur.getColumnIndex("address"));
            System.out.println("ADDRESS: " + address);
            addressList.add(address);
            System.out.println("ADDRESS LIST: " + addressList);

            dob = cur.getString(cur.getColumnIndex("date_of_birth"));
            System.out.println("DOB: " + dob);
            dobList.add(dob);
            System.out.println("DOB LIST: " + dobList);

            height = cur.getString(cur.getColumnIndex("height"));
            System.out.println("HEIGHT: " + height);
            heightList.add(height);
            System.out.println("HEIGHT LIST: " + heightList);

            weight = cur.getString(cur.getColumnIndex("weight"));
            System.out.println("WEIGHT: " + weight);
            weightList.add(weight);
            System.out.println("WEIGHT LIST: " + weightList);

            cur.moveToNext();
        }
        listOflists.add(firstNameList);
        listOflists.add(surnameList);
        listOflists.add(teamList);
        listOflists.add(chiNumberList);
        listOflists.add(addressList);
        listOflists.add(dobList);
        listOflists.add(heightList);
        listOflists.add(weightList);

        cur.close();
        database.close();
        return listOflists;
    }

    // this method will need params to take in the strings from the .getText() of the TextViews
    public void insertDetails(String team, String chi, String firstname, String surname, String address, String dob, String height, String weight) {

        SQLiteDatabase database = getWritableDatabase();

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id"};
        String sqlTable = "people";

        // Build query, selects all rows
        queryBuilder.setTables(sqlTable);
        Cursor cur = queryBuilder.query(database, sqlSelect, null, null,
                null, null, null);

        int idNum = cur.getCount()+1;
        String id = String.valueOf(idNum);
        System.out.println("NEW ROW ID: " + id);

        ContentValues content = new ContentValues();
        content.put("id", id);
        content.put("chi_number", chi);
        content.put("first_name", firstname);
        content.put("surname", surname);
        content.put("address", address);
        content.put("date_of_birth", dob);
        content.put("height", height);
        content.put("weight", weight);
        content.put("team_number", team);

        database.insert("people",null ,content);

    }

    public ArrayList<ArrayList<String>> fetchSpecificDetails(String teamNumber) {
        SQLiteDatabase database = getReadableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "first_name", "surname", "address", "team_number", "chi_number", "date_of_birth", "height", "weight"};
        String sqlTable = "people";
        String where = "team_number = "+teamNumber;

        // Build query, selects all rows
        queryBuilder.setTables(sqlTable);
        Cursor cur = queryBuilder.query(database, sqlSelect, where, null,
                null, null, null);

        // Initialise temporary variables to hold each field in a row of data
        String firstname, surname, team, chiNumber, address, dob, height, weight = "init";

        // Move to first row
        cur.moveToFirst();

        // Loop around all rows, packaging each field from a row into a collection of the same type of fields
        for (int i = 0; i<cur.getCount(); i++) {

            firstname = cur.getString(cur.getColumnIndex("first_name"));
            System.out.println("FIRSTNAME: " + firstname);
            firstNameList.add(firstname);
            System.out.println("FIRSTNAME LIST: " + firstNameList);

            surname = cur.getString(cur.getColumnIndex("surname"));
            System.out.println("SURNAME: " + surname);
            surnameList.add(surname);
            System.out.println("SURNAME LIST: " + surnameList);

            team = cur.getString(cur.getColumnIndex("team_number"));
            System.out.println("TEAM: " + team);
            teamList.add(team);
            System.out.println("TEAM LIST: " + teamList);

            chiNumber = cur.getString(cur.getColumnIndex("chi_number"));
            System.out.println("CHI: " + chiNumber);
            chiNumberList.add(chiNumber);
            System.out.println("CHI LIST: " + chiNumberList);

            address = cur.getString(cur.getColumnIndex("address"));
            System.out.println("ADDRESS: " + address);
            addressList.add(address);
            System.out.println("ADDRESS LIST: " + addressList);

            dob = cur.getString(cur.getColumnIndex("date_of_birth"));
            System.out.println("DOB: " + dob);
            dobList.add(dob);
            System.out.println("DOB LIST: " + dobList);

            height = cur.getString(cur.getColumnIndex("height"));
            System.out.println("HEIGHT: " + height);
            heightList.add(height);
            System.out.println("HEIGHT LIST: " + heightList);

            weight = cur.getString(cur.getColumnIndex("weight"));
            System.out.println("WEIGHT: " + weight);
            weightList.add(weight);
            System.out.println("WEIGHT LIST: " + weightList);

            cur.moveToNext();
        }
        listOflists.add(firstNameList);
        listOflists.add(surnameList);
        listOflists.add(teamList);
        listOflists.add(chiNumberList);
        listOflists.add(addressList);
        listOflists.add(dobList);
        listOflists.add(heightList);
        listOflists.add(weightList);

        cur.close();
        database.close();
        return listOflists;
    }
}
