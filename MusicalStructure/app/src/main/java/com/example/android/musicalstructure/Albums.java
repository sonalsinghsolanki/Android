package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Albums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        //Opens All Songs activity on button click
        Button allSongsButton = (Button) findViewById(R.id.albums_all_songs);
        allSongsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsBtIntent = new Intent(Albums.this,AllSongs.class);
                startActivity(allSongsBtIntent);
            }
        });
        //Opens Artists activity on button click
        Button artistsButton = (Button) findViewById(R.id.albums_artists);
        artistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsBtIntent = new Intent(Albums.this,Artists.class);
                startActivity(artistsBtIntent);
            }
        });
        //Opens Genre activity on button click
        Button genreButton = (Button) findViewById(R.id.albums_genre);
        genreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreBtIntent = new Intent(Albums.this,Genre.class);
                startActivity(genreBtIntent);
            }
        });
        //Opens Playlists activity on button click
        Button playlistsButton = (Button) findViewById(R.id.albums_playlist);
        playlistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsBtIntent = new Intent(Albums.this,Playlists.class);
                startActivity(playlistsBtIntent);
            }
        });
        //Opens MyFavorites activity on button click
        Button favoriteButton = (Button) findViewById(R.id.albums_favorites);
        favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent favoritesBtIntent = new Intent(Albums.this,MyFavorites.class);
                startActivity(favoritesBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.albums_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(Albums.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
