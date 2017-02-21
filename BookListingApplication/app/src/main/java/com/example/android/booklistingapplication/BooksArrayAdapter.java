package com.example.android.booklistingapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sonal on 1/31/2017.
 */


/*
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */
public class BooksArrayAdapter extends ArrayAdapter<Books> {

    private static final String LOG_TAG = BooksArrayAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param books A List of AndroidFlavor objects to display in a list
     */
    public BooksArrayAdapter(Activity context, ArrayList<Books> books) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
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
        Books currentBook = getItem(position);
        //Get the current book name
            TextView bookName = (TextView) listItemView.findViewById(R.id.title);
            bookName.setText(currentBook.getBookName());
        StringBuilder builder = new StringBuilder();
        for (String authorsName : currentBook.getBookAuthorName()) {
            builder.append(authorsName + "\n");
        }
        //Get the list of authors name
        TextView authorsNameLists = (TextView) listItemView.findViewById(R.id.authorname);
        authorsNameLists.setText(builder.toString());
        return listItemView;
    }

}

