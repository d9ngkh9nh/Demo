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

public class OddResult extends AppCompatActivity {
    private static final String TAG = "OddResult";
    //Declare variables and elements from xml file.
    Button btnBackToWelcome, btnBack;
    TextView txtvOddResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd_result);
        getSupportActionBar().setTitle("Odd Result"); //Set title for the activity.

        //Map the variables with xml file.
        txtvOddResult = (TextView) findViewById(R.id.textViewOddResult);
        btnBackToWelcome = (Button) findViewById(R.id.buttonBackToWelcome);
        btnBack = (Button) findViewById(R.id.buttonBack);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        //Get the passed value from Odd activity.
        Bundle bd = getIntent().getExtras();
        if (bd != null) {
            String content = bd.getString("oddResult");
            txtvOddResult.setText(content);
        }

        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(OddResult.this, Welcome.class);
                startActivity(welcome);
            }
        });

        //Press the "Done" button to go back to Odd activity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent odd = new Intent(OddResult.this, Odd.class);
                startActivity(odd);
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
