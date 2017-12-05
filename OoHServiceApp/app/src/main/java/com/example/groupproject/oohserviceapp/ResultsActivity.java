package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private TextView myTextViewplayerA;
    private TextView myTextViewplayerB;
    private TextView myTextViewwinner;
    private TextView myTextViewmsg;
    private ImageView myImageViewplayerA;
    private ImageView myImageViewplayerB;
    private Button goBackButton;
    private TextView myPlayerAScore;
    private TextView myPlayerBScore;
    private TextView myTextViewnameA;
    private TextView myTextViewnameB;
    private TextView myTempResult;
    private TextView myTempResultB;
    private TextView myTextViewnameAscore;
    private TextView myTextViewnameBscore;
    private MediaPlayer mediaPlayer;

    ImageButton rgHomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        rgHomeButton = (ImageButton) findViewById(R.id.imageButtonrg);

        myTextViewplayerA = (TextView) findViewById(R.id.textViewplayerA);
        myTextViewplayerB = (TextView) findViewById(R.id.textViewplayerB);
        myTextViewwinner = (TextView) findViewById(R.id.textViewwinner);
        myTextViewmsg = (TextView) findViewById(R.id.textViewmsg);
        myPlayerAScore = (TextView) findViewById(R.id.textViewPlayerAScore);
        myPlayerBScore = (TextView) findViewById(R.id.textViewPlayerBScore);
        myImageViewplayerA = (ImageView) findViewById(R.id.imageViewImageA);
        myImageViewplayerB = (ImageView) findViewById(R.id.imageViewImageB);
        goBackButton = (Button) findViewById(R.id.button2);
        myTextViewnameA = (TextView) findViewById(R.id.textViewnameA);
        myTextViewnameB = (TextView) findViewById(R.id.textViewnameB);
        myTextViewnameAscore = (TextView) findViewById(R.id.textViewnameAscore);
        myTextViewnameBscore = (TextView) findViewById(R.id.textViewnameBscore);
        myTempResult = (TextView) findViewById(R.id.textViewResultTemp);
        myTempResultB = (TextView) findViewById(R.id.textViewResultTempB);

        mediaPlayer = new MediaPlayer();

        // Home button, linking to mainActivity
        rgHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Home Screen
                Intent HomeScreen = new Intent(v.getContext(), MainActivity.class);
                startActivity(HomeScreen);
            }
        });


        Bundle extras = getIntent().getExtras();

        String playerA = extras.getString("playerA"); //get player A weapon
        String playerB = extras.getString("playerB");
        final String playerAname = extras.getString("playerAname");
        final String playerBname = extras.getString("playerBname");
        String playerAimage = extras.getString("playerAimage");

        //get current scores and display them
        String playerAcurrentscoretemp = extras.getString("playerAscore");
        myTempResult.setText(playerAcurrentscoretemp);

        String playerBcurrentscoretemp = extras.getString("playerBscore");
        myTempResultB.setText(playerBcurrentscoretemp);


        //convert current scores to integers so we can add to them
        String playerAcurrentscore = myTempResult.getText().toString();
        int playerAscore = Integer.parseInt(playerAcurrentscore);

        String playerBcurrentscore = myTempResultB.getText().toString();
        int playerBscore = Integer.parseInt(playerBcurrentscore);

        //display player names, weapons chosen and scores
        myTextViewplayerA.setText(playerA);
        myTextViewplayerB.setText(playerB);
        myTextViewnameA.setText(playerAname);
        myTextViewnameB.setText(playerBname);
        myTextViewnameAscore.setText(playerAname);
        myTextViewnameBscore.setText(playerBname);

        //if statement to determine winner if player chose Rock
        if (playerA .equals("Rock")) {
            if (playerAimage .equals ("1")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock1));
            }
            else if (playerAimage .equals ("2")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock));
            }  else {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock3));
            }

            if (playerB .equals("Rock")) {
                myTextViewmsg.setText("No winners this time");
                myTextViewwinner.setText("It's a Draw");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.draw1);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock));
            }
            if (playerB .equals("Paper")) {
                myTextViewmsg.setText("Paper wraps Rock");
                myTextViewwinner.setText("You Lose!");
                playerBscore++;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose1);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paperplane));
            }
            if (playerB .equals("Scissors")) {
                myTextViewmsg.setText("Rock blunts Scissors");
                myTextViewwinner.setText("You Win!");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.applause);
                playerAscore++;
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.edward));
            }
        }
        //if statement to determine winner if player chose Scissors
        if (playerA .equals("Scissors")) {
            if (playerAimage .equals ("1")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.edward));
            }
            else if (playerAimage .equals ("2")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors));
            }  else {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors2));
            }
            if (playerB .equals("Rock")) {
                myTextViewmsg.setText("Rock blunts Scissors");
                myTextViewwinner.setText("You Lose!");
                playerBscore++;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose2);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock));
            }
            if (playerB .equals("Paper")) {
                myTextViewmsg.setText("Scissors cut Paper");
                myTextViewwinner.setText("You Win!");
                playerAscore++;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.win1);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paperplane));
            }
            if (playerB .equals("Scissors")) {
                myTextViewmsg.setText("No winners this time");
                myTextViewwinner.setText("It's a draw");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.draw2);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.edward));
            }
        }
        //if statement to determine winner if player chose Paper
        if (playerA .equals("Paper")) {
            if (playerAimage .equals ("1")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paperplane));
            }
            else if (playerAimage .equals ("2")) {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.toiletpaper));
            }  else {
                myImageViewplayerA.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.newpaper));
            }
            if (playerB .equals("Rock")) {
                myTextViewmsg.setText("Paper wraps Rock");
                myTextViewwinner.setText("You Win!");
                playerAscore++;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.win3);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock));
            }
            if (playerB .equals("Paper")) {
                myTextViewmsg.setText("No winners this time");
                myTextViewwinner.setText("It's a draw");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.draw1);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paperplane));
            }
            if (playerB .equals("Scissors")) {
                myTextViewmsg.setText("Scissors cut Paper");
                myTextViewwinner.setText("You Lose!");
                playerBscore++;
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.lose3);
                myImageViewplayerB.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.edward));
            }
        }

        mediaPlayer.start(); //play sound effect

        String TotalPlayerA = String.valueOf(playerAscore);
        myPlayerAScore.setText(TotalPlayerA);

        String TotalPlayerB = String.valueOf(playerBscore);
        myPlayerBScore.setText(TotalPlayerB);



        goBackButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent NewGame = new Intent(ResultsActivity.this, GameActivity.class);
                String mynumber = myPlayerAScore.getText().toString();
                NewGame.putExtra("playerAscore", mynumber);
                String mynumberB = myPlayerBScore.getText().toString();
                NewGame.putExtra("playerBscore", mynumberB);
                NewGame.putExtra("playerAname", playerAname);
                NewGame.putExtra("playerBname", playerBname);
                mediaPlayer.pause();
                startActivity(NewGame);
                finish();


            }
        });



    }}
