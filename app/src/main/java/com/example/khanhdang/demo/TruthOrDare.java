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

import java.util.ArrayList;
import java.util.Random;

public class TruthOrDare extends AppCompatActivity {

    private static final String TAG = "TruthOrDare";
    //Declare variables and elements from xml file.
    Button btnBackToWelcome, btnTruth, btnDare;
    TextView txtvOr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truthordare);

        getSupportActionBar().setTitle("Truth or Dare"); //Set title for the activity.
        //Map the variables with xml file.
        btnBackToWelcome = (Button)findViewById(R.id.buttonBackToWelcome);
        btnTruth = (Button)findViewById(R.id.buttonTruth);
        btnDare = (Button)findViewById(R.id.buttonDare);
        txtvOr = (TextView)findViewById(R.id.textViewIntro);
        Log.d(TAG, "now running: onCreate");

        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(TruthOrDare.this, Welcome.class); //Go to WelcomeActivity from TruthOrDareActivity
                startActivity(welcome);
            }
        });

        //Press the "Truth" button to go to TruthActivity.
        btnTruth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> truthContentArray = new ArrayList<>(); //Array to store all the Truth contents
                truthContentArray.add("\"What are you most self-conscious about?\"");
                truthContentArray.add("\"What do most of your friends think about you that is totally untrue?\"");
                truthContentArray.add("\"Tell me about your first kiss.\"");
                truthContentArray.add("\"Who is the sexiest person here?\"");
                truthContentArray.add("\"What is the most embarrassing nickname you have ever had?\"");
                truthContentArray.add("\"What is the biggest lie you have ever told?\"");
                truthContentArray.add("\"What is your biggest regret?\"");
                truthContentArray.add("\"Tell me something you don’t want me to know.\"");
                truthContentArray.add("\"Who is your crush?\"");
                truthContentArray.add("\"What is the most childish thing you still do?\"");
                truthContentArray.add("\"What is the one thing you dislike about yourself?\"");
                truthContentArray.add("\"What is your weirdest habit?\"");
                truthContentArray.add("\"What is one embarrassing fact I should know about you?\"");
                truthContentArray.add("\"What is the craziest thing that you have ever done while drunk?\"");
                truthContentArray.add("\"How many boyfriends (or girlfriends) have you had?\"");
                truthContentArray.add("\"If you were a billionaire, what would you spend your time doing?\"");

                //Get the Truth content randomly based on the id of the contents
                Random rTruth = new Random();
                int selectedTruthContent = rTruth.nextInt(truthContentArray.size());

                Intent truth = new Intent(TruthOrDare.this, Truth.class); //Go to DareActivity from TruthOrDareActivity
                truth.putExtra("truthContent", truthContentArray.get(selectedTruthContent).toString()); //Pass the Truth content to TruthActivity
                startActivity(truth);
            }
        });

        //Press the "Dare" button to go to DareActivity.
        btnDare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> dareContentArray = new ArrayList<>(); //Array to store all the Dare contents
                dareContentArray.add("\"Text your crush and tell them how much you like them\"");
                dareContentArray.add("\"Send an email to one of your teachers, telling them about how your day is going\"");
                dareContentArray.add("\"Ask your crush out on a date\"");
                dareContentArray.add("\"Take a shot\"");
                dareContentArray.add("\"Slap the person to your left\"");
                dareContentArray.add("\"Say the alphabet backwards in 15 seconds\"");
                dareContentArray.add("\"Spin around 20 times, when you get done try to walk in a straight line\"");
                dareContentArray.add("\"Do the silliest dance that you can think of\"");
                dareContentArray.add("\"Give someone your phone and let them send one text to anyone in your contacts.\"");
                dareContentArray.add("\"Let the person to your left draw on your face with a pen.\"");
                dareContentArray.add("\"Kiss the person to your left.\"");
                dareContentArray.add("\"Do push ups until you can’t do any more, wait 5 seconds, and then do one more.\"");
                dareContentArray.add("\"Attempt to do a magic trick.\"");
                dareContentArray.add("\"Get slapped on the face by the person of your choosing.\"");
                dareContentArray.add("\"Dance to a song of the group’s choosing.\"");
                dareContentArray.add("\"Be someone’s pet for the next 5 minutes.\"");
                dareContentArray.add("\"Drink 1L of water\"");

                //Get the Dare content randomly based on the id of the contents
                Random rDare = new Random();
                int selectedDareContent = rDare.nextInt(dareContentArray.size());

                Intent dare = new Intent(TruthOrDare.this, Dare.class); //Go to DareActivity from TruthOrDareActivity
                dare.putExtra("dareContent", dareContentArray.get(selectedDareContent).toString()); //Pass the Truth content to TruthActivity
                startActivity(dare);
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

