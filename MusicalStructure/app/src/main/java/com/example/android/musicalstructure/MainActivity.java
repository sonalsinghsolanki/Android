package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Opens Al Songs activity on click
        TextView allSongs = (TextView) findViewById(R.id.all_songs);
        allSongs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent allSongsIntent = new Intent(MainActivity.this,AllSongs.class);
                startActivity(allSongsIntent);
            }
        });
        //Opens Albums activity on click
        TextView albums = (TextView) findViewById(R.id.albums);
        albums.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent albumsIntent = new Intent(MainActivity.this,Albums.class);
                startActivity(albumsIntent);
            }
        });
        //Opens Artists activity on click
        TextView artists = (TextView) findViewById(R.id.artists);
        artists.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent artistsIntent = new Intent(MainActivity.this,Artists.class);
                startActivity(artistsIntent);
            }
        });
        //Opens Genre activity on click
        TextView genre = (TextView) findViewById(R.id.genre);
        genre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent genreIntent = new Intent(MainActivity.this,Genre.class);
                startActivity(genreIntent);
            }
        });
        //Opens Scan Media activity on click
        TextView scanMedia = (TextView) findViewById(R.id.scanMedia);
        scanMedia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent scanMediaIntent = new Intent(MainActivity.this,ScanMedia.class);
                startActivity(scanMediaIntent);
            }
        });
        //Opens Playlists activity on click
        TextView playlists = (TextView) findViewById(R.id.playlists);
        playlists.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent playlistsIntent = new Intent(MainActivity.this,Playlists.class);
                startActivity(playlistsIntent);
            }
        });
        //Opens My Favorites activity on click
        TextView myFavorites = (TextView) findViewById(R.id.favorites);
        myFavorites.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent myFavoritesIntent = new Intent(MainActivity.this,MyFavorites.class);
                startActivity(myFavoritesIntent);
            }
        });
    }
}
