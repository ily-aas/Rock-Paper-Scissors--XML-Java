package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class BlurLoadingScreen extends AppCompatActivity {

    String receivedVariable1;
    String receivedVariable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_loading_screen);

        Intent intent = getIntent();
        if (intent != null) {
            receivedVariable1 = intent.getStringExtra("one");
            receivedVariable2 = intent.getStringExtra("two");
        }

        // Check for null before calling equals
        if (receivedVariable1 != null && receivedVariable1.equals("one")) {
            startOnePlayerGame();
        }

        // Check for null before calling equals
        if (receivedVariable2 != null && receivedVariable2.equals("two")) {
            startTwoPlayerGame();
        }
    }

    public void startOnePlayerGame(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BlurLoadingScreen.this, OnePlayerGame.class));
                finish(); //Finish the current activity once the new activity has been loaded
            }
        }, 5000);

    }

    public void startTwoPlayerGame(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(BlurLoadingScreen.this, TwoPlayerGame.class));
                finish(); //Finish the current activity once the new activity has been loaded
            }
        }, 5000);
    }
}