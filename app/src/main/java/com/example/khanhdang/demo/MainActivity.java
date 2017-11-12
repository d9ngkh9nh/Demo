/*
  RMIT University Vietnam
  Course: COSC2657 Android Development
  Semester: 2017C
  Assignment: 1
  Author: Dang Dinh Khanh
  ID: s3618748
  Created date: 01/11/2017
  Acknowledgement: (developer.android.com, orangefreesounds.com)
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String SHARE_PREFERENCES = "name";
    String USER_NAME = "userName";

    private static final String TAG = "MainActivity";
    //Declare variables and elements from xml file.
    EditText edtName, edtSurName;
    Button btnGo;
    CheckBox cbMale, cbFeMale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("WEIRDO"); //Set title for the activity.
        //Map the variables with xml file
        edtName = (EditText) findViewById(R.id.editTextName);
        edtSurName = (EditText)findViewById(R.id.editTextSurName);
        cbMale = (CheckBox) findViewById(R.id.checkBoxMale);
        cbFeMale = (CheckBox) findViewById(R.id.checkBoxFeMale);
        btnGo = (Button) findViewById(R.id.buttonGo);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        //Add background sound
        final MediaPlayer backgroundSound = MediaPlayer.create(this, R.raw.background);
        backgroundSound.start();
        backgroundSound.setLooping(true);

        //The user tick the boxes and appear the greeting toast based on it.
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(MainActivity.this, Welcome.class);
                welcome.putExtra("surName", edtSurName.getText().toString()); //pass the user's name to WelcomeActivity
                if (cbMale.isChecked()) {
                    Toast greeting = Toast.makeText(MainActivity.this, "You're so Handsome", Toast.LENGTH_SHORT);
                    greeting.show();
                } else if (cbFeMale.isChecked()) {
                    Toast greeting = Toast.makeText(MainActivity.this, "You're so Pretty", Toast.LENGTH_SHORT);
                    greeting.show();
                } else {
                    Toast greeting = Toast.makeText(MainActivity.this, "You're so Weird (:", Toast.LENGTH_SHORT);
                    greeting.show();
                }
                getUserName();
                startActivity(welcome);
            }
        });
    }
    //Save the user's name to SharedPreferences
    public void getUserName() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, edtName.getText().toString());
        editor.apply();
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
