package com.leochin.pulltorefresh;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class PullRefreshRecyclerView extends RefreshLayout {

    public PullRefreshRecyclerView(Context context) {
        this(context, null);
    }

    public PullRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View createRefreshView() {
        RecyclerView rv = new RecyclerView(getContext());
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(lm);
        return rv;
    }

}
