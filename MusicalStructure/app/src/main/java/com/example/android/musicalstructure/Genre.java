package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Genre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        //Opens All Songs activity on button click
        Button allSongsButton = (Button) findViewById(R.id.genre_all_songs);
        allSongsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsBtIntent = new Intent(Genre.this,AllSongs.class);
                startActivity(allSongsBtIntent);
            }
        });
        //Opens Albums activity on button click
        Button albumsButton = (Button) findViewById(R.id.genre_albums);
        albumsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsBtIntent = new Intent(Genre.this,Albums.class);
                startActivity(albumsBtIntent);
            }
        });
        //Opens Artists activity on button click
        Button artistsButton = (Button) findViewById(R.id.genre_artists);
        artistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsBtIntent = new Intent(Genre.this,Artists.class);
                startActivity(artistsBtIntent);
            }
        });
        //Opens Playlists activity on button click
        Button playlistsButton = (Button) findViewById(R.id.genre_playlist);
        playlistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsBtIntent = new Intent(Genre.this,Playlists.class);
                startActivity(playlistsBtIntent);
            }
        });
        //Opens MyFavorites activity on button click
        Button favoriteButton = (Button) findViewById(R.id.genre_favorites);
        favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent favoritesBtIntent = new Intent(Genre.this,MyFavorites.class);
                startActivity(favoritesBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.genre_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(Genre.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
