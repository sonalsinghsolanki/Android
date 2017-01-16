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

        places.add(new Places("Shri Khajrana Ganesh Temple","Khajrana Ganesh Temple is one of the Famous Hindu Temple." +
                " This Indian Temple is dedicated to Vinayak",R.drawable.khajranaganeshmandir_placename));
        places.add(new Places("Kanch Mandir","The Kanch Mahal is one of the main tourist attractions in Indore." +
                " The Kanch Mandir, as the name suggests, is a temple which is entirely made up of glass and mirrors." +
                " It is primarily a Jain temple and is a wonder in glass.",R.drawable.kanchmandir_placename));
        places.add(new Places("Annapurna Mandir","Annapurna Mandir is a popular temple, which is dedicated to the Goddess Annapurna." +
                " It is one of the famous pilgrimage sites in Indore.",R.drawable.annpurnamandir_placename));
        places.add(new Places("ISKCON","Our Temple invites the public to join us for a day of spirutual " +
                "contemplation.",R.drawable.iskcontemple_placename));
        places.add(new Places("Ranjeet Hanuman Mandir","Hanuman Temple",R.drawable.ranjeethanumanmandir_placename));
        places.add(new Places("Gajanan Maharaj Temple","The Gajanan Maharaj Temples were built to honor Shri Sant Gajanan Maharaj, " +
                "a late-nineteenth–, early-twentieth-century Indian holy man known to many",R.drawable.gambhirbhavan_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_numbers);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
