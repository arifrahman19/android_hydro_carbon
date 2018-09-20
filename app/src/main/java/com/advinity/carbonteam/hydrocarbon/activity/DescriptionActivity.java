package com.advinity.carbonteam.hydrocarbon.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;

public class DescriptionActivity extends AppCompatActivity {

    TextView name, formula, density, molar, boiling, melting, example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        String eName = (String) getIntent().getExtras().get("name");
        collapsingToolbarLayout.setTitle(eName);

        ImageView collapsingImage = (ImageView) findViewById(R.id.collapsing_image);
        Integer eImage = (Integer) getIntent().getExtras().get("image");
        collapsingImage.setImageResource(eImage);

        String eFormula = (String) getIntent().getExtras().get("formula");
        String eDensity = (String) getIntent().getExtras().get("density");
        String eMolar = (String) getIntent().getExtras().get("molar");
        String eBoiling = (String) getIntent().getExtras().get("boiling");
        String eMelting = (String) getIntent().getExtras().get("melting");
        String eExample = (String) getIntent().getExtras().get("example");

        name = (TextView) findViewById(R.id.item_name);
        formula = (TextView) findViewById(R.id.item_formula);
        density = (TextView) findViewById(R.id.item_density);
        molar = (TextView) findViewById(R.id.item_molar);
        boiling = (TextView) findViewById(R.id.item_boiling);
        melting = (TextView) findViewById(R.id.item_melting);
        example = (TextView) findViewById(R.id.item_example);

        name.setText(eName);
        formula.setText(eFormula);
        density.setText(eDensity);
        molar.setText(eMolar);
        boiling.setText(eBoiling);
        melting.setText(eMelting);
        example.setText(eExample);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
