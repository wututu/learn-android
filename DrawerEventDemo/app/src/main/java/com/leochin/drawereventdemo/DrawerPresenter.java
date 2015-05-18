package com.leochin.drawereventdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.ListView;

import butterknife.InjectView;

/**
 * Created by wenhao on 5/18/15.
 */
public class DrawerPresenter {

    private Context mContext;
    private ListView mContentListView;
    private ListView mDrawerListView;
    private DrawerLayout mDrawerLayout;

    public DrawerPresenter(@NonNull Context context, @NonNull DrawerLayout drawerLayout,
                           @NonNull ListView contentListView, @NonNull ListView drawerListView) {
        this.mContext = context;
        mDrawerLayout = drawerLayout;
        this.mContentListView = contentListView;
        this.mDrawerListView = drawerListView;
    }

    public void drawerListViewOnItemClick(int position) {
        if (mDrawerListView == null) {
            return;
        }
        mDrawerListView.setItemChecked(position, true);
    }

    public void contentListViewOnItemClick(int position) {
        if (mContentListView == null && mDrawerLayout == null) {
            return;
        }
        mContentListView.setItemChecked(position, true);

        if (!mDrawerLayout.isDrawerVisible(GravityCompat.END)) {
            mDrawerLayout.openDrawer(GravityCompat.END);
        }
    }

    public void openDrawer(){
        if(mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        }
    }
}
