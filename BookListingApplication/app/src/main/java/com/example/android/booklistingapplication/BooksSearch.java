package com.example.android.booklistingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ashutosh on 2/20/2017.
 */
public class BooksSearch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void search(View v) {
        TextView txt_search = (TextView)findViewById(R.id.text_search);
        String str_search = txt_search.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        //Create the bundle
        Bundle bundle = new Bundle();
        //Add your data to bundle
        bundle.putString("search",str_search);
        //Add the bundle to the intent
        i.putExtras(bundle);
        //Fire that second activity
        startActivity(i);
    }
}