package com.leochin.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wenhao on 7/24/15.
 */
public class CircleViewGroup extends ViewGroup {


    public CircleViewGroup(Context context) {
        super(context);
    }

    public CircleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        layoutChildren(l, t, r, b);
    }

    void layoutChildren(int left, int top, int right, int bottom) {
        final int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {

                child.layout(left, top, child.getMeasuredWidth(), child.getMeasuredHeight());
            }
        }
    }




}
