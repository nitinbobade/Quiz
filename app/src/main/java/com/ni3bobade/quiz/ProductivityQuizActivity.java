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

public class ProductivityQuizActivity extends AppCompatActivity {

    RadioGroup productivityFirstQuestionRadioGroup;
    RadioGroup productivityFourthQuestionRadioGroup;
    RadioGroup productivityFifthQuestionRadioGroup;

    EditText productivityThirdQuestionEditText;

    CheckBox productivitySecondQuestionFirstOptionCheckBox;
    CheckBox productivitySecondQuestionSecondOptionCheckBox;
    CheckBox productivitySecondQuestionThirdOptionCheckBox;

    Button productivitySubmitButton;

    int score;

    public static final String SCORE = "com.ni3bobade.quiz.SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productivity_quiz);

        productivityFirstQuestionRadioGroup = findViewById(R.id.productivityFirstQuestionRadioGroup);
        productivityFourthQuestionRadioGroup = findViewById(R.id.productivityFourthQuestionRadioGroup);
        productivityFifthQuestionRadioGroup = findViewById(R.id.productivityFifthQuestionRadioGroup);

        productivityThirdQuestionEditText = findViewById(R.id.productivityThirdQuestionEditText);

        productivitySecondQuestionFirstOptionCheckBox = findViewById(R.id.productivitySecondQuestionFirstOptionCheckBox);
        productivitySecondQuestionSecondOptionCheckBox = findViewById(R.id.productivitySecondQuestionSecondOptionCheckBox);
        productivitySecondQuestionThirdOptionCheckBox = findViewById(R.id.productivitySecondQuestionThirdOptionCheckBox);

        productivitySubmitButton = findViewById(R.id.productivitySubmitButton);

        productivitySubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForFirstQuestionAnswer();
                checkForSecondQuestionAnswer();
                checkForThirdQuestionAnswer();
                checkForFourthQuestionAnswer();
                checkForFifthQuestionAnswer();

                Intent intent = new Intent(ProductivityQuizActivity.this, QuizSummaryActivity.class);
                intent.putExtra(SCORE, score);
                startActivity(intent);

                finish();
            }
        });

    }

    private void checkForFirstQuestionAnswer() {
        RadioButton firstQuestionSelectedRadioButton = findViewById(productivityFirstQuestionRadioGroup.getCheckedRadioButtonId());
        int firstQuestionAnswer = productivityFirstQuestionRadioGroup.indexOfChild(firstQuestionSelectedRadioButton) + 1;

        if (firstQuestionAnswer == 2) {
            score++;
        }
    }

    private void checkForSecondQuestionAnswer() {

        if (productivitySecondQuestionFirstOptionCheckBox.isChecked() && productivitySecondQuestionSecondOptionCheckBox.isChecked() && productivitySecondQuestionThirdOptionCheckBox.isChecked()) {
            score++;
        }

    }

    private void checkForThirdQuestionAnswer() {
        if (productivityThirdQuestionEditText.getText().toString().equalsIgnoreCase(getString(R.string.productivity_third_question_answer))) {
            score++;
        }
    }

    private void checkForFourthQuestionAnswer() {

        RadioButton fourthQuestionSelectedRadioButton = findViewById(productivityFourthQuestionRadioGroup.getCheckedRadioButtonId());
        int fourthQuestionAnswer = productivityFourthQuestionRadioGroup.indexOfChild(fourthQuestionSelectedRadioButton) + 1;

        if (fourthQuestionAnswer == 1) {
            score++;
        }

    }

    private void checkForFifthQuestionAnswer() {

        RadioButton fifthQuestionSelectedRadioButton = findViewById(productivityFifthQuestionRadioGroup.getCheckedRadioButtonId());
        int fifthQuestionAnswer = productivityFifthQuestionRadioGroup.indexOfChild(fifthQuestionSelectedRadioButton) + 1;

        if (fifthQuestionAnswer == 1) {
            score++;
        }

    }
}
