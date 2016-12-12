package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScanMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_media);
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.scan_media_home);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(ScanMedia.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
