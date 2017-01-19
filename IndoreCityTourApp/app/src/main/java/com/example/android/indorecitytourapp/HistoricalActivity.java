package com.example.android.indorecitytourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create array lists of object places
        final ArrayList<Places> places = new ArrayList<Places>();
        places.add(new Places(getResources().getString(R.string.name_historical_rajwada),getResources().getString(R.string.descp_rajwada),R.drawable.meghdootgarden_placename));
        places.add(new Places(getResources().getString(R.string.name_historical_lalbagh),getResources().getString(R.string.descp_lalbagh),R.drawable.lalbagh_placename));
        places.add(new Places(getResources().getString(R.string.name_historical_gommat),getResources().getString(R.string.descp_gommatgiri),R.drawable.gommatgiri_placename));
        places.add(new Places(getResources().getString(R.string.name_historical_phootikothi),getResources().getString(R.string.descp_phootikothi),R.drawable.photikothi_placename));
        places.add(new Places(getResources().getString(R.string.name_historical_ranisatigate),getResources().getString(R.string.descp_ranisatigate),R.drawable.ranisatigate_placename));
        places.add(new Places(getResources().getString(R.string.name_historical_krsihnapuri),getResources().getString(R.string.descp_krishnapuri),R.drawable.krishnapurichatri_placename));//Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_history);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
