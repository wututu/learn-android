package com.leochin.drawereventdemo;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by wenhao on 5/18/15.
 */
public class ContentItemClickListener implements AdapterView.OnItemClickListener {

    private DrawerPresenter mPresenter;

    public ContentItemClickListener(DrawerPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.contentListViewOnItemClick(position);
    }
}
