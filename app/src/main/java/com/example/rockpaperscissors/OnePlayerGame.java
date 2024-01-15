package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OnePlayerGame extends AppCompatActivity {

    //Instance variable to randomize AI decision
    Random random = new Random();
    Handler handler = new Handler();
    ProgressBar progressBar;
    TextView playerScore;
    TextView aiScore;
    TextView resultText;

    int pScore = 0;
    int aScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_game);

        // Initialize TextViews after setting the content view
        playerScore = findViewById(R.id.playerOneScore);
        aiScore = findViewById(R.id.aiScore);
        resultText = findViewById(R.id.resultText);
        progressBar = findViewById(R.id.progressBar3);

    }

    public void Game(String playerSelection) {

        String AI_Selection = "";
        int randomNumber = random.nextInt(3);
        String[] selectionArray = {"Rock", "Paper", "Scissors"};
        AI_Selection = selectionArray[randomNumber];

        try {
            switch (playerSelection) {
                case "Rock":

                    if (AI_Selection.equals("Scissors") && playerSelection.equals("Rock")) {
                        // Player wins
                        pScore = pScore + 1;
                        //Toast.makeText(this, "Player Wins!", Toast.LENGTH_LONG).show();
                        resultText.setText("Player Wins");
                    }

                    if (AI_Selection.equals("Paper") && playerSelection.equals("Rock")) {
                        // AI wins
                        aScore = aScore + 1;
                        //Toast.makeText(this, "AI Wins!", Toast.LENGTH_LONG).show();
                        resultText.setText("AI Wins");
                    }
                    break;

                case "Paper":
                    if (AI_Selection.equals("Scissors") && playerSelection.equals("Paper")) {
                        // AI wins
                        aScore = aScore + 1;
                        resultText.setText("AI Wins");

                    }
                    if (AI_Selection.equals("Rock") && playerSelection.equals("Paper")) {
                        // Player wins
                        pScore = pScore + 1;
                        resultText.setText("Player Wins");
                    }
                    break;

                case "Scissors":
                    if (AI_Selection.equals("Paper") && playerSelection.equals("Scissors")) {
                        // Player wins
                        pScore = pScore + 1;
                        resultText.setText("Player Wins");
                    }

                    if (AI_Selection.equals("Rock") && playerSelection.equals("Scissors")) {
                        // AI wins
                        aScore = aScore + 1;
                        resultText.setText("AI Wins");
                    }
                    break;

                default:
                    if(playerSelection.equals(AI_Selection)){
                        resultText.setText("Game DRAW!");
                    }
                    break;

            }

            }catch(Exception e){
                e.printStackTrace();
            }

        if (pScore > 0){
            playerScore.setText(String.valueOf(pScore));
        }
        if (aScore > 0){
            aiScore.setText(String.valueOf(aScore));
        }

    }

    public void rockButtonClick(View view){

        String selectRock = "Rock";
        progressBar.setVisibility(View.VISIBLE);
        resultText.setText("Calculating Results...");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                Game(selectRock);
            }
        }, 3000);

    }

    public void paperButtonClick(View view){

        String selectPaper = "Paper";
        progressBar.setVisibility(View.VISIBLE);
        resultText.setText("Calculating Results...");


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                Game(selectPaper);
            }
        }, 6000);
    }

    public void scissorsButtonClick(View view){

        String selectScissors = "Scissors";
        progressBar.setVisibility(View.VISIBLE);
        resultText.setText("Calculating Results...");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                Game(selectScissors);
            }
        }, 6000);
    }
}