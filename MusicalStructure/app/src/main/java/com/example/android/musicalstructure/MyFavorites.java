package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyFavorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorites);
        Button allSongsButton = (Button) findViewById(R.id.favorites_all_songs);
        allSongsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsBtIntent = new Intent(MyFavorites.this,AllSongs.class);
                startActivity(allSongsBtIntent);
            }
        });
        //Opens Albums activity on button click
        Button albumsButton = (Button) findViewById(R.id.favorites_albums);
        albumsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsBtIntent = new Intent(MyFavorites.this,Albums.class);
                startActivity(albumsBtIntent);
            }
        });
        //Opens Artists activity on button click
        Button artistsButton = (Button) findViewById(R.id.favorites_artists);
        artistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsBtIntent = new Intent(MyFavorites.this,Artists.class);
                startActivity(artistsBtIntent);
            }
        });
        //Opens Genre activity on button click
        Button genreButton = (Button) findViewById(R.id.favorites_genre);
        genreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreBtIntent = new Intent(MyFavorites.this,Genre.class);
                startActivity(genreBtIntent);
            }
        });
        //Opens Playlists activity on button click
        Button playlistsButton = (Button) findViewById(R.id.favorites_playlists);
        playlistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsBtIntent = new Intent(MyFavorites.this,Playlists.class);
                startActivity(playlistsBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.favorites_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(MyFavorites.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
