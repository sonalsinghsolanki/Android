package com.example.android.indorecitytourapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showHistoricalPlaces(View v) {
        Intent historicalIntent = new Intent(MainActivity.this, HistoricalActivity.class);
        startActivity(historicalIntent);
    }

    public void showMuseum(View v) {
        Intent museumIntent = new Intent(MainActivity.this, MuseumActivity.class);
        startActivity(museumIntent);
    }

    public void showZoo(View v) {
        Intent zooIntent = new Intent(MainActivity.this, ZooActivity.class);
        startActivity(zooIntent);
    }

    public void showGardens(View v) {
        Intent gardensIntent = new Intent(MainActivity.this, GardensActivity.class);
        startActivity(gardensIntent);
    }

    public void showTemples(View v) {
        Intent templesIntent = new Intent(MainActivity.this, TemplesActivity.class);
        startActivity(templesIntent);
    }
}





