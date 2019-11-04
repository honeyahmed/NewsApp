package com.example.newsapp;


import android.content.Context;

import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static String REQUEST_URL ="https://content.guardianapis.com/search?q=debate&tag=politics/politics&from-date=2014-01-01&api-key=test";

    public NewsLoader(Context context) {

        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (REQUEST_URL == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchNewsData(REQUEST_URL);
        return newsList;
    }
}