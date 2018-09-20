package com.advinity.carbonteam.hydrocarbon.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.QuizDetailActivity;
import com.advinity.carbonteam.hydrocarbon.modal.Quiz;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    private Spinner quizRange;
    private SeekBar quizTime;
    private SeekBar quizSum;
    private TextView quizTimeLabel;
    private TextView quizSumLabel;
    private FloatingActionButton fab;

    private final String TAG_ALL = "All";
    private final String TAG_ALKANA = "Alkana";
    private final String TAG_ALKENA = "Alkena";
    private final String TAG_ALKUNA = "Alkuna";

    private String CURRENT_TAG = TAG_ALL;

    private int timeQuiz;
    private int sumQuiz;

    public QuizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        quizRange = (Spinner) view.findViewById(R.id.quiz_range_question);
        ArrayAdapter<CharSequence> quizRangeAdapter = ArrayAdapter.createFromResource(getContext(), R.array.quiz_range_question, android.R.layout.simple_spinner_dropdown_item);
        quizRange.setAdapter(quizRangeAdapter);

        quizTime = (SeekBar) view.findViewById(R.id.quiz_time_question);
        quizSum = (SeekBar) view.findViewById(R.id.quiz_sum_question);

        quizSumLabel = (TextView) view.findViewById(R.id.quiz_sum_label);
        quizTimeLabel = (TextView) view.findViewById(R.id.quiz_time_label);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        quizRange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        CURRENT_TAG = TAG_ALL;
                        break;
                    case 1 :
                        CURRENT_TAG = TAG_ALKANA;
                        break;
                    case 2 :
                        CURRENT_TAG = TAG_ALKENA;
                        break;
                    case 3 :
                        CURRENT_TAG = TAG_ALKUNA;
                        break;
                    default:
                        CURRENT_TAG = TAG_ALL;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                CURRENT_TAG = TAG_ALL;
            }
        });


        int min = 10;
        int step = 1;

        quizSum.setMax(30);
        quizSum.setProgress(quizSum.getMax()/2);
        sumQuiz = min + (quizSum.getProgress() * step);
        quizSumLabel.setText("Jumlah Soal : "+ sumQuiz);
        quizSum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 10;
                int step = 1;

                sumQuiz = min + (progress * step);

                quizSumLabel.setText("Jumlah Soal : "+ sumQuiz);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        int minT = 1;
        int stepT = 1;

        quizTime.setMax(29);
        quizTime.setProgress(quizSum.getMax()/2);
        timeQuiz = minT + (quizTime.getProgress() * stepT);
        quizTimeLabel.setText("Waktu : "+ timeQuiz +" menit");
        quizTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int step = 1;

                timeQuiz = min + (progress * step);

                quizTimeLabel.setText("Waktu : "+ timeQuiz +" menit");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext(), "Soal : "+ sumQuiz +"\nWaktu : "+ timeQuiz +"\nRange : "+ CURRENT_TAG, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), QuizDetailActivity.class);
                intent.putExtra("range", CURRENT_TAG);
                intent.putExtra("time", timeQuiz);
                intent.putExtra("sum", sumQuiz);

                startActivity(intent);
            }
        });
    }
}
