package com.leochin.drawereventdemo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by wenhao on 5/18/15.
 */
public class DrawerItemClickListener implements ListView.OnItemClickListener {

    private DrawerPresenter mPresenter;

    public DrawerItemClickListener(DrawerPresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mPresenter.drawerListViewOnItemClick(position);
    }
}
