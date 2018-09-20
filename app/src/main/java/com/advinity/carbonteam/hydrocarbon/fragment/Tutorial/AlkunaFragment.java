package com.advinity.carbonteam.hydrocarbon.fragment.Tutorial;


import android.content.Intent;
import android.os.Bundle;
import org.jetbrains.annotations.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.DescriptionActivity;
import com.advinity.carbonteam.hydrocarbon.adapter.AlkunaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkuna;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkunaFragment extends Fragment {

    private List<Alkuna> alkunaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkunaAdapter mAdapter;

    public AlkunaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkuna, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkuna_recycleview);

        mAdapter = new AlkunaAdapter(alkunaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkunaData();
        
        return view;
    }

    private void prepareAlkunaData() {

        int[] image = new int[]{
                R.drawable.alkuna_metuna,
                R.drawable.alkuna_propuna,
                R.drawable.alkuna_butuna,
                R.drawable.alkuna_pentuna,
                R.drawable.alkuna_heksuna,
                R.drawable.alkuna_heptuna,
                R.drawable.alkuna_oktuna,
                R.drawable.alkuna_nonuna,
                R.drawable.alkuna_dekuna
        };

        Alkuna alkuna = new Alkuna(
                "Etuna",
                "C2H2",
                "1.097 g/L\n" +
                        "1.097 kg/m³",
                "26.04 g·mol−1",
                "-",
                "−80.8 °C (−113.4 °F; 192.3 K)",
                "Asetilena merupakan alkuna yang paling sederhana, " +
                        "karena hanya terdiri dari dua atom karbon dan dua atom hidrogen",
                image[0]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Propuna",
                "C3H4",
                "0.53 g/cm³",
                "40.0639 g/mol",
                "−23.2 °C (−9.8 °F; 250.0 K)",
                "−102.7 °C (−152.9 °F; 170.5 K)\n",
                "Alkuna ini merupakan komponen gas MAPP, yang biasa digunakan dalam las karbit",
                image[1]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Butuna",
                "C4H6",
                "0.6149 g/cm³ at 25 °C, Solid\n" +
                        "0.64 g/cm³ at −6 °C, Liquid",
                "54.0916 g/mol",
                "−4.4 °C (24.1 °F; 268.8 K)",
                "−108.9 °C (−164.0 °F; 164.2 K)",
                "Diena terkonjugasi sederhana dengan rumus C4H6. " +
                        "Ini adalah zat kimia industri penting yang digunakan sebagai monomer dalam " +
                        "produksi karet sintetis",
                image[2]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Pentuna",
                "C5H8",
                "0.771 g/cm³",
                "68.11 g/mol",
                "44 to 46 °C (111 to 115 °F; 317 to 319 K)",
                "−135 °C (−211 °F; 138 K)",
                "Cyclopentene diproduksi industri dalam jumlah besar. Hal ini digunakan sebagai " +
                        "monomer untuk sintesis dari plastik, dan di sejumlah sintesis kimia",
                image[3]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Heksuna",
                "C6H10",
                "0.8110 g/cm³",
                "82.143 g/mol",
                "82.98 °C (181.36 °F; 356.13 K)",
                "−103.5 °C (−154.3 °F; 169.7 K)",
                "Cycloalkene ini adalah cairan tak berwarna dengan bau yang tajam. " +
                        "Ini adalah perantara dalam berbagai proses industri ",
                image[4]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Heptuna",
                "C7H12",
                "0.824 g/cm³",
                "96.17 g/mol",
                "112 to 114.7 °C (233.6 to 238.5 °F; 385.1 to 387.8 K)",
                "-",
                "Ini adalah bahan baku dalam kimia organik dan monomer dalam sintesis polimer. " +
                        "Cycloheptene dapat eksis baik sebagai cis atau trans-isomer",
                image[5]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Oktuna",
                "C8H14",
                "0.759 g/mL",
                "110.20 g·mol−1",
                "137 °C (279 °F; 410 K)",
                "-",
                "Siklooktena adalah Cycloalkene dengan cincin delapan beranggota. " +
                        "Hal ini penting karena merupakan Cycloalkene terkecil yang dapat eksis " +
                        "baik sebagai cis atau trans-isomer dengan cis-isomer lebih umum",
                image[6]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Nonuna",
                "C9H16",
                "0.812 g/mL",
                "124.23 g·mol−1",
                "106 °C (223 °F; 379 K)",
                "41 °C (106 °F; 314 K)",
                "Cyclononene adalah Cycloalkene dengan cincin sembilan beranggota, " +
                        "dengan dua kemungkinan isomer geometris",
                image[7]
        );
        alkunaList.add(alkuna);

        alkuna = new Alkuna(
                "Dekuna",
                "C10H18",
                "0.812 g/mL",
                "124.23 g·mol−1",
                "106 °C (223 °F; 379 K)",
                "41 °C (106 °F; 314 K)",
                "Sebuah cairan tidak berwarna dengan bau aromatik, " +
                        "digunakan sebagai pelarut untuk berbagai resin atau aditif bahan bakar",
                image[8]
        );
        alkunaList.add(alkuna);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkuna alkuna = alkunaList.get(position);

//                Toast.makeText(getContext(), alkuna.getName() + " is selected!", Toast.LENGTH_SHORT).show();

                // Send the data to other activity here
                Intent intent = new Intent(getContext(), DescriptionActivity.class);
                intent.putExtra("name", alkuna.getName());
                intent.putExtra("formula", alkuna.getFormula());
                intent.putExtra("density", alkuna.getDensity());
                intent.putExtra("molar", alkuna.getMolar());
                intent.putExtra("boiling", alkuna.getBoiling());
                intent.putExtra("melting", alkuna.getMelting());
                intent.putExtra("example", alkuna.getExample());
                intent.putExtra("image", alkuna.getImage());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
