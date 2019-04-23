package com.example.urbanrider;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddRestautants extends AppCompatActivity {

    private Button bt_add_restaurants;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restautants);
        bt_add_restaurants = findViewById(R.id.bt_add_restaurants);
        final CharSequence options[] = new CharSequence[] {"INDIAN Food", "NON-INDIAN Food"};
        builder = new AlertDialog.Builder(this);
        builder.setTitle("Select your option:");
        bt_add_restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // the user clicked on options[which]
                        for(int i=0;i<=which;i++){
                            if(options[i].toString().equalsIgnoreCase("INDIAN Food")){

                            }
                        }
                    }
                });
                builder.setNegativeButton(getString(R.string.dl_cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //the user clicked on Cancel
                    }
                });
                builder.show();
            }
        });
    }
}
