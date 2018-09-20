package com.advinity.carbonteam.hydrocarbon.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Quiz;
import com.advinity.carbonteam.hydrocarbon.modal.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizDetailActivity extends AppCompatActivity {

    private TextView quizTime;
    private TextView quizQuestion;
    private TextView quizChoiceA;
    private TextView quizChoiceB;
    private TextView quizChoiceC;
    private TextView quizChoiceD;

    private ImageView quizImgChoiceA;
    private ImageView quizImgChoiceB;
    private ImageView quizImgChoiceC;
    private ImageView quizImgChoiceD;

    private CardView quizBtnChoiceA;
    private CardView quizBtnChoiceB;
    private CardView quizBtnChoiceC;
    private CardView quizBtnChoiceD;

    private List<Quiz> quizList = new ArrayList<>();
    private List<Answer> answerList = new ArrayList<>();

    private boolean isAnswer = false;
    private String myAnswer;
    private Integer CURRENT_SUM = 0;

    private String range;
    private Integer time;
    private Integer sum;

    private CountDownTimer downTimer;
    private CountDownTimer quizTimer;

    private Integer correctAnswer = 0;
    private Integer wrongAnswer = 0;
    private Integer finalScore;
    private long finalTime;
    private long averageTime;
    private long outTime;
    private String breakdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quizTime = (TextView) findViewById(R.id.quiz_time);
        quizQuestion = (TextView) findViewById(R.id.quiz_question);
        quizChoiceA = (TextView) findViewById(R.id.quiz_choiceA);
        quizChoiceB = (TextView) findViewById(R.id.quiz_choiceB);
        quizChoiceC = (TextView) findViewById(R.id.quiz_choiceC);
        quizChoiceD = (TextView) findViewById(R.id.quiz_choiceD);

        quizImgChoiceA = (ImageView) findViewById(R.id.quiz_choiceA_img);
        quizImgChoiceB = (ImageView) findViewById(R.id.quiz_choiceB_img);
        quizImgChoiceC = (ImageView) findViewById(R.id.quiz_choiceC_img);
        quizImgChoiceD = (ImageView) findViewById(R.id.quiz_choiceD_img);

        quizBtnChoiceA = (CardView) findViewById(R.id.quiz_btn_ChoiceA);
        quizBtnChoiceB = (CardView) findViewById(R.id.quiz_btn_ChoiceB);
        quizBtnChoiceC = (CardView) findViewById(R.id.quiz_btn_ChoiceC);
        quizBtnChoiceD = (CardView) findViewById(R.id.quiz_btn_ChoiceD);

        range = (String) getIntent().getExtras().get("range");
        time = (Integer) getIntent().getExtras().get("time");
        sum = (Integer) getIntent().getExtras().get("sum");

        downTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                setQuiz();
            }
        };

        quizTimer = new CountDownTimer(time*60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                outTime = millisUntilFinished;
                long minute = millisUntilFinished / 60000;
                long second = millisUntilFinished % 60000;

                quizTime.setText(minute +" : "+ second / 1000);
            }

            @Override
            public void onFinish() {
                setResult();
            }
        }.start();

        prepareQuizData();
        setQuiz();
    }

    private void setQuiz() {
        CURRENT_SUM++;
        isAnswer = false;

        quizImgChoiceA.setVisibility(View.GONE);
        quizImgChoiceB.setVisibility(View.GONE);
        quizImgChoiceC.setVisibility(View.GONE);
        quizImgChoiceD.setVisibility(View.GONE);

        quizBtnChoiceA.setClickable(true);
        quizBtnChoiceB.setClickable(true);
        quizBtnChoiceC.setClickable(true);
        quizBtnChoiceD.setClickable(true);

        if (CURRENT_SUM <= sum) {
            randomQuestion();
        } else {
            quizTimer.cancel();
            setResult();
        }
    }

    private void randomQuestion() {
        Random random = new Random();
        Integer index = random.nextInt(quizList.size());

        Quiz quiz = quizList.get(index);

        if (range.equals(quiz.getRange()) || range.equals("All")) {
            quizQuestion.setText(quiz.getQuestion());

            quizChoiceA.setText(quiz.getChoiceA());
            quizChoiceA.setVisibility(View.VISIBLE);

            quizChoiceB.setText(quiz.getChoiceB());
            quizChoiceB.setVisibility(View.VISIBLE);

            quizChoiceC.setText(quiz.getChoiceC());
            quizChoiceC.setVisibility(View.VISIBLE);

            quizChoiceD.setText(quiz.getChoiceD());
            quizChoiceD.setVisibility(View.VISIBLE);

            setMyAnswer(quiz);

        }else{
            randomQuestion();
        }
    }

    private void setMyAnswer(final Quiz quiz) {
//        Toast.makeText(QuizDetailActivity.this, quiz.getRange(), Toast.LENGTH_SHORT).show();
        quizBtnChoiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBtnChoiceA.setClickable(false);
                myAnswer = quiz.getChoiceA();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceA.setVisibility(View.GONE);
                    quizImgChoiceA.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceA.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Benar"));
                        isAnswer = true;
                    }

                    downTimer.start();
                } else {
                    quizChoiceA.setVisibility(View.GONE);
                    quizImgChoiceA.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceA.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Salah"));
                        isAnswer = true;
                    }
                }
            }
        });

        quizBtnChoiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBtnChoiceB.setClickable(false);
                myAnswer = quiz.getChoiceB();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceB.setVisibility(View.GONE);
                    quizImgChoiceB.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceB.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Benar"));
                        isAnswer = true;
                    }

                    downTimer.start();
                } else {
                    quizChoiceB.setVisibility(View.GONE);
                    quizImgChoiceB.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceB.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Salah"));
                        isAnswer = true;
                    }
                }
            }
        });

        quizBtnChoiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBtnChoiceC.setClickable(false);
                myAnswer = quiz.getChoiceC();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceC.setVisibility(View.GONE);
                    quizImgChoiceC.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceC.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Benar"));
                        isAnswer = true;
                    }

                    downTimer.start();
                } else {
                    quizChoiceC.setVisibility(View.GONE);
                    quizImgChoiceC.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceC.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Salah"));
                        isAnswer = true;
                    }
                }
            }
        });

        quizBtnChoiceD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizBtnChoiceD.setClickable(false);
                myAnswer = quiz.getChoiceD();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceD.setVisibility(View.GONE);
                    quizImgChoiceD.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceD.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Benar"));
                        isAnswer = true;
                    }

                    downTimer.start();
                } else {
                    quizChoiceD.setVisibility(View.GONE);
                    quizImgChoiceD.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceD.setVisibility(View.VISIBLE);

                    if (isAnswer == false) {
                        answerList.add(new Answer(CURRENT_SUM, quiz.getRange(), "Salah"));
                        isAnswer = true;
                    }
                }
            }
        });
    }

    private void setResult() {
        quizTimer.cancel();

        if (answerList.size() == 0) {
            finalScore = 0;
            correctAnswer = 0;
            wrongAnswer = 0;
            finalTime = time * 60000;
            averageTime = finalTime;
            breakdown = null;

        } else {
            for (int i = 0; i < answerList.size(); i++) {
                Answer answer = answerList.get(i);

                if (answer.getAnswer().equals("Benar")) {
                    correctAnswer++;
                } else {
                    wrongAnswer++;
                }

                if (breakdown == null) {
                    breakdown = "Pertanyaan "+ answer.getId() +"\t\t\t\t"+ answer.getRange() +"\t\t\t\t"+ answer.getAnswer() +"\n";
                } else {
                    breakdown = breakdown +"Pertanyaan "+ answer.getId() +"\t\t\t\t"+ answer.getRange() +"\t\t\t\t"+ answer.getAnswer() +"\n";
                }
            }

            finalScore = (correctAnswer * 100) / answerList.size();
            finalTime = (time * 60000) - outTime;
            averageTime = finalTime / (correctAnswer + wrongAnswer);

        }

        Intent intent = new Intent(QuizDetailActivity.this, ResultActivity.class);
        intent.putExtra("finalScore", finalScore);
        intent.putExtra("question", answerList.size());
        intent.putExtra("correctAnswer", correctAnswer);
        intent.putExtra("wrongAnswer", wrongAnswer);
        intent.putExtra("finalTime", finalTime);
        intent.putExtra("averageTime", averageTime);
        intent.putExtra("breakdown", breakdown);

        startActivity(intent);
        finish();
    }

    private void prepareQuizData() {
        Quiz quiz = new Quiz(
                "Alkana",
                "Rumus umum dari Alkana adalah ...",
                "CnH2n+2",
                "CnH2n",
                "CnHn+2",
                "CnH2n+2",
                "CnHn"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Butana adalah ...",
                "C4H10",
                "CH6",
                "C3H8",
                "C4H10",
                "C2H6"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Metana adalah ...",
                "CH4",
                "CH4",
                "CH6",
                "C2H6",
                "C2HO"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Etana adalah ...",
                "C2H6",
                "CH4",
                "CH6",
                "C2H6",
                "C2HO"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Senyawa C4H10 memiliki berapa kemungkinan rumus struktur ?",
                "2",
                "1",
                "2",
                "3",
                "4"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Angka oktan digunakan untuk mengekspresikan ...",
                "Jumlah oktan pada bensin",
                "Sebuah viskositas minyak",
                "Kendaraan dengan bahan bakar ber-oktan",
                "Kualitas gasoine sebagai afuel untuk mesin tegangan tinggi",
                "Jumlah oktan pada bensin"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Bensin premium memiliki angka oktan dari 80, berarti bensin tersebut terdiri dari ...",
                "80% isooktana dan 20% n-heptana",
                "80% isooktana dan 20% n-heptana",
                "80% heptana dan 20% isooktana",
                "80% butana dan 20% isooktana",
                "80% isooktana dan 20% n-butana"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Alkana yang digunakan sebagai LPG adalah ...",
                "Propana",
                "Metana",
                "Oktan",
                "Propana",
                "Pentana"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Nama lain dari Alkana adalah ...",
                "Parafin",
                "Parafin",
                "Asitelen",
                "Rantai Karbon",
                "Alifatik"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Alkana tergolong senyawa hidrokarbon ...",
                "Alifatik jenuh",
                "Alifatik tidak jenuh",
                "Alifatik jenuh",
                "Alisiklik tidak jenuh",
                "Aromatik"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Ikatan rangkap yang dimiliki Alkuna adalah ...",
                "Ikatan rangkap tiga",
                "Ikatan rangkap dua",
                "Ikatan rangkap tiga",
                "Ikatan rangkap empat",
                "Ikatan rangkap satu"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Titik leleh dari Butuna adalah ...",
                "108.9 °C",
                "108.9 °C",
                "102.8 °C",
                "103.4 °C",
                "105.7 °C"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Alkuna dapat dibuat dengan mereaksikan dihaloalkana dengan ...",
                "Alkoholat",
                "Siklik",
                "Sikoloat",
                "Alkoholat",
                "Halogenoat"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Alkuna yang paling sederhana adalah ...",
                "Asetilena",
                "Asetilena",
                "Propuna",
                "Butuna",
                "Deksuna"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Zat kimia industri penting yang digunakan sebagai monomer dalam produksi karet sintetis adalah ...",
                "Butuna",
                "Asetilena",
                "Propuna",
                "Butuna",
                "Oktuna"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Titik didih dari Propuna adalah ...",
                "−23.2 °C",
                "−23.2 °C",
                "-29 °C",
                "−25.3 °C",
                "−33.2 °C"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkuna",
                "Massa molar dari Propuna adalah ...",
                "50.0639 g/mol",
                "41.0649 g/mol",
                "42.063 g/mol",
                "50.0639 g/mol",
                "40.0639 g/mol"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Nama lain dari Alkena adalah ...",
                "Olefin",
                "Olefin",
                "Parafin",
                "Asitelen",
                "Alifatik"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Alkena yang paling sederhana adalah ...",
                "Etilena",
                "Butena",
                "Etilena",
                "Propena",
                "Oktena"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Senyawa alkena sering kita gunakan dalam kehidupan sehari-hari contohnya ...",
                "Karet dan plastik",
                "Karet dan plastik",
                "Bahan untuk industri pabrik",
                "Detergen",
                "Bahan untuk penyulingan minyak"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Rumus umum Alkena dapat dinyatakan dengan ...",
                "CnH2n",
                "CH3n",
                "CnH2n",
                "CH2n",
                "CnHn"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Isomer geometri adalah ...",
                "Isomer yang menjadikan ikatan rangkap sebagai sumbu atau keisomeran yang terjadi karena " +
                        "perbedaan orientasi gugus-gugus di sekitar C ikatan rangkap",
                "Isomer yang menjadikan senyawa senyawa menjadi ikatan rangkap",
                "Senyawa-senyawa dengan rumus molekul sama, namun memiliki penataan atom yang berbeda",
                "Molekul molekul yang mempunyai ikatan rangkap yang sama",
                "Isomer yang menjadikan ikatan rangkap sebagai sumbu atau keisomeran yang terjadi karena " +
                        "perbedaan orientasi gugus-gugus di sekitar C ikatan rangkap"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Titik didih dari Propena adalah ...",
                "−47,6 °C",
                "−49,6 °C",
                "−48,6 °C",
                "−47,6 °C",
                "−50,6 °C"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Massa molar dari Propena adalah ...",
                "42,08 g/mol",
                "42,06 g/mol",
                "42,07 g/mol",
                "42,08 g/mol",
                "42,09 g/mol"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Senyawa Alkena yang paling sederhana kedua setelah Etilena adalah ...",
                "Propuna",
                "Propuna",
                "Butuna",
                "Oktena",
                "Nonena"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkena",
                "Titik didih dari Heptena adalah ...",
                "98.38 °C",
                "98.26 °C",
                "98.38 °C",
                "98.35 °C",
                "98.04 °C"
        );
        quizList.add(quiz);
    }

    @Override
    public void onBackPressed() {
        downTimer.cancel();
        quizTimer.cancel();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        downTimer.cancel();
        quizTimer.cancel();
        finish();

        return super.onSupportNavigateUp();
    }
}
