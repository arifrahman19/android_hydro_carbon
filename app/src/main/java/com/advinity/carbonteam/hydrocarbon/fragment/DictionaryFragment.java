package com.advinity.carbonteam.hydrocarbon.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.adapter.DictionaryAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DictionaryFragment extends Fragment {

    private List<Dictionary> dictionaryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DictionaryAdapter mAdapter;

    public DictionaryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dictionary, container, false);

        // Inisialisasi
        recyclerView = (RecyclerView) view.findViewById(R.id.dictionary_recycleview);

        // Setting layout untuk recylerview
        mAdapter = new DictionaryAdapter(dictionaryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // Mengisi data dictionary
        prepareDictionaryData();
        Collections.sort(dictionaryList);

        return view;
    }

    // Mengisi data dictionary
    private void prepareDictionaryData() {
        Dictionary dictionary = new Dictionary("Hidrokarbon", "Sebuah senyawa yang terdiri dari unsur " +
                "atom karbon dan atom hidrogen. Seluruh hidrokarbon memmiliki rantai karbon dan atom-atom" +
                "hidrogen yang berikatan dengan rantai tersebut.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Molekul", "Sekelompok atom (paling sedikit dua) yang saling berikatan " +
                "dengan sangat kuat/kovalen dalam susunan tertentu dan bermuatan netral serta cukup stabil.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Komersial", "Berhubungan dengan niaga atau perdagangan.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Oksidator", "Spesies kimia yang menghilangkan elektron dari spesies " +
                "lainnya dan merupakan komponen dalam reaksi oksidasi-reduksi (redoks).");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Halogen", "Golongan dengan elektro negatif tertinggi, merupakan " +
                "golongan paling non-logam. Dalam tabel periodik kelompok unsur kimia ini berada pada golongan 7.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Asfiksia", "Kondisi kekurangan oksigen pada pernafasan yang bersifat mengancam jiwa.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Hidrokarbon Aromatik", "Hidrokarbon dengan ikatan tunggal dan atau " +
                "ikatan ganda di antara atom-atom karbon. Hidrokarbon aromatik dapat berupa monosiklik " +
                "atau polisiklik.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Kompresi", "Proses pemampatan gas sehingga tekanannya lebih tinggi " +
                "daripada tekanan semula.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Atom", "Suatu satuan dasar materi, terdiri atas inti atom serta awan " +
                "elektron bermuatan negatif yang mengelilinginya. Inti atom terdiri atas proton yang bermuatan " +
                "positif dan neutron yang bermuatan netral.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Karbon", "Unsur kimia yang mempunyai simbol C dan nomor atom 6 pada " +
                "tabel periodik.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Ikatan Kovalen", "Sejenis ikatan kimia yang memiliki karakteristik " +
                "berupa pasangan elektron yang saling terbagi diantara atom-atom yang berikatan.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Isomer", "Molekul-molekul dengan rumus kimia yang sama, namun memiliki " +
                "susunan atom yang berbeda.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Non Polar", "Senyawa yang terbentuk akibat adanya suatu ikatan antar " +
                "elektron pada unsur-unsur yang membentuknya.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Polar", "Senyawa yang terbentuk akibat adanya suatu ikatan antar elektron " +
                "pada unsur-unsurnya.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Bilangan Oktan", "Angka yang menunjukkan seberapa besar tekanan yang " +
                "bisa diberikan sebelum bensin terbakar secara spontan.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Hibridisasi", "Sebuah konsep bersatunya orbital-orbital atom membentuk " +
                "orbital hybrid yang baru sesuai dengan penjelasan kualitatif sifat ikatan atom.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Destilasi Fraksinasi", "Suatu teknik pemisahan untuk larutan yang " +
                "mempunyai perbedaan titik didih yang tidak terlalu jauh yaitu sekitar 30C atau lebih.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Monomer", "Bahan penyusun polimer. Mereka dapat sederhana atau " +
                "molekul kompleks dengan ikatan rangkap atau gugus fungsional lain. Ketika beberapa monomer " +
                "terhubung untuk membentuk polimer.");
        dictionaryList.add(dictionary);

        dictionary = new Dictionary("Polimer", "Makromolekul (molekul raksasa) yang tersusun dari monomer " +
                "yang merupakan molekul yang kecil dan sederhana.");
        dictionaryList.add(dictionary);
    }

}
