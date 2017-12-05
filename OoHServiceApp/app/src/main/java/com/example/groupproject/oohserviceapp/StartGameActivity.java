package com.example.groupproject.oohserviceapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartGameActivity extends AppCompatActivity {

    private Button playGameButton;
    private EditText playerAName;
    private TextView playerBName;

    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        playGameButton = (Button) findViewById(R.id.buttonPlayGame);
        playerAName = (EditText) findViewById(R.id.editTextPlayerAName);
        playerBName = (TextView) findViewById(R.id.textViewPlayerBName);

        final String player2 = "Zeeshan";
        playerBName.setText(player2);


        playGameButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final String editTextVal = playerAName.getText().toString();

                Intent PlayGame = new Intent(v.getContext(), GameActivity.class);
                PlayGame.putExtra("playerAname", editTextVal);
                PlayGame.putExtra("playerBname", player2);
                PlayGame.putExtra("playerAscore", "0");
                PlayGame.putExtra("playerBscore", "0");
                PlayGame.putExtra("playerAscoretotal", "0");
                //startMusic();
                startActivity(PlayGame);
            }
        });


        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);


        playMusic = (Button) findViewById(R.id.buttonMusic);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()){
                    //stop and give option to start again
                    pauseMusic();
                }else {
                    startMusic();
                }
            }
        });


    }

    public void pauseMusic(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            playMusic.setText("Play");
        }
    }

    public void startMusic(){
        if (mediaPlayer != null){
            mediaPlayer.start();
            playMusic.setText("Pause");
        }
    }

}

