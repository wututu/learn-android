package com.leochin.pulltorefreshrecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.leochin.pulltorefreshrecyclerview.ui.RefreshRecycleView;
import com.leochin.pulltorefreshrecyclerview.ui.UltimateRecyclerviewViewHolder;
import com.leochin.pulltorefreshrecyclerview.ui.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by wenhao on 6/23/15.
 */
public class HiActivity extends AppCompatActivity {

    private RefreshRecycleView recyclerView;
//    private PtrClassicFrameLayout mPtrFrame;

    private HiAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            stringList.add("it is test data " + i);
        }

        adapter = new HiAdapter(stringList);

        recyclerView = (RefreshRecycleView) findViewById(R.id.custom_ultimate_recycler_view);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        recyclerView.enableLoadmore();
        adapter.setCustomLoadMoreView(LayoutInflater.from(this)
                .inflate(R.layout.custom_bottom_progressbar, null));

        recyclerView.setOnLoadMoreListener(new RefreshRecycleView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, int maxLastVisiblePosition) {
                Toast.makeText(HiActivity.this, "Hi~~", Toast.LENGTH_SHORT).show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                        adapter.insert("it is test data " + moreNum++, adapter.getAdapterItemCount());
                    }
                }, 1000);
            }
        });

        recyclerView.setCustomSwipeToRefresh();

        initClassicFrameLayout();
    }
    int moreNum = 100;

    private void initClassicFrameLayout() {
        recyclerView.mPtrFrameLayout.setLastUpdateTimeRelateObject(this);
        recyclerView.mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
//                updateData();
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.mPtrFrameLayout.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }
        });

        recyclerView.mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                //mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    public class HiViewHolder extends UltimateRecyclerviewViewHolder {
        public TextView mTextView;

        public HiViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }

    public class HiAdapter extends UltimateViewAdapter {
        private List<String> stringList;

        public HiAdapter(List<String> stringList) {
            this.stringList = stringList;
        }

        @Override
        public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            HiViewHolder vh = new HiViewHolder(v);
            return vh;
        }

        @Override
        public int getAdapterItemCount() {
            return stringList.size();
        }

        @Override
        public long generateHeaderId(int position) {
            return 0;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof HiViewHolder) {
                ((HiViewHolder)holder).mTextView.setText(stringList.get(position));
            }
        }

        public void insert(String string, int position) {
            insert(stringList, string, position);
        }
    }
}
