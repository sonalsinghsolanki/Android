package com.example.android.indorecitytourapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TemplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create array lists of object places
        final ArrayList<Places> places = new ArrayList<Places>();

        places.add(new Places(getResources().getString(R.string.name_temple_khajrana),getResources().getString(R.string.descp_khajrana),R.drawable.khajranaganeshmandir_placename));
        places.add(new Places(getResources().getString(R.string.name_temple_kanch),getResources().getString(R.string.descp_kanchtemple),R.drawable.kanchmandir_placename));
        places.add(new Places(getResources().getString(R.string.name_temple_annpurna),getResources().getString(R.string.descp_annpurna),R.drawable.annpurnamandir_placename));
        places.add(new Places(getResources().getString(R.string.name_temple_iskon),getResources().getString(R.string.descp_iskon),R.drawable.iskcontemple_placename));
        places.add(new Places(getResources().getString(R.string.name_temple_ranjeet),getResources().getString(R.string.descp_ranjeet),R.drawable.ranjeethanumanmandir_placename));
        places.add(new Places(getResources().getString(R.string.name_temple_gajana),getResources().getString(R.string.descp_gajanan),R.drawable.gambhirbhavan_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_history);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
