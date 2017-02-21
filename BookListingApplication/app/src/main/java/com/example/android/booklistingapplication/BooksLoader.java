package com.example.android.booklistingapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Ashutosh on 2/16/2017.
 */
public class BooksLoader extends AsyncTaskLoader<List<Books>> {
    /** Tag for log messages */
    private static final String LOG_TAG = BooksLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public BooksLoader(Context context, String url) {
        super(context);
        // TODO: Finish implementing this constructor
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        forceLoad();
    }
    @Override
    public List<Books> loadInBackground() {
        // TODO: Implement this method
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of Books.
        List<Books> booksList = QueryUtils.fetchBooksData(mUrl);
        return booksList;
    }
}
