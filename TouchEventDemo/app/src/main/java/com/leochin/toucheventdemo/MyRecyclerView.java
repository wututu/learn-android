package com.leochin.toucheventdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by wenhao on 7/19/15.
 */
public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRecyclerView-onInterceptTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRecyclerView-onInterceptTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRecyclerView-onInterceptTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onInterceptTouchEvent(ev);
        Log.d("wenhao", "MyRecyclerView-onInterceptTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRecyclerView-dispatchTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRecyclerView-dispatchTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRecyclerView-dispatchTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.dispatchTouchEvent(ev);
        Log.d("wenhao", "MyRecyclerView-dispatchTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRecyclerView-onTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRecyclerView-onTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRecyclerView-onTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d("wenhao", "MyRecyclerView-onTouchEvent...value = " + flag);
        return flag;
    }
}
