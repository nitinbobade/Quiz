package com.ni3bobade.quiz;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.MessageFormat;

public class QuizSummaryActivity extends AppCompatActivity {

    ImageView greetingsIllustrationImageView;
    TextView scoreTextView;
    TextView greetingsTextView;
    Button takeAnotherQuizButton;
    ConstraintLayout quizSummaryConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_summary);

        greetingsIllustrationImageView = findViewById(R.id.greetingsIllustrationImageView);
        scoreTextView = findViewById(R.id.scoreTextView);
        greetingsTextView = findViewById(R.id.greetingsTextView);
        takeAnotherQuizButton = findViewById(R.id.takeAnotherQuizButton);
        quizSummaryConstraintLayout = findViewById(R.id.quizSummaryConstraintLayout);

        Intent intent = getIntent();
        int score = intent.getIntExtra(ProgrammingQuizActivity.SCORE, 0);

        scoreTextView.setText(MessageFormat.format("{0}", score));

        if (score <= 3) {
            greetingsTextView.setText(getString(R.string.better_luck_next_time));
            greetingsIllustrationImageView.setImageResource(R.drawable.better_luck_next_time_illustration);

        } else {
            greetingsTextView.setText(getString(R.string.congratulations));
            greetingsIllustrationImageView.setImageResource(R.drawable.congrats_illustration);
        }

        Snackbar.make(quizSummaryConstraintLayout, "You scored: " + score, Snackbar.LENGTH_INDEFINITE).show();

        takeAnotherQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSummaryActivity.this, QuizTopicsActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
