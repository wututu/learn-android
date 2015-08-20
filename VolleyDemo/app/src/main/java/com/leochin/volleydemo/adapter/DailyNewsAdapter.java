package com.leochin.volleydemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leochin.volleydemo.R;
import com.leochin.volleydemo.model.DailyNewsModel;
import com.leochin.volleydemo.model.NewsModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wenhao on 8/20/15.
 */
public class DailyNewsAdapter extends BaseAdapter {

    private Context context;
    private NewsModel newsModel;

    public DailyNewsAdapter(@NonNull Context context, NewsModel newsModel) {
        this.context = context;
        this.newsModel = newsModel;
    }

    @Override
    public int getCount() {
        return newsModel == null ? 0 : newsModel.getStories().size();
    }

    @Override
    public Object getItem(int position) {
        return newsModel == null? null : newsModel.getStories().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_dailynews, null);

        TextView newsNameTextView = (TextView) view.findViewById(R.id.news_name_textview);
        DailyNewsModel model = (DailyNewsModel) getItem(position);
        if(model != null && !TextUtils.isEmpty(model.getTitle())) {
            newsNameTextView.setText(model.getTitle());
        }
        return view;
    }
}
