/*
  RMIT University Vietnam
  Course: COSC2657 Android Development
  Semester: 2017C
  Assignment: 1
  Author: Dang Dinh Khanh
  ID: s3618748
  Created date: 01/11/2017
  Acknowledgement: (developer.android.com)
*/

package com.example.khanhdang.demo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    String SHARE_PREFERENCES = "name";
    String USER_NAME = "userName";
    String userName;
    String surName = "!";

    private static final String TAG = "Welcome";
    //Declare variables and elements from xml file.
    TextView txtvName, txtvInTro;
    Button btnBack, btnGoToTruthOrDare, btnGoToOdd, btnGoToMath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().setTitle("Welcome"); //Set title for the activity.

        //Map the variables with xml file.
        txtvName = (TextView) findViewById(R.id.textViewName);
        txtvInTro = (TextView) findViewById(R.id.textViewIntro);
        btnBack = (Button)findViewById(R.id.buttonBack);
        btnGoToTruthOrDare = (Button)findViewById(R.id.buttonGoToTruthOrDare);
        btnGoToMath = (Button)findViewById(R.id.buttonGoToMath);
        btnGoToOdd = (Button)findViewById(R.id.buttonGoToOdd);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        // Get the passed value from MainActivity and display it.
        Bundle bd = getIntent().getExtras();
        if (bd!=null) {
            surName = bd.getString("surName");
        }

        //Get user's name from the SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        userName = sharedPreferences.getString(USER_NAME, "#Kai");
        txtvName.setText("Welcome " +userName + " " + surName);

        //Press the "Back" button to go back to MainActivity.
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(Welcome.this, MainActivity.class);
                startActivity(main);
            }
        });

        //Press the "Truth or Dare" button to go to TruthOrDare activity.
        btnGoToTruthOrDare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playTruthOrDare = new Intent(Welcome.this, TruthOrDare.class);
                startActivity(playTruthOrDare);
            }
        });

        //Press the "Odd" button to go to Odd activity.
        btnGoToOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playOdd = new Intent(Welcome.this, Odd.class);
                startActivity(playOdd);
            }
        });

        //Press the "Math" button to go to Math activity.
        btnGoToMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playMath = new Intent(Welcome.this, Math.class);
                startActivity(playMath);
            }
        });
    }

    //Use logCat to review the Activity Lifecycle.
    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "now running: onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "now running: onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "now running: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "now running: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "now running: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "now running: onDestroy");

    }
}
