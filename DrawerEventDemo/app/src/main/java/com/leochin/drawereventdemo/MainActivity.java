package com.leochin.drawereventdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    private DrawerPresenter mDrawerPresenter;
    @InjectView(R.id.content_list) ListView mContentListView;
    @InjectView(R.id.right_drawer) ListView mDrawerListView;
    @InjectView(R.id.drawer_layout) DrawerLayout mDrawerLayout;

    private String[] mContentTitles;
    private String[] mPlanetTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mDrawerPresenter = new DrawerPresenter(this, mDrawerLayout, mContentListView, mDrawerListView);
        mContentTitles = getResources().getStringArray(R.array.contents_array);
        mPlanetTitles = getResources().getStringArray(R.array.planets_array);

        mContentListView.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mContentTitles));
        mDrawerListView.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mPlanetTitles));

        mContentListView.setOnItemClickListener(new ContentItemClickListener(mDrawerPresenter));
        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener(mDrawerPresenter));
        mContentListView.setOnScrollListener(new ContentScrollListener(mDrawerPresenter));

        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
    }
}
