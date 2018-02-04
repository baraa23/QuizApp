package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when submit button is clicked.
     */

    public void sumbitAnswers (View view) {

        int score = 0;

        RadioButton victory = (RadioButton) findViewById(R.id.q1_b);
        boolean question1b = victory.isChecked();

        RadioButton burj = (RadioButton) findViewById(R.id.q2_a);
        boolean question2a = burj.isChecked();

        CheckBox egypt = (CheckBox) findViewById(R.id.q3_b);
        boolean question3b = egypt.isChecked();

        CheckBox sudan = (CheckBox) findViewById(R.id.q3_d);
        boolean question3d = sudan.isChecked();

        RadioButton sweden = (RadioButton) findViewById(R.id.q4_c);
        boolean question4d = sweden.isChecked();

        EditText yourName = (EditText) findViewById(R.id.user_name);
        String editTextName = yourName.getText().toString();

        score = calculateScore(question1b,question2a,question3b,question3d,question4d);

        if (score >= 4) {
            Toast.makeText(this, "your result is: " + score + "out of 4", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "sorry, try again, you have score" + score + "out of 4", Toast.LENGTH_SHORT).show();
        }



    }

    private int calculateScore (boolean ques1, boolean ques2, boolean ques3b, boolean ques3d, boolean ques4d) {
        int result = 0;

        if (ques1) {
            result++;
        }
        if (ques2) {
            result++;
        }
        if (ques3b && ques3d) {
            result++;
        }

        if (ques4d) {
            result++;
        }

        return result;

    }

    public void resetQuiz (View view) {

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
