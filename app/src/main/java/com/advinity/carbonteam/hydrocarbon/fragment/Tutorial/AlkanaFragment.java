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
import com.advinity.carbonteam.hydrocarbon.adapter.AlkanaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkana;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkanaFragment extends Fragment {

    private List<Alkana> alkanaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkanaAdapter mAdapter;

    public AlkanaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkana, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkana_recycleview);

        mAdapter = new AlkanaAdapter(alkanaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkanaData();

        return view;
    }

    private void prepareAlkanaData() {

        int[] image = new int[]{
                R.drawable.alkana_metana,
                R.drawable.alkana_etana,
                R.drawable.alkana_propana,
                R.drawable.alkana_butana,
                R.drawable.alkana_pentana,
                R.drawable.alkana_heksana,
                R.drawable.alkana_heptana,
                R.drawable.alkana_oktana,
                R.drawable.alkana_nonana,
                R.drawable.alkana_dekana
        };

        Alkana alkana = new Alkana(
                "Metana",
                "CH4",
                "0.626 g·mL−1",
                "72.15 g·mol−1",
                "-",
                "-",
                "Gas rumah kaca",
                image[0]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Etana",
                "C2H6",
                "1.212 kg/m³, Gas",
                "30.07 g/mol",
                "-88.6 °C (184.5 K)",
                "182.76 °C (90.34 K)",
                "Sebagai hasil sampingan penyulingan minyak",
                image[1]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Propana",
                "C3H8",
                "2.0098 mg·mL−1 (0 °C, 101.3 kPa)",
                "44.1 g·mol−1",
                "-",
                "-",
                "Sebagai bahan bakar untuk mesin\n" +
                        "Barbeque (pemanggang)\n" +
                        "Dan alat rumah tangga lain",
                image[2]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Butana",
                "C4H10",
                "2.48 kg/m³, Gas (15 °C, 1 atm)\n" +
                        "600 kg/m³, Liquid (0 °C, 1 atm)",
                "58.12 g·mol−1",
                "−0.5 °C (272.6 K)",
                "-138.4 °C (135.4 K)",
                "Butana sangat mudah terbakar\n" +
                        "Tidak berwarna\n" +
                        "merupakan gas yang mudah dicairkan",
                image[3]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Pentana",
                "C5H12",
                "0.626 g/mL, Liquid",
                "72.15 g/mol",
                "0.626 g/mL, Liquid\n" +
                        "36.1 °C (308 K)",
                "-129.8 °C (143 K)",
                "Digunakan sebagai campuran bahan bakar\n" +
                        "Sebagai bahan pelarut di laboratorium",
                image[4]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Heksana",
                "C6H14",
                "0.6548 g/mL",
                "86.18 g·mol−1",
                "-",
                "-",
                "Umumnya terdapat pada bensin\n" +
                        "Lem sepatu kulit dan tekstil.\n\n" +
                        "Dalam keadaan standar senyawa ini merupakan cairan tak berwarna yang tidak larut dalam air",
                image[5]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Heptana",
                "C7H16",
                "0.684 g/ml, Liquid",
                "100.21 g/mol",
                "-",
                "-90.61 °C (182.55 K)",
                "Digunakan sebagai campuran bahan bakar pada mesin tes anti-ketukan, " +
                        "bahan bakar yang mengandung 100% heptana mempunyai angka oktan sebesar nol " +
                        "(angka oktan 100 adalah bensin yang mengandung 100% iso-oktana)",
                image[6]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Oktana",
                "C8H18",
                "0.703 g/mL",
                "114.23 g·mol−1",
                "-",
                "-",
                "Komponen utama pada bensin dan digunakan pada penghitungan bilangan oktan",
                image[7]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Nonana",
                "C9H20",
                "0.718 g/ml, Liquid",
                "128.2 g/mol",
                "151 °C (424 K)",
                "-53 °C (220 K)",
                "-",
                image[8]
        );
        alkanaList.add(alkana);

        alkana = new Alkana(
                "Dekana",
                "C10H22",
                "0.73 g/ml, Liquid",
                "142.29 g/mol",
                "174.1 °C (446.9 K)",
                "-27,9 °C (245,25 K)",
                "Dekana merupakan salah satu komponen pada bensin",
                image[9]
        );
        alkanaList.add(alkana);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkana alkana = alkanaList.get(position);

//                Toast.makeText(getContext(), alkana.getName() + " is selected!", Toast.LENGTH_SHORT).show();

                // Send the data to other activity here
                Intent intent = new Intent(getContext(), DescriptionActivity.class);
                intent.putExtra("name", alkana.getName());
                intent.putExtra("formula", alkana.getFormula());
                intent.putExtra("density", alkana.getDensity());
                intent.putExtra("molar", alkana.getMolar());
                intent.putExtra("boiling", alkana.getBoiling());
                intent.putExtra("melting", alkana.getMelting());
                intent.putExtra("example", alkana.getExample());
                intent.putExtra("image", alkana.getImage());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
