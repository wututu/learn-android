package com.leochin.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by wenhao on 7/19/15.
 */
public class MyViewGroup extends FrameLayout {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyViewGroup-onInterceptTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyViewGroup-onInterceptTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyViewGroup-onInterceptTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onInterceptTouchEvent(ev);
        Log.d("wenhao", "MyViewGroup-onInterceptTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyViewGroup-dispatchTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyViewGroup-dispatchTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyViewGroup-dispatchTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.dispatchTouchEvent(ev);
        Log.d("wenhao", "MyViewGroup-dispatchTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyViewGroup-onTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyViewGroup-onTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyViewGroup-onTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d("wenhao", "MyViewGroup-onTouchEvent...value = " + flag);
        return flag;
    }
}
