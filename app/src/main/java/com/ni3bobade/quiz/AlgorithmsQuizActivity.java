package com.ni3bobade.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AlgorithmsQuizActivity extends AppCompatActivity {

    RadioGroup algorithmsFirstQuestionRadioGroup;
    RadioGroup algorithmsFourthQuestionRadioGroup;
    RadioGroup algorithmsFifthQuestionRadioGroup;

    EditText algorithmsThirdQuestionEditText;

    CheckBox algorithmsSecondQuestionFirstOptionCheckBox;
    CheckBox algorithmsSecondQuestionSecondOptionCheckBox;
    CheckBox algorithmsSecondQuestionThirdOptionCheckBox;

    Button algorithmsSubmitButton;

    int score;

    public static final String SCORE = "com.ni3bobade.quiz.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithms_quiz);

        algorithmsFirstQuestionRadioGroup = findViewById(R.id.algorithmsFirstQuestionRadioGroup);
        algorithmsFourthQuestionRadioGroup = findViewById(R.id.algorithmsFourthQuestionRadioGroup);
        algorithmsFifthQuestionRadioGroup = findViewById(R.id.algorithmsFifthQuestionRadioGroup);

        algorithmsThirdQuestionEditText = findViewById(R.id.algorithmsThirdQuestionEditText);

        algorithmsSecondQuestionFirstOptionCheckBox = findViewById(R.id.algorithmsSecondQuestionFirstOptionCheckBox);
        algorithmsSecondQuestionSecondOptionCheckBox = findViewById(R.id.algorithmsSecondQuestionSecondOptionCheckBox);
        algorithmsSecondQuestionThirdOptionCheckBox = findViewById(R.id.algorithmsSecondQuestionThirdOptionCheckBox);

        algorithmsSubmitButton = findViewById(R.id.algorithmsSubmitButton);

        algorithmsSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForFirstQuestionAnswer();
                checkForSecondQuestionAnswer();
                checkForThirdQuestionAnswer();
                checkForFourthQuestionAnswer();
                checkForFifthQuestionAnswer();

                Intent intent = new Intent(AlgorithmsQuizActivity.this, QuizSummaryActivity.class);
                intent.putExtra(SCORE, score);
                startActivity(intent);

                finish();
            }
        });

    }

    private void checkForFirstQuestionAnswer() {
        RadioButton firstQuestionSelectedRadioButton = findViewById(algorithmsFirstQuestionRadioGroup.getCheckedRadioButtonId());
        int firstQuestionAnswer = algorithmsFirstQuestionRadioGroup.indexOfChild(firstQuestionSelectedRadioButton) + 1;

        if (firstQuestionAnswer == 2) {
            score++;
        }
    }

    private void checkForSecondQuestionAnswer() {

        if (algorithmsSecondQuestionFirstOptionCheckBox.isChecked() && algorithmsSecondQuestionSecondOptionCheckBox.isChecked() && algorithmsSecondQuestionThirdOptionCheckBox.isChecked()) {
            score++;
        }

    }

    private void checkForThirdQuestionAnswer() {
        if (algorithmsThirdQuestionEditText.getText().toString().equalsIgnoreCase(getString(R.string.algorithms_third_question_answer))) {
            score++;
        }
    }

    private void checkForFourthQuestionAnswer() {

        RadioButton fourthQuestionSelectedRadioButton = findViewById(algorithmsFourthQuestionRadioGroup.getCheckedRadioButtonId());
        int fourthQuestionAnswer = algorithmsFourthQuestionRadioGroup.indexOfChild(fourthQuestionSelectedRadioButton) + 1;

        if (fourthQuestionAnswer == 2) {
            score++;
        }

    }

    private void checkForFifthQuestionAnswer() {

        RadioButton fifthQuestionSelectedRadioButton = findViewById(algorithmsFifthQuestionRadioGroup.getCheckedRadioButtonId());
        int fifthQuestionAnswer = algorithmsFifthQuestionRadioGroup.indexOfChild(fifthQuestionSelectedRadioButton) + 1;

        if (fifthQuestionAnswer == 1) {
            score++;
        }

    }
}

