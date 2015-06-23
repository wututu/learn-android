package com.leochin.pulltorefreshrecyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class EndlessRecyclerOnScrollListener extends
		RecyclerView.OnScrollListener {
	public static String TAG = EndlessRecyclerOnScrollListener.class
			.getSimpleName();

	private int previousTotal = 0;
	private boolean isLoadingMore = true;
	private int visibleThreshold = 5;
	int firstVisibleItem, visibleItemCount, totalItemCount, lastVisibleItemPosition;

	private LinearLayoutManager mLinearLayoutManager;

	public EndlessRecyclerOnScrollListener(
			LinearLayoutManager linearLayoutManager) {
		this.mLinearLayoutManager = linearLayoutManager;
	}

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		super.onScrolled(recyclerView, dx, dy);

		visibleItemCount = mLinearLayoutManager.getChildCount();
		totalItemCount = mLinearLayoutManager.getItemCount();
		firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
        lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();

		if (isLoadingMore) {
			if (totalItemCount > previousTotal) {
                isLoadingMore = false;
				previousTotal = totalItemCount;
			}
		}

		if (!isLoadingMore
				&& (totalItemCount - visibleItemCount) <= firstVisibleItem) {
			onLoadMore(recyclerView.getAdapter().getItemCount(), lastVisibleItemPosition);
            isLoadingMore = true;
            previousTotal = totalItemCount;
		}
	}

	public abstract void onLoadMore(int itemsCount, int maxLastVisiblePosition);
}