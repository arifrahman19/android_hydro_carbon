package com.advinity.carbonteam.hydrocarbon.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.DrawerActivity;
import com.advinity.carbonteam.hydrocarbon.activity.DrawerActivity.*;
import com.advinity.carbonteam.hydrocarbon.fragment.Tutorial.AlkanaFragment;
import com.advinity.carbonteam.hydrocarbon.fragment.Tutorial.AlkenaFragment;
import com.advinity.carbonteam.hydrocarbon.fragment.Tutorial.AlkunaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private CardView btn_dictionary;
    private CardView btn_ebook;
    private CardView btn_alkana;
    private CardView btn_alkena;
    private CardView btn_alkuna;
    private CardView btn_quiz;
    private CardView btn_practice;

    // tags used to attach the fragments
    private static final String TAG_ALKANA = "alkana";
    private static final String TAG_ALKENA = "alkena";
    private static final String TAG_ALKUNA = "alkuna";
    private static final String TAG_DICTIONARY = "dictionary";
    private static final String TAG_EBOOK = "ebook";
    private static final String TAG_PRACTICE = "practice";
    private static final String TAG_QUIZ = "quiz";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_dictionary = (CardView) view.findViewById(R.id.btn_home_dictionary);
        btn_ebook = (CardView) view.findViewById(R.id.btn_home_ebook);
        btn_alkana = (CardView) view.findViewById(R.id.btn_home_alkana);
        btn_alkena = (CardView) view.findViewById(R.id.btn_home_alkena);
        btn_alkuna = (CardView) view.findViewById(R.id.btn_home_alkuna);
        btn_quiz = (CardView) view.findViewById(R.id.btn_home_quiz);
        btn_practice = (CardView) view.findViewById(R.id.btn_home_practice);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_alkana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(1, TAG_ALKANA);
            }
        });

        btn_alkena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(2, TAG_ALKENA);
            }
        });

        btn_alkuna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(3, TAG_ALKUNA);
            }
        });

        btn_ebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(4, TAG_EBOOK);
            }
        });

        btn_dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(5, TAG_DICTIONARY);
            }
        });

        btn_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(6, TAG_QUIZ);
            }
        });

        btn_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DrawerActivity)getActivity()).setCurrentTag(7, TAG_PRACTICE);
            }
        });
    }
}