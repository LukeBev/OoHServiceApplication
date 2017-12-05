package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;

    private ImageView rockButton;
    private ImageButton scissorsButton;
    private ImageButton paperButton;
    private TextView textViewPlayerB;
    private TextView textViewScoreA;
    private TextView textViewScoreB;
    private TextView textViewplayerAname;
    private TextView textViewplayerAscorename;
    private TextView textViewplayerBscorename;

    final String[] playerBweapon = {"Rock","Paper","Scissors"};
    final String[] playerAweaponimage = {"1","2","3"};
    Random rand = new Random();
    int RandomNum = rand.nextInt(playerBweapon.length);
    int RandomImageNum = rand.nextInt(playerAweaponimage.length);

    private String playerB = playerBweapon[RandomNum];
    private String playerAimage = playerAweaponimage[RandomImageNum];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        //fade_in = AnimationUtils.loadAnimation(this,
        //      android.R.anim.fade_in);
        //fade_out = AnimationUtils.loadAnimation(this,
        //      android.R.anim.fade_out);
        //viewFlipper.setInAnimation(fade_in);
        //viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        //viewFlipper.setAutoStart(true);
        //viewFlipper.setFlipInterval(500);
        //viewFlipper.startFlipping();

        rockButton = (ImageView) findViewById(R.id.imageViewRock);
        scissorsButton = (ImageButton) findViewById(R.id.imageButtonScissors);
        paperButton = (ImageButton) findViewById(R.id.imageButtonPaper);
        //textViewPlayerB = (TextView) findViewById(R.id.textViewPlayerB);
        textViewScoreA = (TextView) findViewById(R.id.textViewScoreA);
        textViewScoreB = (TextView) findViewById(R.id.textViewScoreB);
        textViewplayerAname = (TextView) findViewById(R.id.textViewplayerAname);
        textViewplayerAscorename = (TextView) findViewById(R.id.textViewplayerAscorename);
        textViewplayerBscorename = (TextView) findViewById(R.id.textViewplayerBscorename);




        if (playerAimage .equals ("1")) {
            rockButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock1));
            scissorsButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.edward));
            paperButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paperplane));
        }
        else if (playerAimage .equals ("2")) {
            rockButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock));
            scissorsButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors));
            paperButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.toiletpaper));
        } else {
            rockButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.rock3));
            scissorsButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.scissors2));
            paperButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.newpaper));
        }


        Bundle extras = getIntent().getExtras();

        //display player name if exists

        final String playerAname = extras.getString("playerAname");
        final String playerBname = extras.getString("playerBname");
        final String TotalPlayerA = extras.getString("playerAscore");
        final String TotalPlayerB = extras.getString("playerBscore");

        if (extras != null) {
            String playerAname2 = extras.getString("playerAname");
            textViewplayerAname.setText(playerAname2);
            textViewplayerAscorename.setText(playerAname2);
            textViewplayerBscorename.setText(playerBname);
        }

        //if not first game display scores otherwise show 0 scores
        if (TotalPlayerA != null){
            textViewScoreA.setText(TotalPlayerA);
            textViewScoreB.setText(TotalPlayerB);
        }
        else {
            textViewScoreA.setText("0");
        }


        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create onClick listener for when users selects rock image
                Intent rockintent = new Intent(GameActivity.this, ResultsActivity.class);
                rockintent.putExtra("playerA", "Rock");
                rockintent.putExtra("playerB", playerB);
                rockintent.putExtra("playerAimage", playerAweaponimage[RandomImageNum]);
                rockintent.putExtra("playerAscore", TotalPlayerA);
                rockintent.putExtra("playerBscore", TotalPlayerB);
                rockintent.putExtra("playerAname", playerAname);
                rockintent.putExtra("playerBname", playerBname);
                startActivity(rockintent);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create onClick listener for when users selects scissors image
                Intent rockintent = new Intent(GameActivity.this, ResultsActivity.class);
                rockintent.putExtra("playerA", "Scissors");
                rockintent.putExtra("playerB", playerB);
                rockintent.putExtra("playerAimage", playerAweaponimage[RandomImageNum]);
                rockintent.putExtra("playerAscore", TotalPlayerA);
                rockintent.putExtra("playerBscore", TotalPlayerB);
                rockintent.putExtra("playerAname", playerAname);
                rockintent.putExtra("playerBname", playerBname);
                startActivity(rockintent);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create onClick listener for when users selects paper image
                Intent rockintent = new Intent(GameActivity.this, ResultsActivity.class);
                rockintent.putExtra("playerA", "Paper");
                rockintent.putExtra("playerB", playerB);
                rockintent.putExtra("playerAimage", playerAweaponimage[RandomImageNum]);
                rockintent.putExtra("playerAscore", TotalPlayerA);
                rockintent.putExtra("playerBscore", TotalPlayerB);
                rockintent.putExtra("playerAname", playerAname);
                rockintent.putExtra("playerBname", playerBname);
                startActivity(rockintent);
            }
        });

        //Display oponents weapon for testing
        //textViewPlayerB.setText(playerBweapon[RandomNum]+" "+playerAweaponimage[RandomImageNum]);

    }
}

