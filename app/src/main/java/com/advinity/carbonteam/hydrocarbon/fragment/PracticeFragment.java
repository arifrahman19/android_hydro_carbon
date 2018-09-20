package com.advinity.carbonteam.hydrocarbon.fragment;


import android.content.ClipData;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PracticeFragment extends Fragment {

    private List<Practice> practiceList = new ArrayList<>();
    private Integer SUM = 0;

    private TextView dropView1, dropView2, dropView3, dropView4, dropView5, dropView6, dropView7, dropView8, dropView9, dropView10;
    private TextView dropView11, dropView12, dropView13, dropView14, dropView15, dropView16, dropView17, dropView18, dropView19, dropView20;
    private TextView dropView21, dropView22, dropView23, dropView24, dropView25, dropView26, dropView27, dropView28, dropView29, dropView30;
    private TextView dropView31, dropView32, dropView33, dropView34, dropView35, dropView36, dropView37, dropView38, dropView39, dropView40;
    private TextView dropView41, dropView42, dropView43, dropView44, dropView45;

    private List<TextView> drags;
    private List<TextView> drops;

    public PracticeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_practice, container, false);

        TextView dragViewC = (TextView) view.findViewById(R.id.drag_c);
        TextView dragViewH = (TextView) view.findViewById(R.id.drag_h);
        TextView dragView1 = (TextView) view.findViewById(R.id.drag_1);
        TextView dragView2 = (TextView) view.findViewById(R.id.drag_2);
        TextView dragView3 = (TextView) view.findViewById(R.id.drag_3);
        TextView dragView4 = (TextView) view.findViewById(R.id.drag_4);
        TextView dragView5 = (TextView) view.findViewById(R.id.drag_5);

        dropView1 = (TextView) view.findViewById(R.id.drop_1);
        dropView2 = (TextView) view.findViewById(R.id.drop_2);
        dropView3 = (TextView) view.findViewById(R.id.drop_3);
        dropView4 = (TextView) view.findViewById(R.id.drop_4);
        dropView5 = (TextView) view.findViewById(R.id.drop_5);
        dropView6 = (TextView) view.findViewById(R.id.drop_6);
        dropView7 = (TextView) view.findViewById(R.id.drop_7);
        dropView8 = (TextView) view.findViewById(R.id.drop_8);
        dropView9 = (TextView) view.findViewById(R.id.drop_9);
        dropView10 = (TextView) view.findViewById(R.id.drop_10);
        dropView11 = (TextView) view.findViewById(R.id.drop_11);
        dropView12 = (TextView) view.findViewById(R.id.drop_12);
        dropView13 = (TextView) view.findViewById(R.id.drop_13);
        dropView14 = (TextView) view.findViewById(R.id.drop_14);
        dropView15 = (TextView) view.findViewById(R.id.drop_15);
        dropView16 = (TextView) view.findViewById(R.id.drop_16);
        dropView17 = (TextView) view.findViewById(R.id.drop_17);
        dropView18 = (TextView) view.findViewById(R.id.drop_18);
        dropView19 = (TextView) view.findViewById(R.id.drop_19);
        dropView20 = (TextView) view.findViewById(R.id.drop_20);
        dropView21 = (TextView) view.findViewById(R.id.drop_21);
        dropView22 = (TextView) view.findViewById(R.id.drop_22);
        dropView23 = (TextView) view.findViewById(R.id.drop_23);
        dropView24 = (TextView) view.findViewById(R.id.drop_24);
        dropView25 = (TextView) view.findViewById(R.id.drop_25);
        dropView26 = (TextView) view.findViewById(R.id.drop_26);
        dropView27 = (TextView) view.findViewById(R.id.drop_27);
        dropView28 = (TextView) view.findViewById(R.id.drop_28);
        dropView29 = (TextView) view.findViewById(R.id.drop_29);
        dropView30 = (TextView) view.findViewById(R.id.drop_30);
        dropView31 = (TextView) view.findViewById(R.id.drop_31);
        dropView32 = (TextView) view.findViewById(R.id.drop_32);
        dropView33 = (TextView) view.findViewById(R.id.drop_33);
        dropView34 = (TextView) view.findViewById(R.id.drop_34);
        dropView35 = (TextView) view.findViewById(R.id.drop_35);
        dropView36 = (TextView) view.findViewById(R.id.drop_36);
        dropView37 = (TextView) view.findViewById(R.id.drop_37);
        dropView38 = (TextView) view.findViewById(R.id.drop_38);
        dropView39 = (TextView) view.findViewById(R.id.drop_39);
        dropView40 = (TextView) view.findViewById(R.id.drop_40);
        dropView41 = (TextView) view.findViewById(R.id.drop_41);
        dropView42 = (TextView) view.findViewById(R.id.drop_42);
        dropView43 = (TextView) view.findViewById(R.id.drop_43);
        dropView44 = (TextView) view.findViewById(R.id.drop_44);
        dropView45 = (TextView) view.findViewById(R.id.drop_45);

        final Button cek = (Button) view.findViewById(R.id.btn_cek);

        drags = asList(
                dragViewC,
                dragViewH,
                dragView1,
                dragView2,
                dragView3,
                dragView4,
                dragView5
        );

        drops = asList(
                dropView1,
                dropView2,
                dropView3,
                dropView4,
                dropView5,
                dropView6,
                dropView7,
                dropView8,
                dropView9,
                dropView10,
                dropView11,
                dropView12,
                dropView13,
                dropView14,
                dropView15,
                dropView16,
                dropView17,
                dropView18,
                dropView19,
                dropView20,
                dropView21,
                dropView22,
                dropView23,
                dropView24,
                dropView25,
                dropView26,
                dropView27,
                dropView28,
                dropView29,
                dropView30,
                dropView31,
                dropView32,
                dropView33,
                dropView34,
                dropView35,
                dropView36,
                dropView37,
                dropView38,
                dropView39,
                dropView40,
                dropView41,
                dropView42,
                dropView43,
                dropView44,
                dropView45
        );

        preparePracticeData();

        for (final TextView drag : drags) {
            drag.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    view.startDrag(ClipData.newPlainText("DRAG", drag.getText()), new DragShadow(view), view, 0);
                    return true;
                }
            });
        }

        for (final TextView drop : drops) {
            drop.setOnDragListener(new View.OnDragListener() {
                @Override
                public boolean onDrag(View view, DragEvent dragEvent) {
                    int action = dragEvent.getAction();
                    switch (action) {
                        case DragEvent.ACTION_DROP:
                            TextView targetTextView = (TextView) view;
                            TextView droppedTextView = (TextView) dragEvent.getLocalState();
                            targetTextView.setText(droppedTextView.getText());
                            return true;
                    }

                    return true;
                }
            });
        }

        cek.setOnClickListener(new View.OnClickListener() {
            private boolean isCorrect = false;

            @Override
            public void onClick(View view) {
                for (final TextView drop : drops) {
                    if (drop.getText().equals("C"))
                        SUM += 4;
                    else if (drop.getText().equals("H"))
                        SUM += 1;
                    else if (drop.getText().equals("−"))
                        SUM += 6;
                    else if (drop.getText().equals("="))
                        SUM += 7;
                    else if (drop.getText().equals("≡"))
                        SUM += 8;
                    else if (drop.getText().equals("∣"))
                        SUM += 9;
                }

                for (int i = 0; i < practiceList.size(); i++) {
                    Practice practice = practiceList.get(i);

                    if (SUM == practice.getIndex()) {
                        new AlertDialog.Builder(getContext())
                                .setTitle(practice.getName())
                                .setMessage("Rumus molekul : " + practice.getFormula() + "\n\nDeskripsi singkat :\n" + practice.getOther())
                                .setCancelable(false)
                                .setNegativeButton("Tutup", null)
                                .show();

                        isCorrect = true;
                        break;
                    }
                }

                if (isCorrect == false)
                    Toast.makeText(getContext(), "Rangkaian tidak ditemukan. Coba lagi!", Toast.LENGTH_SHORT).show();

                isCorrect = false;
                SUM = 0;
            }
        });

        return view;
    }

    static class DragShadow extends View.DragShadowBuilder {
        private View view;

        public DragShadow(View view) {
            super(view);
            this.view = view;
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            View view = getView();

            shadowSize.set(view.getWidth(), view.getHeight());
            shadowTouchPoint.set(view.getWidth()/2, view.getHeight()/2);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            view.draw(canvas);
        }
    }

    private void preparePracticeData() {
        Practice practice = new Practice(
                38,
                "Metana",
                "CH4",
                "Gas rumah kaca"
        );
        practiceList.add(practice);

        practice = new Practice(
                68,
                "Etana",
                "C2H6",
                "Sebagai hasil penyulingan minyak"
        );
        practiceList.add(practice);

        practice = new Practice(
                98,
                "Propana",
                "C3H8",
                "Sebagai bahan bakar untuk mesin Barbeque (pemanggang) dan alat rumah tangga lain"
        );
        practiceList.add(practice);

        practice = new Practice(
                49,
                "Etena",
                "C2H4",
                "Senyawa antara pada produksi senyawa ilmiah lain, seperti plastik. Etena dibentuk secara alami " +
                        "oleh tumbuhan dan berperan sebagai hormon."
        );
        practiceList.add(practice);

        practice = new Practice(
                79,
                "Propena",
                "C3H6",
                "Merupakan senyawwa alkena paling sederhana kedua setelah etena."
        );
        practiceList.add(practice);

        practice = new Practice(
                30,
                "Etuna",
                "C2H2",
                "Asetilena merupakan alkuna paling sederhana, karena hanya terdiri dari dua atom karbon " +
                        "dan dua atom hidrogen."
        );
        practiceList.add(practice);

        practice = new Practice(
                60,
                "Propuna",
                "C3H4",
                "Alkuna ini merupakan komponen gas MAPP, yang biasa digunakan dalam las karbit."
        );
        practiceList.add(practice);

    }

}
