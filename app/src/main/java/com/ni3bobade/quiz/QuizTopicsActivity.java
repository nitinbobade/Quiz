package com.ni3bobade.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuizTopicsActivity extends AppCompatActivity {

    ImageView programmingCategoryImageView;
    ImageView uxDesignCategoryImageView;
    ImageView algorithmsCategoryImageView;
    ImageView productivityCategoryImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_topics);

        programmingCategoryImageView = findViewById(R.id.programmingCategoryImageView);
        uxDesignCategoryImageView = findViewById(R.id.uxDesignCategoryImageView);
        algorithmsCategoryImageView = findViewById(R.id.algorithmsCategoryImageView);
        productivityCategoryImageView = findViewById(R.id.productivityCategoryImageView);

        programmingCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTopicsActivity.this, ProgrammingQuizActivity.class);
                startActivity(intent);

                finish();
            }
        });

        uxDesignCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTopicsActivity.this, UxDesignQuizActivity.class);
                startActivity(intent);

                finish();
            }
        });

        algorithmsCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTopicsActivity.this, AlgorithmsQuizActivity.class);
                startActivity(intent);

                finish();
            }
        });

        productivityCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizTopicsActivity.this, ProductivityQuizActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
