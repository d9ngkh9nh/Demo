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
import android.widget.Toast;

public class Truth extends AppCompatActivity {

    private static final String TAG = "Truth";
    //Declare variables and elements from xml file.
    Button btnBackToWelcome, btnDoneTruth;
    TextView txtvTruthContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth);

        getSupportActionBar().setTitle("Truth"); //Set title for the activity.
        //Map the variables with xml file.
        btnBackToWelcome = (Button)findViewById(R.id.buttonBackToWelcome);
        btnDoneTruth = (Button)findViewById(R.id.buttonDoneTruth);
        txtvTruthContent = (TextView)findViewById(R.id.textViewTruthContent);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        //When the first player done his/her turn (press the Done button), back to TruthOrDare activity and toast a message.
        btnDoneTruth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent truthOrDare = new Intent(Truth.this, TruthOrDare.class);
                Toast nextPlayer = Toast.makeText(Truth.this, "Next Player", Toast.LENGTH_SHORT);
                nextPlayer.show();
                startActivity(truthOrDare);
            }
        });

        //Get the passed value from TruthOrDare activity.
        Bundle bd = getIntent().getExtras();
        if (bd!=null) {
            String content = bd.getString("truthContent");
            txtvTruthContent.setText(content);
        }

        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(Truth.this, Welcome.class);
                startActivity(welcome);
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
