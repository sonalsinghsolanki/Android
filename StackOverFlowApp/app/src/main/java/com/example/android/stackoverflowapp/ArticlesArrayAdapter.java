package com.example.android.stackoverflowapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sonal on 2/22/2017.
 */


/*
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */
public class ArticlesArrayAdapter extends ArrayAdapter<Articles> {

    private static final String LOG_TAG = ArticlesArrayAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param articles A List of articles objects to display in a list
     */
    public ArticlesArrayAdapter(Activity context, ArrayList<Articles> articles) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, articles);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Articles currentArticles = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title
        TextView articleTitleTextView = (TextView) listItemView.findViewById(R.id.title);
        // Get the title  from the current Articles object and
        // set this text on the title TextView
        articleTitleTextView.setText(currentArticles.getArticleTitle());

        // Find the TextView in the list_item.xml layout with the ID section-name
        TextView articleSectionTextView = (TextView) listItemView.findViewById(R.id.section_name);
        // Get the section name  from the current Articles object and
        // set this text on the section TextView
        articleSectionTextView.setText(currentArticles.getArticleSection());

        //Open new browser with url when list item is clicked
        String openUrl = currentArticles.getUrl();
        // Return the whole list item layout (containing 2 TextViews and an URL)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

