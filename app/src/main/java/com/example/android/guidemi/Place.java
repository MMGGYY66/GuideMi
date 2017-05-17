package com.example.android.guidemi;

/**
 * Created by MátéZoltán on 2017. 05. 15..
 */

public class Place {

    //The name of the place
    private String mPlaceName;

    //The address of the place
    private String mPlaceAddress;

    //The description of the place
    private String mPlaceDescription;

    //The ID of the image resource of the place
    private int mPlaceImageResourceID;

    //Constant for no audio
    private int NO_AUDIO_RESOURCE = -1;

    //The ID of the audio resourse of the place
    private int mPlaceAudioResourceID = NO_AUDIO_RESOURCE;

    //The site URL of the place
    private String mPlaceSiteURL;

    //The location coordinates of the place
    private String mPlaceLocation;


    //Public constructor of the Place object with no audio resource
    public Place (String name, String address, String description, int imageResourceID, String siteUrl, String location){
        mPlaceName = name;
        mPlaceAddress = address;
        mPlaceImageResourceID = imageResourceID;
        mPlaceDescription = description;
        mPlaceSiteURL = siteUrl;
        mPlaceLocation = location;
    }

    //Public constructor of the Place object with audio resource
    public Place (String name, String address, String description, int imageResourceID, String siteUrl, int audioResourceID, String location){
        mPlaceName = name;
        mPlaceAddress = address;
        mPlaceImageResourceID = imageResourceID;
        mPlaceDescription = description;
        mPlaceSiteURL = siteUrl;
        mPlaceAudioResourceID = audioResourceID;
        mPlaceLocation = location;
    }

    //Get the name of the place
    public String getName(){
        return mPlaceName;
    }

    //Get the address of the place
    public String getAddress(){
        return mPlaceAddress;
    }

    //Get the description of the place
    public String getDescription(){
        return mPlaceDescription;
    }

    //Get the image resource ID of the place
    public int getImageResourceID(){
        return mPlaceImageResourceID;
    }

    //Get the audio resource ID of the place
    public int getAudioResourceID(){
        return mPlaceAudioResourceID;
    }

    //Get the site URL of the place
    public String getSiteURL(){
        return mPlaceSiteURL;
    }

    //Get the location coordinates of the place
    public String getLocation(){
        return mPlaceLocation;
    }
}
