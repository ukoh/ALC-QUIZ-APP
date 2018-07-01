
package com.example.babybest.alcquizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class BibleActivity extends AppCompatActivity {

    //radioButtons
    final int answerQuizOne = R.id.answerQuizOne;
    final int answerQuizFour = R.id.answerQuizFour;
    final int answerQuizSix = R.id.answerQuizSix;
    final int answerQuizEight = R.id.answerQ8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bible);
    }
    private boolean checkQuizOne() {
        RadioGroup radioButton = findViewById(R.id.quizOne);
        if (radioButton.getCheckedRadioButtonId() == answerQuizOne) {
            return true;
        }
        return false;
    }

    private boolean checkQuizFour() {
        RadioGroup radioButton = findViewById(R.id.quizFour);
        if (radioButton.getCheckedRadioButtonId() == answerQuizFour) {
            return true;
        }
        return false;
    }

    private boolean checkQuizThree() {
        CheckBox box_one = findViewById(R.id.box_one);
        CheckBox box_two = findViewById(R.id.box_two);
        CheckBox box_three = findViewById(R.id.box_three);

        if (box_one.isChecked() && box_two.isChecked() && box_three.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean checkQuizTwo() {
        EditText answerTwo = findViewById(R.id.answerQuizTwo);
        return answerTwo.getText().toString().equalsIgnoreCase("joshua");
    }


    private boolean checkQuizFive() {
        EditText answerFive = findViewById(R.id.answerQuizFive);
        return answerFive.getText().toString().equalsIgnoreCase("Bethel");
    }

    private boolean checkQuizSix() {
        RadioGroup radioButton = findViewById(R.id.quizSix);
        if (radioButton.getCheckedRadioButtonId() == answerQuizSix) {
            return true;
        }
        return false;
    }

    private boolean checkQuizSeven() {
        CheckBox box_one = findViewById(R.id.q7_box1);
        CheckBox box_two = findViewById(R.id.q7_box2);
        CheckBox box_three = findViewById(R.id.q7_box3);

        if (box_three.isChecked()) {
            return true;
        }
        return false;
    }

    private boolean checkQuizEight() {
        RadioGroup radioButton = findViewById(R.id.quiz8);
        if (radioButton.getCheckedRadioButtonId() == answerQuizEight) {
            return true;
        }
        return false;
    }


    // the logic for right and wrong answer

    public void submit(View v) {
        ArrayList<String> wrongAnswersList = new ArrayList<String>();

        int numbersOfRightQuestions = 0;

        if (checkQuizOne()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 1");
        }
        if (checkQuizTwo()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 2");
        }
        if (checkQuizThree()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 3");
        }
        if (checkQuizFour()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 4");
        }
        if (checkQuizFive()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 5");
        }
        if (checkQuizSix()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 6");
        }
        if (checkQuizSeven()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 7");
        }
        if (checkQuizEight()) {
            numbersOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 8");
        }


        //Store the wrongs answer in a string message
        StringBuilder string = new StringBuilder();
        for (String s : wrongAnswersList) {
            string.append(s);
            string.append("\n");
        }
        //This string message will be displayed in a toast
        Context context = getApplicationContext();
        if (numbersOfRightQuestions == 8) {
            CharSequence text = "Congratulations! You got all answers right." + string.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else if (numbersOfRightQuestions < 1) {
            CharSequence text = "What a pity! You need to study more. You got zero answers right.";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else if (numbersOfRightQuestions ==7) {
            CharSequence text = "Great job! you were so close! " +
                    "you got "+ numbersOfRightQuestions + "/8 answer right. \n\nCheck again \n:" + string.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            CharSequence text = "Keep trying! You got " + numbersOfRightQuestions + "/8 answers right.\n\nCheck again the following:\n" + string.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
    public  void resetButton(View v){

        EditText editText = findViewById(R.id.answerQuizTwo);
        editText.setText("");
        EditText text = findViewById(R.id.answerQuizFive);
        text.setText("");

        RadioGroup radioGroup = findViewById((R.id.quizOne));
        radioGroup.clearCheck();

        RadioGroup group = findViewById((R.id.quizFour));
        group.clearCheck();

        RadioGroup radio_group = findViewById((R.id.quizSix));
        radio_group.clearCheck();

        RadioGroup Group = findViewById((R.id.quiz8));
        Group.clearCheck();



        CheckBox checkBox = findViewById(R.id.box_one);
        checkBox.setChecked(false);

        CheckBox Box = findViewById(R.id.box_two);
        Box.setChecked(false);

        CheckBox box = findViewById(R.id.box_three);
        box.setChecked(false);

        CheckBox q7_box1 = findViewById(R.id.q7_box1);
        q7_box1.setChecked(false);

        CheckBox q7_box2 = findViewById(R.id.q7_box2);
        q7_box2.setChecked(false);

        CheckBox q7_box3 = findViewById(R.id.q7_box3);
        q7_box3.setChecked(false);
    }

}

