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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighestScore extends AppCompatActivity {
    private static final String TAG = "HighestScore";
    TextView txtvHighestScore;
    Button btnBackToWelcome, btnBackToMath;
//    private final String SHARE_PREFERENCES = "score";
//    private final String HIGH_SCORE = "high_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        //Declare variables and elements from xml file.
        txtvHighestScore = (TextView) findViewById(R.id.textViewHighestScore);
        btnBackToWelcome = (Button) findViewById(R.id.buttonBackToWelcome);
        btnBackToMath = (Button) findViewById(R.id.buttonBackToMath);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String highestScore = bd.getString("highestScore");
            txtvHighestScore.setText("The Highest Score is: " + highestScore);
        }

        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(HighestScore.this, Welcome.class);
                startActivity(welcome);
            }
        });

        //Press the "Done" button to go back to MathActivity.
        btnBackToMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(HighestScore.this, Math.class);
                startActivity(welcome);
            }
        });
    }
    //Use logCat to review the Activity Lifecycle.
    @Override
    protected void onResume () {
        super.onResume();

        Log.d(TAG, "now running: onResume");
    }

    @Override
    protected void onStart () {
        super.onStart();

        Log.d(TAG, "now running: onStart");
    }

    @Override
    protected void onRestart () {
        super.onRestart();

        Log.d(TAG, "now running: onRestart");
    }

    @Override
    protected void onPause () {
        super.onPause();

        Log.d(TAG, "now running: onPause");
    }

    @Override
    protected void onStop () {
        super.onStop();

        Log.d(TAG, "now running: onStop");
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();

        Log.d(TAG, "now running: onDestroy");

    }
}
