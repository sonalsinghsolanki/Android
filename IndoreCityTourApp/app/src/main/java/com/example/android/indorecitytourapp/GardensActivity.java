package com.example.android.indorecitytourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class GardensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create array lists of object places
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getResources().getString(R.string.name_garden_meghdoot),getResources().getString(R.string.descp_meghdoot),R.drawable.meghdootgarden_placename));
        places.add(new Places(getResources().getString(R.string.name_garden_mayank),getResources().getString(R.string.descp_mayankblue),R.drawable.mayankbluewaterpark_placename));
        places.add(new Places(getResources().getString(R.string.name_garden_chhatribagh),getResources().getString(R.string.descp_chatri),R.drawable.chhatribagh_placename));
        places.add(new Places(getResources().getString(R.string.name_garden_atb),getResources().getString(R.string.descp_atb),R.drawable.atalbiharivajpayeeregionalpark_placename));
        places.add(new Places(getResources().getString(R.string.name_garden_krishnapuri),getResources().getString(R.string.descp_krishnapuri),R.drawable.krishnapurichatri_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_history);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}

