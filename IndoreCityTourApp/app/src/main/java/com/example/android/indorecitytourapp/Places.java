package com.example.android.indorecitytourapp;

/**
 * Created by Ashutosh on 12/20/2016.
 *
 */

public class Places {
    /**
     * @param mPlaceName name of the place of string type
     *  @param mPlaceDescription description of the place of string type
     *   @param mImageResourceId image associated with respective place of int type
     */
    private String mPlaceName;
    private String mPlaceDescription;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Construtor for the places class
     * @param placeName
     * @param placeDescription
     * @param imageResourceId
     */
     public Places(String placeName, String placeDescription, int imageResourceId) {
        mPlaceName = placeName;
        mPlaceDescription = placeDescription;
        mImageResourceId = imageResourceId;
    }
    /**
     * Getter method for ImageResourceId
     * @return mImageResourceId
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Getter method for PlaceName
     * @return mPlaceName
     */
    public String getPlaceName() {
        return mPlaceName;
    }
    /**
     * Getter method for PlaceDescrition
     * @return mPlaceDescription
     */
    public String getPlaceDescription() {
        return mPlaceDescription;
    }
    /**
     * Boolean menthod to check if there is an image
     * @return Static variable
     */
    public boolean hasImage(){
    return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Check object values
     * @return
     */
    @Override
    public String toString() {
        return "Places{" +
                "mPlaceName='" + mPlaceName + '\'' +
                ", mPlaceDescription='" + mPlaceDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
