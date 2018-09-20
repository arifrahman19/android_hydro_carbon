package com.advinity.carbonteam.hydrocarbon.fragment.Tutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import org.jetbrains.annotations.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.activity.DescriptionActivity;
import com.advinity.carbonteam.hydrocarbon.adapter.AlkenaAdapter;
import com.advinity.carbonteam.hydrocarbon.modal.Alkena;
import com.advinity.carbonteam.hydrocarbon.other.ClickListener;
import com.advinity.carbonteam.hydrocarbon.other.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlkenaFragment extends Fragment {

    private List<Alkena> alkenaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AlkenaAdapter mAdapter;

    public AlkenaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alkena, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.alkena_recycleview);

        mAdapter = new AlkenaAdapter(alkenaList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareAlkenaData();
        
        return view;
    }

    private void prepareAlkenaData() {

        int[] image = new int[]{
                R.drawable.alkena_metena,
                R.drawable.alkena_propena,
                R.drawable.alkena_butena,
                R.drawable.alkena_pentena,
                R.drawable.alkena_heksena,
                R.drawable.alkena_heptena,
                R.drawable.alkena_oktena,
                R.drawable.alkena_nonena,
                R.drawable.alkena_dekena
        };

        Alkena alkena = new Alkena(
                "Etena",
                "C2H4",
                "1.178 kg/m³ (la 15 °C)",
                "28.05 g/mol",
                "−103.7 °C",
                "−169,2 °C",
                "Etena digunakan terutama sebagai senyawa antara pada produksi senyawa kimia lain seperti plastik\n" +
                        "Etena juga dibentuk secara alami oleh tumbuhan dan berperan sebagai hormon",
                image[0]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Propena",
                "C3H6",
                "1.81 kg/m³ (la 15 °C)",
                "42.08 g/mol",
                "−47.6 °C",
                "−185.2 °C",
                "Merupakan senyawa alkena paling sederhana kedua setelah etena",
                image[1]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Butena",
                "C4H8",
                "0.62 g/cm³",
                "56.11 g·mol−1",
                "−6.47 °C (20.35 °F; 266.68 K)",
                "−185.3 °C (−301.5 °F; 87.8 K)",
                "Berbentuk gas tak berwarna yang terdapat dalam minyak bumi sebagai konstituen minor " +
                        "sehingga terlalu kecil untuk diekstraksi dengan layak",
                image[2]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Pentena",
                "C5H10",
                "0.626 g·mL−1",
                "72.15 g·mol−1",
                "35.9 to 36.3 °C\n" +
                        "96.5 to 97.3 °F\n" +
                        "309.0 to 309.4 K",
                "−130.5 to −129.1 °C\n" +
                        "−202.8 to −200.3 °F\n" +
                        "142.7 to 144.1 K",
                "Tidak larut dalam air dan kurang padat daripada air. " +
                        "Oleh karena itu mengapung di atas air. Uap yang mudah terbakar yang dihasilkan",
                image[3]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Heksena",
                "C6H12",
                "0.6548 g·mL−1",
                "86.18 g·mol−1",
                "68.5 to 69.1 °C\n" +
                        "155.2 to 156.3 °F\n" +
                        "341.6 to 342.2 K",
                "−96 to −94 °C\n" +
                        "−141 to −137 °F\n" +
                        "177 to 179 K",
                "Ada beberapa isomer dari heksena, tergantung pada posisi dan geometri ikatan ganda dalam rantai. " +
                        "Salah satu yang paling umum isomer industri yang berguna adalah 1-heksena, alpha-olefin \n",
                image[4]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Heptena",
                "C7H14",
                "0.6795 g·cm−3",
                "100.21 g·mol−1",
                "98.38 °C (209.08 °F; 371.53 K)",
                "−90.549 °C (−130.988 °F; 182.601 K)",
                "Hal ini digunakan sebagai aditif dalam pelumas, sebagai katalis, dan sebagai surfaktan. " +
                        "Kimia ini juga dikenal sebagai heptylene",
                image[5]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Oktena",
                "C8H16",
                "0.703 g·cm−3",
                "114.23 g·mol−1",
                "125.1 to 126.1 °C\n" +
                        "257.1 to 258.9 °F\n" +
                        "398.2 to 399.2 K",
                "−57.1 to −56.6 °C\n" +
                        "−70.9 to −69.8 °F\n" +
                        "216.0 to 216.6 K",
                "Octene adalah alkena dengan rumus C8H16. Beberapa isomer dari octene diketahui, " +
                        "tergantung pada posisi dan geometri ikatan ganda dalam rantai karbon",
                image[6]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Nonena",
                "C9H18",
                "718 mg·mL−1",
                "128.26 g·mol−1",
                "150.4 to 151.0 °C\n" +
                        "302.6 to 303.7 °F\n" +
                        "423.5 to 424.1 K",
                "−54.1 to −53.1 °C\n" +
                        "−65.5 to −63.7 °F\n" +
                        "219.0 to 220.0 K",
                "Campuran ini nonenes bercabang digunakan dalam alkilasi fenol untuk menghasilkan nonilfenol, " +
                        "pendahulu untuk deterjen, yang juga polutan kontroversial",
                image[7]
        );
        alkenaList.add(alkena);

        alkena = new Alkena(
                "Dekena",
                "C10H20",
                "0.730 g·mL−1",
                "142.29 g·mol−1",
                "173.8 to 174.4 °C\n" +
                        "344.7 to 345.8 °F\n" +
                        "446.9 to 447.5 K",
                "−30.5 to −29.2 °C\n" +
                        "−22.8 to −20.6 °F\n" +
                        "242.7 to 243.9 K",
                "Decene telah diisolasi dari daun dan rimpang dari tanaman Farfugium japonicum dan " +
                        "telah terdeteksi sebagai produk awal dalam degradasi mikroba n-dekana",
                image[8]
        );
        alkenaList.add(alkena);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Alkena alkena = alkenaList.get(position);

//                Toast.makeText(getContext(), alkena.getName() + " is selected!", Toast.LENGTH_SHORT).show();

                // Send the data to other activity here
                Intent intent = new Intent(getContext(), DescriptionActivity.class);
                intent.putExtra("name", alkena.getName());
                intent.putExtra("formula", alkena.getFormula());
                intent.putExtra("density", alkena.getDensity());
                intent.putExtra("molar", alkena.getMolar());
                intent.putExtra("boiling", alkena.getBoiling());
                intent.putExtra("melting", alkena.getMelting());
                intent.putExtra("example", alkena.getExample());
                intent.putExtra("image", alkena.getImage());

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
