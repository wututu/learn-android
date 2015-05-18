package com.leochin.drawereventdemo;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by wenhao on 5/18/15.
 */
public class HelloDrawerLayout extends DrawerLayout {

    public HelloDrawerLayout(Context context) {
        super(context);
    }

    public HelloDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HelloDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
