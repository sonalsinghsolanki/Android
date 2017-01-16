package com.example.android.indorecitytourapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        //Set listener for Historical category
        TextView visitHistorical = (TextView) findViewById(R.id.visit_historical);
        visitHistorical.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent historicalIntent = new Intent(MainActivity.this,HistoricalActivity.class);
                startActivity(historicalIntent);
            }
        });
        //Set listener for Museum category
        TextView visitMuseum = (TextView) findViewById(R.id.visit_museum);
        visitMuseum.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent museumIntent = new Intent(MainActivity.this,MuseumActivity.class);
                startActivity(museumIntent);
            }
        });
        //Set listener for Zoo category
        TextView visitZoo = (TextView) findViewById(R.id.visit_zoo);
        visitZoo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent zooIntent = new Intent(MainActivity.this,ZooActivity.class);
                startActivity(zooIntent);
            }
        });
        //Set listener for garden category
        TextView visitGardens = (TextView) findViewById(R.id.visit_gardens);
        visitGardens.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent gardensIntent = new Intent(MainActivity.this,GardensActivity.class);
                startActivity(gardensIntent);
            }
        });
        //Set listener for temples category
        TextView visitTemples = (TextView) findViewById(R.id.visit_temples);
        visitTemples.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent templesIntent = new Intent(MainActivity.this,TemplesActivity.class);
                startActivity(templesIntent);
            }
        });
    }
}
