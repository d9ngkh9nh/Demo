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
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Odd extends AppCompatActivity {
    private static final String TAG = "Odd";
    //Declare variables and elements from xml file.
    CheckBox cbMale, cbFemale, cbOld, cbYoung, cbDog, cbCat, cbActive, cbIntrovert;
    Button btnBackToWelcome, btnGo;
    TextView txtvIntroOdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd);
        getSupportActionBar().setTitle("Odd"); //Set title for the activity.

        //Declare variables and elements from xml file.
        txtvIntroOdd = (TextView)findViewById(R.id.textViewIntroOdd);
        cbMale = (CheckBox) findViewById(R.id.checkBoxMale);
        cbFemale = (CheckBox) findViewById(R.id.checkBoxFemale);
        cbOld = (CheckBox) findViewById(R.id.checkBoxOld);
        cbYoung = (CheckBox) findViewById(R.id.checkBoxYoung);
        cbDog = (CheckBox) findViewById(R.id.checkBoxDog);
        cbCat = (CheckBox) findViewById(R.id.checkBoxCat);
        cbActive = (CheckBox) findViewById(R.id.checkBoxActive);
        cbIntrovert = (CheckBox) findViewById(R.id.checkBoxIntrovert);
        btnGo = (Button) findViewById(R.id.buttonGo);
        btnBackToWelcome = (Button) findViewById(R.id.buttonBackToWelcome);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.

        //Press the "Done" button to go to OddResultActivity.
        btnGo.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
             ArrayList<String> oddArray = new ArrayList<>(); //Array to store all the Truth contents
             oddArray.add("\"The best way to predict the future is to create it.\"");
             oddArray.add("\"Your future is too dark to be seen.\"");
             oddArray.add("\"Your birthday is... the day you were born.\"");
             oddArray.add("\"I predict that you will get HDs this sem!!!\"");
             oddArray.add("\"You are the most beautiful person here!\"");
             oddArray.add("\"You are the smartest here!\"");
             oddArray.add("\"Remember to buy lucky tickets tomorrow and you will see...\"");
             oddArray.add("\"You will be the next president!!!\"");
             oddArray.add("\"Say \"it\" to your crush and you will get the best result.\"");
             oddArray.add("\"Leave the homework there, he will not check it tomorrow.\"");
             oddArray.add("\"Remember to bring your umbrella tomorrow.\"");
             oddArray.add("\"Call your Mom, she misses you so much.\"");
             oddArray.add("\"Save the money, you will need it soon.\"");
             oddArray.add("\"Prepare for the exam, it will be super hard\"");
             oddArray.add("\"Think carefully before making \"that\" decision!\"");
             oddArray.add("\"You will be a billionaire soon!!!\"");

             //Get the Odd content randomly based on the id of the contents
             Random rOdd = new Random();
             int selectedOdd = rOdd.nextInt(oddArray.size());

             Intent oddResult = new Intent(Odd.this, OddResult.class); //Go to OddResultActivity from OddActivity
             if (cbMale.isChecked() && cbFemale.isChecked()) { //If both Male and Female boxes are ticked, the show out this content
                 oddResult.putExtra("oddResult", "\"Hmm... What should I say?\"");
                 startActivity(oddResult);
             } else if (cbDog.isChecked() && cbCat.isChecked()) { //If both Dog and Cat boxes are ticked, the show out this content
                 oddResult.putExtra("oddResult", "\"Aww... You are such a benevolent person...\"");
                 startActivity(oddResult);
             } else if (cbYoung.isChecked() && cbOld.isChecked()) { //If both Young and Old boxes are ticked, the show out this content
                 oddResult.putExtra("oddResult", "\"You are both 30+ and 30- Y.O., so what are you???\"");
                 startActivity(oddResult);
             } else if (cbActive.isChecked() && cbIntrovert.isChecked()) { //If both Active and Introvert boxes are ticked, the show out this content
                 oddResult.putExtra("oddResult", "\"You are too weird to be predicted!!!\"");
                 startActivity(oddResult);
             } else if (!cbActive.isChecked() && !cbIntrovert.isChecked() && !cbMale.isChecked() && !cbFemale.isChecked() &&
                     !cbDog.isChecked() && !cbCat.isChecked() && !cbYoung.isChecked() && !cbOld.isChecked()) { //If none box is ticked, the show out this content
                 oddResult.putExtra("oddResult", "\"You have to give me your information to get the prediction!\"");
                 startActivity(oddResult);
             } else { //If not, then show randomly
                 oddResult.putExtra("oddResult", oddArray.get(selectedOdd).toString());
                 startActivity(oddResult);
             }
         }
     });
        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(Odd.this, Welcome.class);
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
