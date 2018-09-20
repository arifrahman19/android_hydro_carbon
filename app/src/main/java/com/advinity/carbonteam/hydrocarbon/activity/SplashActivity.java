package com.advinity.carbonteam.hydrocarbon.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.advinity.carbonteam.hydrocarbon.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, DrawerActivity.class));
                    finish();
                }
            }
        };

        thread.start();
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
