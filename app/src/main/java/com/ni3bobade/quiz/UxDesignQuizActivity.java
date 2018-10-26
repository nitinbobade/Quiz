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

public class UxDesignQuizActivity extends AppCompatActivity {

    RadioGroup uxdFirstQuestionRadioGroup;
    RadioGroup uxdFourthQuestionRadioGroup;
    RadioGroup uxdFifthQuestionRadioGroup;

    EditText uxdThirdQuestionEditText;

    CheckBox uxdFirstOptionCheckBox;
    CheckBox uxdSecondOptionCheckBox;
    CheckBox uxdThirdOptionCheckBox;

    Button uxdSubmitButton;

    int score;

    public static final String SCORE = "com.ni3bobade.quiz.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ux_design_quiz);

        uxdFirstQuestionRadioGroup = findViewById(R.id.uxdFirstQuestionRadioGroup);
        uxdFourthQuestionRadioGroup = findViewById(R.id.uxdFourthQuestionRadioGroup);
        uxdFifthQuestionRadioGroup = findViewById(R.id.uxdFifthQuestionRadioGroup);

        uxdThirdQuestionEditText = findViewById(R.id.uxdThirdQuestionEditText);

        uxdFirstOptionCheckBox = findViewById(R.id.uxdSecondQuestionFirstOptionCheckBox);
        uxdSecondOptionCheckBox = findViewById(R.id.uxdSecondQuestionSecondOptionCheckBox);
        uxdThirdOptionCheckBox = findViewById(R.id.uxdSecondQuestionThirdOptionCheckBox);

        uxdSubmitButton = findViewById(R.id.uxdSubmitButton);

        uxdSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForFirstQuestionAnswer();
                checkForSecondQuestionAnswer();
                checkForThirdQuestionAnswer();
                checkForFourthQuestionAnswer();
                checkForFifthQuestionAnswer();

                Intent intent = new Intent(UxDesignQuizActivity.this, QuizSummaryActivity.class);
                intent.putExtra(SCORE, score);
                startActivity(intent);

                finish();
            }
        });

    }

    private void checkForFirstQuestionAnswer() {
        RadioButton firstQuestionSelectedRadioButton = findViewById(uxdFirstQuestionRadioGroup.getCheckedRadioButtonId());
        int firstQuestionAnswer = uxdFirstQuestionRadioGroup.indexOfChild(firstQuestionSelectedRadioButton) + 1;

        if (firstQuestionAnswer == 2) {
            score++;
        }
    }

    private void checkForSecondQuestionAnswer() {

        if (uxdFirstOptionCheckBox.isChecked() && uxdSecondOptionCheckBox.isChecked() && uxdThirdOptionCheckBox.isChecked()) {
            score++;
        }

    }

    private void checkForThirdQuestionAnswer() {
        if (uxdThirdQuestionEditText.getText().toString().equalsIgnoreCase(getString(R.string.uxd_third_question_answer))) {
            score++;
        }
    }

    private void checkForFourthQuestionAnswer() {

        RadioButton fourthQuestionSelectedRadioButton = findViewById(uxdFourthQuestionRadioGroup.getCheckedRadioButtonId());
        int fourthQuestionAnswer = uxdFourthQuestionRadioGroup.indexOfChild(fourthQuestionSelectedRadioButton) + 1;

        if (fourthQuestionAnswer == 2) {
            score++;
        }

    }

    private void checkForFifthQuestionAnswer() {

        RadioButton fifthQuestionSelectedRadioButton = findViewById(uxdFifthQuestionRadioGroup.getCheckedRadioButtonId());
        int fifthQuestionAnswer = uxdFifthQuestionRadioGroup.indexOfChild(fifthQuestionSelectedRadioButton) + 1;

        if (fifthQuestionAnswer == 2) {
            score++;
        }

    }
}
