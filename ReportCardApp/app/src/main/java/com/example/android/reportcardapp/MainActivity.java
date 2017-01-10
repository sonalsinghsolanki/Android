package com.example.android.reportcardapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ReportCard> reportCards = new ArrayList<ReportCard>();
        reportCards.add(new ReportCard("Algebra",92.73,"A-",1.00));
        reportCards.add(new ReportCard("Englis",84,"B",1.00));
        reportCards.add(new ReportCard("Biology",91,"A-",1.00));
        reportCards.add(new ReportCard("Indian History",88,"B+",1.00));
        reportCards.add(new ReportCard("Music",98,"A+",1.00));
        reportCards.add(new ReportCard("Programming",97,"A",1.00));


        ReportCardAdapter adapter = new ReportCardAdapter(this,reportCards);


        ListView listView = (ListView) findViewById(R.id.list) ;


        listView.setAdapter(adapter);

    }
}
