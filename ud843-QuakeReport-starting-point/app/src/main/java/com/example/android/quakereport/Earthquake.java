package com.example.android.quakereport;

/**
 * Created by Sonal on 1/31/2017.
 *
 */
/**
 * {@link Earthquake} represents earthquake occurred at a place
 * Each object has 3 properties: place,magnitude and date;
 */
public class Earthquake {
    //Name of place where earthquake occurred
    private String mPlace;
    //Magnitude of the occurred earthquake
    private double mMagnitude;
    //Date on which earthquake occurred
    private long mDate;

    public String getURL() {
        return mURL;
    }

    public void setURL(String URL) {
        mURL = URL;
    }

    //URL of the earthquake for more information
    private String mURL;

    /*
    * Create a new Earthquake object.
    *
    * @param vPlace is the name of the place where earthquake occured
    * @param vMagnitude is magnitude of occurred earthquake
    * @param vDate is date on which earthquake occurred
    * */
    public Earthquake(double vMagnitude,String vPlace,long vDate,String vURL){
        mPlace = vPlace;
        mMagnitude = vMagnitude;
        mDate = vDate;
        mURL = vURL;
    }

    //Get the place name where earthquake occurred
    public String getPlace() {
        return mPlace;
    }
    //Set the place name where earthquake occurred
    public void setPlace(String place) {
        mPlace = place;
    }
    //Get the magnitude of earthquake occurred
    public double getMagnitude() {
        return mMagnitude;
    }
    //Set the magnitude of earthquake occurred
    public void setMagnitude(double magnitude) {
        mMagnitude = magnitude;
    }
    //Get the date when earthquake occurred
    public long getDate() {
        return mDate;
    }
    //Set the date when earthquake occurred
    public void setDate(long date) {
        mDate = date;
    }



}
