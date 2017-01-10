package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //Create an array of variable name words
        /*String[] words = new String[10];
        words[0] = "One";
        words[1] = "Two";
        words[2] = "Three";
        words[3] = "Four";
        words[4] = "Five";
        words[5] = "Six";
        words[6] = "Seven";
        words[7] = "Eight";
        words[8] = "Nine";
        words[9] = "Ten";
        Log.v("NumberActivity","Word at index[0] : "+words[0]);
        Log.v("NumberActivity","Word at index[1] : "+words[1]);*/
        //Create an arrayLists for object name words

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","oyysia",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);

       // ListView listView = (ListView) findViewById(R.id.list);
       // GridView gridView = (GridView)findViewById(R.id.grid) ;
        ListView listView = (ListView) findViewById(R.id.list) ;

        //gridView.setAdapter(itemsAdapter);
        listView.setAdapter(adapter);

        //set onclicklistner to play audio files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
               Word word = words.get(position);
               mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getMediaPlayer());
                mMediaPlayer.start();

            }
        });
        /*Log.v("NumberActivity","Word at index[0] : "+words.get(0));
        Log.v("NumberActivity","Word at index[1] : "+words.get(1));*/
        //Find the rootview for the layout to add text view
        //LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        //setup the counter variable
       /* int index = 0;
        while(index < 10) {
            //create a textview and add to rootview
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
            //update the counter variable
            index ++;
        }*/
        /*for(int index =0;index < 10;index++){
            //create a textview and add to rootview
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }*/
    }
}
