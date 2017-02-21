package com.example.android.booklistingapplication;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Books>>{
    /**
     * Constant value for the book loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int BOOK_LOADER_ID = 1;
    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    public static final String LOG_TAG = MainActivity.class.getName();
    /** URL for earthquake data from the Google Books API */
    private static  String mUrl =
            "https://www.googleapis.com/books/v1/volumes?q=";
    public static  String mMaxResults="&maxResults=20";
    /** Adapter for the list of books */
    private BooksArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        //Extract the data…
        String search_str = bundle.getString("search");

        //Add search string into URL
        mUrl = mUrl+search_str+mMaxResults;
        Log.v("MainActivity",mUrl);
       // mUrl = "https://www.googleapis.com/books/v1/volumes?q=java&maxResults=10";

        // Find a reference to the {@link ListView} in the layout
        ListView booksListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        booksListView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes an empty list of books as input
        mAdapter = new BooksArrayAdapter(this, new ArrayList<Books>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        booksListView.setAdapter(mAdapter);

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(BOOK_LOADER_ID, null, this);
        } else {// Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }
    @Override
    public Loader<List<Books>> onCreateLoader(int id, Bundle args) {
        // Create a new loader for the given URL
        return new BooksLoader(this, mUrl);

    }
    @Override
    public void onLoadFinished(Loader<List<Books>> loader, List<Books> books) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_books);

        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (books != null && !books.isEmpty()) {
            mAdapter.addAll(books);
        }
    }
    @Override
    public void onLoaderReset(Loader<List<Books>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
        mUrl = "https://www.googleapis.com/books/v1/volumes?q=";

    }


}
