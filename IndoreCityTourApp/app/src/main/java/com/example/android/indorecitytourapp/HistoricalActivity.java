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
        places.add(new Places("Rajwada","Rajwada is a historical palace in Indore city." +
                " It was built by the Holkars of the Maratha Empire about two centuries ago",R.drawable.rajwada_placename));
        places.add(new Places("Lal Bagh Palace","Lal Baag Palace was once the resident of the Holkars." +
                " Know more about Lal Bagh Palace in Indore, Madhya Pradesh.",R.drawable.lalbagh_placename));
        places.add(new Places("Gommat Giri","A set of jain temples built on the top of Gommatesher Hill, " +
                "these Jain temples are 24 in number for each of the 24 Tirthankaras.",R.drawable.gommatgiri_placename));
        places.add(new Places("Phooti Kothi","Historical landmark in Indore, India" +
                "· Nawa Bangla, Phooti Kothi.",R.drawable.photikothi_placename));
        places.add(new Places("Rani Sati Gate","Historical landmark in Indore, India",R.drawable.ranisatigate_placename));
        places.add(new Places("Krishna Puri Chhatri","Chhatri Bagh is one of the most popular tourist attractions in Indore, " +
                "which is known for its permanent canopies. These canopies are built in the memory of the royal members of" +
                " the Holkar Dynasty. Each chhatri is built on the burial site of the Holkar king or queen. " +
                "The chhatri primarily comprises a dome shaped cenotaphs with pyramidal spires on the top. " +
                "During night, this park draws attention of numerous tourists," +
                " as the chhatris are illuminated and the fountain at artificial lake starts operating.",R.drawable.chhatribagh_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_numbers);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
}
