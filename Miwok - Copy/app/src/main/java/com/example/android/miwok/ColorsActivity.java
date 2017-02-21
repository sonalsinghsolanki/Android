package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     +     * This listener gets triggered when the {@link MediaPlayer} has completed
     +     * playing the audio file.
     +     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {

        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //Create an arrayLists for object nameword
       final ArrayList<Word> words = new ArrayList<Word>();
       words.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
       words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
       words.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
       words.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
       words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
       words.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
       words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
       words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

       WordAdapter adapter =new WordAdapter(this,words,R.color.category_colors);


        ListView listView = (ListView) findViewById(R.id.list) ;

        //gridView.setAdapter(itemsAdapter);
        listView.setAdapter(adapter);
        //set onclicklistner to play audio files
        //set onclicklistner to play audio files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                releaseMediaPlayer();
                Word word = words.get(position);
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMediaPlayer());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            // Abandon audio focus when playback complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
