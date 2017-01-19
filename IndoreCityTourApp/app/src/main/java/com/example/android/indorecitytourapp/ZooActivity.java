package com.example.android.indorecitytourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ZooActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create array lists of object places
        final ArrayList<Places> places = new ArrayList<Places>();

        places.add(new Places(getResources().getString(R.string.name_zoo_kamlanehru),getResources().getString(R.string.descp_kamlanehru),R.drawable.kamlanehruzoo_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_history);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
