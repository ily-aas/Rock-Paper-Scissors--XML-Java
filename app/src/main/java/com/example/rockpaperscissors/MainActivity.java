package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnePlayer(View view){

        String one = "one";

        // Create an Intent to navigate to the NewActivity
        Intent intent = new Intent(this, BlurLoadingScreen.class);

        //Variable is sent to loading class to determine which game type to begin
        intent.putExtra("one", one);

        // Start the new activity
        startActivity(intent);
    }

    public void TwoPlayer(View view){

        String two = "two";

        // Create an Intent to navigate to the NewActivity
        Intent intent = new Intent(this, BlurLoadingScreen.class);

        //Variable is sent to loading class to determine which game type to begin
        intent.putExtra("two", two);

        // Start the new activity
        //startActivity(intent);

    }

}