package com.leochin.drawereventdemo;

import android.widget.AbsListView;

/**
 * Created by wenhao on 5/18/15.
 */
public class ContentScrollListener implements AbsListView.OnScrollListener {

    private DrawerPresenter mPresenter;

    public ContentScrollListener(DrawerPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        mPresenter.openDrawer();
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
