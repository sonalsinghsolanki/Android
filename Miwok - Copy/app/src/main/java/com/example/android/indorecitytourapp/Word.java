package com.example.android.indorecitytourapp;

/**
 * Created by Ashutosh on 12/20/2016.
 */
public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mMediaPlayer;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String miwokTranslation, String defaultTranslation, int imageResourceId,int wordMediaPlayer) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mMediaPlayer = wordMediaPlayer;
    }

    public Word(String defaultTranslation,String miwokTranslation,int wordMediaPlayer) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mMediaPlayer = wordMediaPlayer;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public boolean hasImage(){
    return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getMediaPlayer() {
        return mMediaPlayer;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMediaPlayer=" + mMediaPlayer +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
