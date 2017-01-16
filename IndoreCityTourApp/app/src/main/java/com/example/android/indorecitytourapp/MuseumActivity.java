package com.example.android.indorecitytourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create array lists of object places
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places("Indore Museam","Central Museum in Indore is of great significance historically." +
                " Know more about Indore Museum of India.",R.drawable.indoremuseum_placename));
        places.add(new Places("Lal Bagh Museum","Lal Bagh Museum is a palace/museum located in the city of Indore, Madya Pradesh. " +
                "Lal Bhag Museum entails the conservation and restoration of a late ...",R.drawable.lalbaghmuseum_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_numbers);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
