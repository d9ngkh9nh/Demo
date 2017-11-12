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
import android.support.v4.math.MathUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.FileVisitOption;
import java.util.ArrayList;
import java.util.Random;
/////1111
    public class Math extends AppCompatActivity {
    private static final String TAG = "Math";
    private final String SHARE_PREFERENCES = "score";
    private final String HIGH_SCORE = "high_score";

    //Declare variables and elements from xml file.
    Button btnBackToWelcome, btnResult, btnNextQuiz, btnHighestScore;
    EditText edtNumber1;
    TextView txtvNumber1, txtvTotalResult;
    double number1, number2;
    int selectedOperation;
    int correctAnswer = 0, totalAnswer = 0;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        getSupportActionBar().setTitle("Math"); //Set title for the activity.

        //Declare variables and elements from xml file.
        btnBackToWelcome = (Button)findViewById(R.id.buttonBackToWelcome);
        btnResult = (Button)findViewById(R.id.buttonResult);
        btnNextQuiz = (Button)findViewById(R.id.buttonNextQuiz);
        btnHighestScore = (Button)findViewById(R.id.buttonHighestScore);
        edtNumber1 = (EditText)findViewById(R.id.editTextNumber1);
        txtvNumber1 = (TextView)findViewById(R.id.textViewNumber1);
        txtvTotalResult = (TextView)findViewById(R.id.textViewTotalResult);
        Log.d(TAG, "now running: onCreate"); //Use logCat to review the Activity Lifecycle.
        GenerateRandomNumber();

        //Press the "Main menu" button to go back to Welcome activity.
        btnBackToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent welcome = new Intent(Math.this, Welcome.class);
                startActivity(welcome);
            }
        });

        final MediaPlayer correctSound = MediaPlayer.create(this, R.raw.correct);
        final MediaPlayer wrongSound = MediaPlayer.create(this, R.raw.wrong);



        //Press the "Done" button to check the result.
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double enteredResult = Double.parseDouble(edtNumber1.getText().toString());
                if (selectedOperation == 0) { //If the operation is addition, check the result.
                    if (enteredResult == (number1 + number2)) { //
                        Toast result = Toast.makeText(Math.this, "You're so Good (:", Toast.LENGTH_SHORT);
                        result.show();
                        correctAnswer++;
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        correctSound.start();
                        GenerateRandomNumber();
                    } else {
                        Toast result = Toast.makeText(Math.this, "You're so Wrong (:", Toast.LENGTH_SHORT);
                        result.show();
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        wrongSound.start();
                    }
                } else if (selectedOperation == 1) { //If the operation is subtraction, check the result.
                    if (enteredResult == (number1 - number2)) {
                        Toast result = Toast.makeText(Math.this, "You're so Good (:", Toast.LENGTH_SHORT);
                        result.show();
                        correctAnswer++;
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        correctSound.start();
                        GenerateRandomNumber();
                    } else {
                        Toast result = Toast.makeText(Math.this, "You're so Wrong (:", Toast.LENGTH_SHORT);
                        result.show();
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        wrongSound.start();
                    }
                } else if (selectedOperation == 2) { //If the operation is multiply, check the result.
                    if (enteredResult == (number1 * number2)) {
                        Toast result = Toast.makeText(Math.this, "You're so Good (:", Toast.LENGTH_SHORT);
                        result.show();
                        correctAnswer++;
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        correctSound.start();
                        GenerateRandomNumber();
                    } else {
                        Toast result = Toast.makeText(Math.this, "You're so Wrong (:", Toast.LENGTH_SHORT);
                        result.show();
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        wrongSound.start();
                    }
                } else { //If the operation is division, check the result.
                    if ((enteredResult >=((number1 / number2)-1)) && (enteredResult <=((number1 / number2)))) {
                        Toast result = Toast.makeText(Math.this, "You're so Good (:", Toast.LENGTH_SHORT);
                        result.show();
                        correctAnswer++;
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        correctSound.start();
                        GenerateRandomNumber();
                    } else {
                        Toast result = Toast.makeText(Math.this, "You're so Wrong (:", Toast.LENGTH_SHORT);
                        result.show();
                        totalAnswer++;
                        txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
                        wrongSound.start();
                    }
                }
            }
        });
        getHighScore();
        //Get a new question by pressing "Next Quiz" button.
        btnNextQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenerateRandomNumber();
            }
        });

        //Review the highest score by pressing "Highest Score" button.
        btnHighestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getHighScore();
                readHighScore();
            }
        });

    }

    //Generate 2 numbers from 1-100.
    public void GenerateRandomNumber () {
        Random randomNumber1 = new Random();
        number1 = randomNumber1.nextInt((100-1+1)+1);
        number2 = randomNumber1.nextInt((100-1+1)+1);

        ArrayList<String> operationArray = new ArrayList<>(); //An array of operations.
        operationArray.add("+");
        operationArray.add("-");
        operationArray.add("x");
        operationArray.add("/");
        Random rOperation = new Random();
        selectedOperation = rOperation.nextInt(operationArray.size()); //Select a random operation.

        if(selectedOperation == 3) { //If the operation is division, then change the question.
            txtvNumber1.setText("The Integral part of the result of (" + String.valueOf(number1) + operationArray.get(selectedOperation).toString() + String.valueOf(number2) + ") is...");
        } else
        txtvNumber1.setText("The result of (" + String.valueOf(number1) + operationArray.get(selectedOperation).toString() + String.valueOf(number2) + ") is...");
    }

    //Save the highest score to SharedPreferences
    public void getHighScore() {
       // if(correctAnswer < score) {correctAnswer = score;}
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(HIGH_SCORE, correctAnswer);
        editor.apply();
    }
    //Read the highest score to SharedPreferences
    public void readHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFERENCES, Context.MODE_PRIVATE);
        score = sharedPreferences.getInt(HIGH_SCORE, 22);
//        Toast scoreToast = Toast.makeText(Math.this,String.valueOf(score) , Toast.LENGTH_SHORT);
//        scoreToast.show();

        Intent highestScore = new Intent(Math.this, HighestScore.class);
        highestScore.putExtra("highestScore", String.valueOf(score)); //pass the user's name to WelcomeActivity
        startActivity(highestScore);
        Log.d(TAG, "Score: "+ score);
    }

    @Override
    protected void onResume() {
        super.onResume();

     //txtvTotalResult.setText(String.valueOf(correctAnswer) + "/" + String.valueOf(totalAnswer) + " Corrects");
        Log.d(TAG, "now running: onResume");
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
