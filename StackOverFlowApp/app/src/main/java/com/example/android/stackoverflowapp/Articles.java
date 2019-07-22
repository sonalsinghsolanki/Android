package com.example.android.stackoverflowapp;

/**
 * Created by Sonal on 2/22/2017.
 */
/** {@link Articles} represents articles
 * Each object has 3 properties: title of articles,section of article,and URL ;
 *
        */

public class Articles {
    private String mArticleTitle;
    private String mArticleSection;
    private String mUrl;


    public Articles(String articleTitle, String articleSection, String url) {
        mArticleTitle = articleTitle;
        mArticleSection = articleSection;
        mUrl = url;
    }


    public String getArticleTitle() {
        return mArticleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        mArticleTitle = articleTitle;
    }

    public String getArticleSection() {
        return mArticleSection;
    }

    public void setArticleSection(String articleSection) {
        mArticleSection = articleSection;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }


}
