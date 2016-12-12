package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Playlists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);
        //Opens All Songs activity on button click
        Button allSongsButton = (Button) findViewById(R.id.playlists_all_songs);
        allSongsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsBtIntent = new Intent(Playlists.this,AllSongs.class);
                startActivity(allSongsBtIntent);
            }
        });
        //Opens Albums activity on button click
        Button albumsButton = (Button) findViewById(R.id.playlists_albums);
        albumsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsBtIntent = new Intent(Playlists.this,Albums.class);
                startActivity(albumsBtIntent);
            }
        });
        //Opens Artists activity on button click
        Button artistsButton = (Button) findViewById(R.id.playlists_artists);
        artistsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsBtIntent = new Intent(Playlists.this,Artists.class);
                startActivity(artistsBtIntent);
            }
        });
        //Opens Genre activity on button click
        Button genreButton = (Button) findViewById(R.id.playlists_genre);
        genreButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreBtIntent = new Intent(Playlists.this,Genre.class);
                startActivity(genreBtIntent);
            }
        });
        //Opens MyFavorites activity on button click
        Button favoriteButton = (Button) findViewById(R.id.playlists_favorites);
        favoriteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent favoritesBtIntent = new Intent(Playlists.this,MyFavorites.class);
                startActivity(favoritesBtIntent);
            }
        });
        //Opens Musical Structure app home page activity on button click
        Button appHomeButton = (Button) findViewById(R.id.playlists_apphome);
        appHomeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent appHomeBtIntent = new Intent(Playlists.this,MainActivity.class);
                startActivity(appHomeBtIntent);
            }
        });
    }
}
