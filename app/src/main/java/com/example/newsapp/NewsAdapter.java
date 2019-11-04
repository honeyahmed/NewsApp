package com.example.newsapp;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Activity context, List<News> news) {
        super(context, 0, news);
    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.items, parent, false);
        }

        News currentNews = getItem(position);
        TextView newsTitleTextView =  listItemView.findViewById(R.id.title_text_view);
        assert currentNews != null;
        String title = currentNews.getmTitle();
        newsTitleTextView.setText(title);


        TextView newsCategoryTextView =  listItemView.findViewById(R.id.category_info);
        String category = currentNews.getmCategory();
        newsCategoryTextView.setText(category);

        TextView newsDateTextView = listItemView.findViewById(R.id.date_text_view);
        String date = currentNews.getmDate();
        newsDateTextView.setText(date);

        TextView newsAuthorTextView =  listItemView.findViewById(R.id.author_text_view);
        String author = currentNews.getmAuthor();
        newsAuthorTextView.setText(author);

        return listItemView;
    }
}
