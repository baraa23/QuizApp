package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * with this app you can test your general knowledge
     * (made as the final project for Udacity/Google Challenge Scholarship: Android Basics)
     */

    public static final int MAX_SCORE = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when submit button is clicked.
     */

    public void submitAnswers(View view) {

        int score = 0;

        RadioButton victory = (RadioButton) findViewById(R.id.q1_b);
        boolean question1b = victory.isChecked();

        RadioButton burj = (RadioButton) findViewById(R.id.q2_a);
        boolean question2a = burj.isChecked();

        CheckBox china = (CheckBox) findViewById(R.id.q3_a);
        boolean question3a = china.isChecked();

        CheckBox egypt = (CheckBox) findViewById(R.id.q3_b);
        boolean question3b = egypt.isChecked();

        CheckBox lebanon = (CheckBox) findViewById(R.id.q3_c);
        boolean question3c = lebanon.isChecked();

        CheckBox sudan = (CheckBox) findViewById(R.id.q3_d);
        boolean question3d = sudan.isChecked();

        RadioButton sweden = (RadioButton) findViewById(R.id.q4_c);
        boolean question4d = sweden.isChecked();

        EditText yourName = (EditText) findViewById(R.id.user_name);
        String editTextName = yourName.getText().toString();

        score = calculateScore(question1b, question2a, question3a, question3b, question3c, question3d, question4d);

        Context context = getApplicationContext();
        CharSequence text = getString(R.string.congrats) + editTextName + getString(R.string.scoremessagestart)
                + score + getString(R.string.scoremesaaageend) + MAX_SCORE;

        Context contextwrong = getApplication();
        CharSequence textwrong = getString(R.string.messagewrongstart) + editTextName + getString(R.string.messagewrongstart2)
                + score + getString(R.string.messagewrongmid) + MAX_SCORE + getString(R.string.messagewrongend);


        if (score >= 4) {
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(contextwrong, textwrong, Toast.LENGTH_LONG).show();
        }

    }

    /**
     * this method to calculate the score and return it
     *
     * @param ques1  right answer for question 1 radiobutton
     * @param ques2  right answer for question 2 radiobutton
     * @param ques3a wrong answer for question 3 checkbox
     * @param ques3b right answer for question 3 checkbox
     * @param ques3c wrong answer for question 3 checkbox
     * @param ques3d right answer for question 3 checkbox
     * @param ques4d right answer for question 4 radiobutton
     * @return return the score
     */

    private int calculateScore(boolean ques1, boolean ques2, boolean ques3a, boolean ques3b, boolean ques3c, boolean ques3d, boolean ques4d) {
        int result = 0;

        if (ques1) {
            result++;
        }
        if (ques2) {
            result++;
        }
        if (ques3b && ques3d && !ques3a && !ques3c) {
            result++;
        }

        if (ques4d) {
            result++;
        }

        return result;

    }

    /**
     * this method to reset the app and clear all checkboxes, radio groups, and editText.
     *
     * @param view
     */

    public void resetQuiz(View view) {

        //clear edit text
        EditText username = (EditText) findViewById(R.id.user_name);
        username.getText().clear();

        //clear radio groups
        RadioGroup group1 = findViewById(R.id.radio_1);
        group1.clearCheck();

        RadioGroup group2 = findViewById(R.id.radio_2);
        group2.clearCheck();

        RadioGroup group3 = findViewById(R.id.radio_3);
        group3.clearCheck();

        //clear check boxes
        CheckBox checkbox1 = findViewById(R.id.q3_a);
        checkbox1.setChecked(false);

        CheckBox checkbox2 = findViewById(R.id.q3_b);
        checkbox2.setChecked(false);

        CheckBox checkbox3 = findViewById(R.id.q3_c);
        checkbox3.setChecked(false);

        CheckBox checkbox4 = findViewById(R.id.q3_d);
        checkbox4.setChecked(false);

    }


}
