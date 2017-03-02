package com.example.android.newsapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Sonal on 2/22/2017.
 */
public class ArticlesLoader extends AsyncTaskLoader<List<Articles>> {
    /** Tag for log messages */
    private static final String LOG_TAG = ArticlesLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public ArticlesLoader(Context context, String url) {
        super(context);
        // TODO: Finish implementing this constructor
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Articles> loadInBackground() {
        // TODO: Implement this method
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of articles.
        List<Articles> articles = QueryUtils.fetchArticlesData(mUrl);
        return articles;
    }
}
