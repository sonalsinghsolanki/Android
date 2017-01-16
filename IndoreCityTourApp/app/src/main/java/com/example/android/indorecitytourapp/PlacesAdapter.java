package com.example.android.indorecitytourapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashutosh on 12/21/2016.
 */
public class PlacesAdapter extends ArrayAdapter<Places> {
    private int mColorResourceId;
    public PlacesAdapter(Activity context, ArrayList<Places> places, int colorResourceId) {
        super(context,0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Places} object located at this position in the list
        Places currentPlaces = getItem(position);

        // Find the PlaceName TextView in the list_item.xml layout with the ID name_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the Place word from the current Places object and
        // set this text on the name TextView
        miwokTextView.setText(currentPlaces.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID short_description_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.short_description_text_view);
        // Get the descriptiom from the current Places object and
        // set this text on the number TextView
        defaultTextView.setText(currentPlaces.getPlaceDescription());

        //Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image);

        if(currentPlaces.hasImage()) {
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentPlaces.getImageResourceId());
            //shows the image
            iconView.setVisibility(View.VISIBLE);
        }else{
            //hides the image
            iconView.setVisibility(View.GONE);
        }


        //set the theme color for the list view item
       /* View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that the resource id map to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //set background color of the text container view
        textContainer.setBackgroundColor(color);*/

        // Return the whole list item layout (containing 2 TextViews )
        // so that it can be shown in the ListView
        return listItemView;


    }
}
