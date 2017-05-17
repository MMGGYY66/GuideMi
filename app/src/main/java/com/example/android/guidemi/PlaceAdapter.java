package com.example.android.guidemi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MátéZoltán on 2017. 05. 15..
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    Context context = getContext();

    public PlaceAdapter(Activity context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        //Get the object's properties
        String name = currentPlace.getName();
        String address = currentPlace.getAddress();
        String description = currentPlace.getDescription();
        int imageID = currentPlace.getImageResourceID();
        int audioID = currentPlace.getAudioResourceID();
        String siteURL = currentPlace.getSiteURL();
        String location = currentPlace.getLocation();

        //Get the ImageView and set the name of the Object
        final ImageView itemImageView = (ImageView) listItemView.findViewById(R.id.list_item_image);
        itemImageView.setImageResource(imageID);

        //Get the TextView and set the name of the Object
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.list_item_name);
        nameTextView.setText(name);

        //Get the TextView and set the name of the Object
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.list_item_address);
        addressTextView.setText(address);

        //Create an implicit intent to display the detailed place information if the user taps on the list item
        final Intent itemIntent = new Intent(context, PlaceDetailsActivity.class);

        //Put the properties of the Object to the intent
        itemIntent.putExtra("placeName", name);
        itemIntent.putExtra("placeAddress", address);
        itemIntent.putExtra("placeDescription", description);
        itemIntent.putExtra("placeImage", imageID);
        itemIntent.putExtra("placeAudio", audioID);
        itemIntent.putExtra("placeSite", siteURL);
        itemIntent.putExtra("placeLocation", location);

        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }
        });

        return listItemView;
    }
}
