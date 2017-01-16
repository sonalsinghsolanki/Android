package com.example.android.indorecitytourapp;

/**
 * Created by Ashutosh on 12/20/2016.
 */
public class Places {
    private String mPlaceName;
    private String mPlaceDescription;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Places(String placeName, String placeDescription, int imageResourceId) {
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
        mImageResourceId = imageResourceId;
    }

   /* public Places(String placeName, String placeDescription) {
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
    }*/

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public String getPlaceDescription() {
        return mPlaceDescription;
    }

    public boolean hasImage(){
    return mImageResourceId != NO_IMAGE_PROVIDED;
    }


    @Override
    public String toString() {
        return "Places{" +
                "mPlaceName='" + mPlaceName + '\'' +
                ", mPlaceDescription='" + mPlaceDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
