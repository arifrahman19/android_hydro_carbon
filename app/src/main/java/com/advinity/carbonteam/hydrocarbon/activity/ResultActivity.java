package com.advinity.carbonteam.hydrocarbon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;

public class ResultActivity extends AppCompatActivity {

    private TextView resultScore;
    private TextView resultQuestion;
    private TextView resultCorrectAnswer;
    private TextView resultWrongAnswer;
    private TextView resultTime;
    private TextView resultAverageTime;
    private TextView resultBreakdown;
    private Button retry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Hasil Quiz");

        resultScore = (TextView) findViewById(R.id.result_score);
        resultQuestion = (TextView) findViewById(R.id.result_quest);
        resultCorrectAnswer = (TextView) findViewById(R.id.result_correct_answer);
        resultWrongAnswer = (TextView) findViewById(R.id.result_wrong_answer);
        resultTime = (TextView) findViewById(R.id.result_time);
        resultAverageTime = (TextView) findViewById(R.id.result_average_time);
        resultBreakdown = (TextView) findViewById(R.id.result_breakdown);
        retry = (Button) findViewById(R.id.btn_back_menu);

        Integer finalScore = (Integer) getIntent().getExtras().get("finalScore");
        Integer question = (Integer) getIntent().getExtras().get("question");
        Integer correctAnswer = (Integer) getIntent().getExtras().get("correctAnswer");
        Integer wrongAnswer = (Integer) getIntent().getExtras().get("wrongAnswer");
        long finalTime = (long) getIntent().getExtras().get("finalTime");
        long averageTime = (long) getIntent().getExtras().get("averageTime");
        String breakdown = (String) getIntent().getExtras().get("breakdown");

        resultScore.setText(finalScore +"%");
        resultQuestion.setText(question +" soal");
        resultCorrectAnswer.setText(correctAnswer +" soal");
        resultWrongAnswer.setText(wrongAnswer +" soal");

        long minutes = finalTime / 60000;
        long second = finalTime % 60000 / 1000;

        resultTime.setText(minutes +" menit "+ second +" detik");
        resultAverageTime.setText(averageTime / 1000 +" detik/soal");
        resultBreakdown.setText(breakdown);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
