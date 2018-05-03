package com.example.alessandra.averagefurlanquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alessandra.averagefurlanquiz.R;

public class MainActivity extends AppCompatActivity {

    int scoreQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //** Increase the score of the quiz by 0
    public void addZeroToScore(View v) {
        scoreQuiz = scoreQuiz + 0;
        displayForQuiz(scoreQuiz);
    }

    //** Increase the score of the quiz by 4
    public void addFourToScore(View v) {
        scoreQuiz = scoreQuiz + 4;
        displayForQuiz(scoreQuiz);
    }

    public void findOut (View view) {

        //** Get first Answer
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String userString = nameField.getText().toString();
        String correctAnswer = "Friuli";
        boolean isNameFieldTrue = correctAnswer.equals(userString);

        //**Figure out if the Furlan Checkbox is checked
        CheckBox furlanCheckBox = (CheckBox) findViewById(R.id.fur_checkbox);
        boolean isFurlan = furlanCheckBox.isChecked();

        CheckBox italianCheckBox = (CheckBox) findViewById(R.id.ita_checkbox);
        boolean isItalian = italianCheckBox.isChecked();

        CheckBox germanCheckBox = (CheckBox) findViewById(R.id.ger_checkbox);
        boolean isGerman = germanCheckBox.isChecked();

        CheckBox slovenianCheckBox = (CheckBox) findViewById(R.id.slo_checkbox);
        boolean isSlovenian = slovenianCheckBox.isChecked();


        //** Calculate the score
        int scoreQuiz = calculateScore(isNameFieldTrue, isFurlan, isItalian, isGerman, isSlovenian);

        //** Display the final Score on a Toast Message
        String message = createFinalScore(scoreQuiz, isNameFieldTrue, isFurlan);
    }

    //** Calculate Score
    private int calculateScore(boolean isNameFieldTrue, boolean isFurlan, boolean isItalian, boolean isGerman, boolean isSlovenian) {
        int firstScore = 0;

        if (isNameFieldTrue) {
            firstScore = firstScore + 1;
        }

        if ((isFurlan) && (isItalian) && !(isGerman) && !(isSlovenian)){
            firstScore = firstScore +8;
        }

        return scoreQuiz = scoreQuiz + firstScore;
    }

    //** Displays the Final Score
    private void displayForQuiz(int scoreQuiz) {
        TextView scoreTextView = (TextView) findViewById(R.id.finalScore);
        scoreTextView.setText("" + scoreQuiz);
    }
    private String createFinalScore (int scoreQuiz, boolean addNameFieldTrue, boolean addFurlan) {
        String message = "";

        if (scoreQuiz <= 5) {
            message = "You know nothing about Friuli :sad:";
        } else if (scoreQuiz <= 8) {
            message = "You like Friuli, but not a lover";
        } else if (scoreQuiz <= 15) {
            message = "You are in the right path to love Friuli";
        } else if (scoreQuiz > 16) {
            message = "You are a super Friuli Lover! Congratz!";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        return message;
    }
}