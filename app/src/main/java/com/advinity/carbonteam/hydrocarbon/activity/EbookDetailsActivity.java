package com.advinity.carbonteam.hydrocarbon.activity;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.other.FileDownloader;

import java.io.File;
import java.io.IOException;

public class EbookDetailsActivity extends AppCompatActivity {

    private DownloadManager dm;
    private TextView title, subtitle, writer, edition, year, description;
    private FloatingActionButton fab;
    private DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        final String eTitle = (String) getIntent().getExtras().get("title");
        collapsingToolbarLayout.setTitle(eTitle);

        ImageView collapsingImage = (ImageView) findViewById(R.id.collapsing_image);
        Integer eImage = (Integer) getIntent().getExtras().get("image");
        collapsingImage.setImageResource(eImage);

        String eSubtitle = (String) getIntent().getExtras().get("subtitle");
        String eWriter = (String) getIntent().getExtras().get("writer");
        String eEdition = (String) getIntent().getExtras().get("edition");
        String eYear = (String) getIntent().getExtras().get("year");
        String eDescription = (String) getIntent().getExtras().get("description");
        final String eUrl = (String) getIntent().getExtras().get("url");

        title = (TextView) findViewById(R.id.item_ebook_title);
        subtitle = (TextView) findViewById(R.id.item_ebook_subtitle);
        writer = (TextView) findViewById(R.id.item_ebook_writer);
        edition = (TextView) findViewById(R.id.item_ebook_edition);
        year = (TextView) findViewById(R.id.item_ebook_year);
        description = (TextView) findViewById(R.id.item_ebook_description);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read or Download
                viewDocument(eUrl);
            }
        });

        title.setText(eTitle);
        subtitle.setText(eSubtitle);
        writer.setText(eWriter);
        edition.setText(eEdition);
        year.setText(eYear);
        description.setText(eDescription);
    }

    public void viewDocument(String fileUrl) {
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(Uri.parse(fileUrl), "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(EbookDetailsActivity.this, "Tidak ada aplikasi untuk membuka PDF file", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
