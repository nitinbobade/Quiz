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

public class ProgrammingQuizActivity extends AppCompatActivity {

    RadioGroup programmingFirstQuestionRadioGroup;
    RadioGroup programmingFourthQuestionRadioGroup;
    RadioGroup programmingFifthQuestionRadioGroup;

    EditText programmingThirdQuestionEditText;

    CheckBox programmingFirstOptionCheckBox;
    CheckBox programmingSecondOptionCheckBox;
    CheckBox programmingThirdOptionCheckBox;

    Button programmingSubmitButton;

    int score;

    public static final String SCORE = "com.ni3bobade.quiz.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_quiz);

        programmingFirstQuestionRadioGroup = findViewById(R.id.programmingFirstQuestionRadioGroup);
        programmingFourthQuestionRadioGroup = findViewById(R.id.programmingFourthQuestionRadioGroup);
        programmingFifthQuestionRadioGroup = findViewById(R.id.programmingFifthQuestionRadioGroup);

        programmingThirdQuestionEditText = findViewById(R.id.programmingThirdQuestionEditText);

        programmingFirstOptionCheckBox = findViewById(R.id.programmingSecondQuestionFirstOptionCheckBox);
        programmingSecondOptionCheckBox = findViewById(R.id.programmingSecondQuestionSecondOptionCheckBox);
        programmingThirdOptionCheckBox = findViewById(R.id.programmingSecondQuestionThirdOptionCheckBox);

        programmingSubmitButton = findViewById(R.id.programmingSubmitButton);

        programmingSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForFirstQuestionAnswer();
                checkForSecondQuestionAnswer();
                checkForThirdQuestionAnswer();
                checkForFourthQuestionAnswer();
                checkForFifthQuestionAnswer();

                Intent intent = new Intent(ProgrammingQuizActivity.this, QuizSummaryActivity.class);
                intent.putExtra(SCORE, score);
                startActivity(intent);

                finish();
            }
        });

    }

    private void checkForFirstQuestionAnswer() {
        RadioButton firstQuestionSelectedRadioButton = findViewById(programmingFirstQuestionRadioGroup.getCheckedRadioButtonId());
        int firstQuestionAnswer = programmingFirstQuestionRadioGroup.indexOfChild(firstQuestionSelectedRadioButton) + 1;

        if (firstQuestionAnswer == 2) {
            score++;
        }
    }

    private void checkForSecondQuestionAnswer() {

        if (programmingFirstOptionCheckBox.isChecked() && programmingSecondOptionCheckBox.isChecked() && programmingThirdOptionCheckBox.isChecked()) {
            score++;
        }

    }

    private void checkForThirdQuestionAnswer() {
        if (programmingThirdQuestionEditText.getText().toString().equalsIgnoreCase("statically")) {
            score++;
        }
    }

    private void checkForFourthQuestionAnswer() {

        RadioButton fourthQuestionSelectedRadioButton = findViewById(programmingFourthQuestionRadioGroup.getCheckedRadioButtonId());
        int fourthQuestionAnswer = programmingFourthQuestionRadioGroup.indexOfChild(fourthQuestionSelectedRadioButton) + 1;

        if (fourthQuestionAnswer == 2) {
            score++;
        }

    }

    private void checkForFifthQuestionAnswer() {

        RadioButton fifthQuestionSelectedRadioButton = findViewById(programmingFifthQuestionRadioGroup.getCheckedRadioButtonId());
        int fifthQuestionAnswer = programmingFifthQuestionRadioGroup.indexOfChild(fifthQuestionSelectedRadioButton) + 1;

        if (fifthQuestionAnswer == 2) {
            score++;
        }

    }
}
