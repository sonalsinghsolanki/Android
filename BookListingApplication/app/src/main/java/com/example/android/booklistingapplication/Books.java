package com.example.android.booklistingapplication;

import java.util.List;

/**
 * Created by Ashutosh on 2/16/2017.
 */
public class Books {
    private String mBookName;
    private List<String> mBookAuthorName;

    public Books(String bookName, List<String> bookAuthorName) {
        mBookName = bookName;
        mBookAuthorName = bookAuthorName;
    }

    public String getBookName() {
        return mBookName;
    }

    public void setBookName(String bookName) {
        mBookName = bookName;
    }

    public List<String> getBookAuthorName() {
        return mBookAuthorName;
    }

    public void setBookAuthorName(List<String> bookAuthorName) {
        mBookAuthorName = bookAuthorName;
    }



}
