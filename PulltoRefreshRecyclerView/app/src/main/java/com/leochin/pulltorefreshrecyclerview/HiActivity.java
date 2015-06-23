package com.leochin.pulltorefreshrecyclerview;

import android.os.Bundle;
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

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by wenhao on 6/23/15.
 */
public class HiActivity extends AppCompatActivity {

    private RefreshRecycleView recyclerView;
//    private PtrClassicFrameLayout mPtrFrame;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String[] datas = new String[50];
        for (int i = 0; i < 50; i++) {
            datas[i] = "it is test data " + i;
        }

        HiAdapter adapter = new HiAdapter(datas);

        recyclerView = (RefreshRecycleView) findViewById(R.id.custom_ultimate_recycler_view);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        recyclerView.enableLoadmore();

        recyclerView.setOnLoadMoreListener(new RefreshRecycleView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, int maxLastVisiblePosition) {
                Toast.makeText(HiActivity.this, "Hi~~", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setCustomSwipeToRefresh();

        initClassicFrameLayout();
    }

    private void initClassicFrameLayout() {
//        mPtrFrame = (PtrClassicFrameLayout) findViewById(R.id.rotate_header_list_view_frame);
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
        private String[] mDataset;

        public HiAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        @Override
        public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            HiViewHolder vh = new HiViewHolder(v);
            return vh;
        }

        @Override
        public int getAdapterItemCount() {
            return mDataset.length;
        }

        @Override
        public long generateHeaderId(int position) {
            return 0;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof HiViewHolder) {
                ((HiViewHolder)holder).mTextView.setText(mDataset[position]);
            }
        }
    }
}
