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
        places.add(new Places("Meghdoot Garden","Meghdoot Garden is one of the biggest and most beautiful parks in the city. " +
                "It is also oldest gardens in Indore which is still in excellent shape.",R.drawable.meghdootgarden_placename));
        places.add(new Places("Mayank Blue Water Park","Mayank Blue Water Park is one of the best spot to beat the heat over the weekend. " +
                "Some of the slides at this Water Park are extremely cool.",R.drawable.mayankbluewaterpark_placename));
        places.add(new Places("Krishna Puri Chhatri","Krishnapura Chhatris is an important architectural heritage of Indore." +
                " Here are some interesting facts about the chhatris of Indore.",R.drawable.krishnapurichatri_placename));
        places.add(new Places("Chhatri Bagh","Chhatri bagh is as the name suggests filled with such canopies. " +
                "It was built in the remembrance of the Holkar Dynasty.",R.drawable.chhatribagh_placename));
        places.add(new Places("Atal Bihari Vajpayee Regional Park","Regional Park Indore is a park located in Indore, Madhya Pradesh." +
                " The park was developed and created by Indore Development Authority and was opened in 2003.",R.drawable.atalbiharivajpayeeregionalpark_placename));
        //Create a adpater for Places object
        PlacesAdapter adapter = new PlacesAdapter(this,places,R.color.category_history);
        //Create a listview object and assign list id
        ListView listView = (ListView) findViewById(R.id.list) ;
        //Set adapter
        listView.setAdapter(adapter);
    }
  }

