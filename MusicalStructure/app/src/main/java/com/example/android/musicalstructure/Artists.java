package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Artists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        //Opens All Songs activity on button click
        Button allSongsButton = (Button) findViewById(R.id.artists_all_songs);
        allSongsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsBtIntent = new Intent(Artists.this,AllSongs.class);
                startActivity(allSongsBtIntent);
            }
        });
        //Opens Albums activity on button click
        Button albumsButton = (Button) findViewById(R.id.artists_albums);
        albumsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsBtIntent = new Intent(Artists.this,Albums.class);
                startActivity(albumsBtIntent);
            }
        });
        //Opens Genre activity on button click
        Button genreButton = (Button) findViewById(R.id.artists_genre);
        genreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreBtIntent = new Intent(Artists.this,Genre.class);
                startActivity(genreBtIntent);
            }
        });
        //Opens Playlists activity on button click
        Button playlistsButton = (Button) findViewById(R.id.artists_playlist);
        playlistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsBtIntent = new Intent(Artists.this,Playlists.class);
                startActivity(playlistsBtIntent);
            }
        });
        //Opens MyFavorites activity on button click
        Button favoriteButton = (Button) findViewById(R.id.artists_favorites);
        favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent favoritesBtIntent = new Intent(Artists.this,MyFavorites.class);
                startActivity(favoritesBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.artists_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(Artists.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
