package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AllSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);
        //Opens Albums activity on button click
        Button albumButton = (Button) findViewById(R.id.allsongs_album);
        albumButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumBtIntent = new Intent(AllSongs.this,Albums.class);
                startActivity(albumBtIntent);
            }
        });
        //Opens Artists activity on button click
        Button artistsButton = (Button) findViewById(R.id.allsongs_artists);
        artistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsBtIntent = new Intent(AllSongs.this,Artists.class);
                startActivity(artistsBtIntent);
            }
        });
        //Opens Genre activity on button click
        Button genreButton = (Button) findViewById(R.id.allsongs_genre);
        genreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreBtIntent = new Intent(AllSongs.this,Genre.class);
                startActivity(genreBtIntent);
            }
        });
        //Opens Playlists activity on button click
        Button playlistsButton = (Button) findViewById(R.id.allsongs_playlist);
        playlistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsBtIntent = new Intent(AllSongs.this,Playlists.class);
                startActivity(playlistsBtIntent);
            }
        });
        //Opens MyFavorites activity on button click
        Button favoriteButton = (Button) findViewById(R.id.allsongs_favorites);
        favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent favoritesBtIntent = new Intent(AllSongs.this,MyFavorites.class);
                startActivity(favoritesBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.allsongs_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(AllSongs.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
