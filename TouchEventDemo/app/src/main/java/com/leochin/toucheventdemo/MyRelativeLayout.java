package com.leochin.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by wenhao on 7/19/15.
 */
public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRelativeLayout-onInterceptTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRelativeLayout-onInterceptTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRelativeLayout-onInterceptTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onInterceptTouchEvent(ev);
        Log.d("wenhao", "MyRelativeLayout-onInterceptTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRelativeLayout-dispatchTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRelativeLayout-dispatchTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRelativeLayout-dispatchTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.dispatchTouchEvent(ev);
        Log.d("wenhao", "MyRelativeLayout-dispatchTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyRelativeLayout-onTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyRelativeLayout-onTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyRelativeLayout-onTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d("wenhao", "MyRelativeLayout-onTouchEvent...value = " + flag);
        return flag;
    }
}
