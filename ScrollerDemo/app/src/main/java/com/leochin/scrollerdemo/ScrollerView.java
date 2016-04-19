package com.leochin.scrollerdemo;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wenhao on 4/19/16.
 */
public class ScrollerView extends View {

    @IntDef({MOVE_MODE_LEFT, MOVE_MODE_RIGHT, MOVE_MODE_TOP, MOVE_MODE_DOWN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MoveFlag {
    }

    public static final int MOVE_MODE_LEFT = 1;
    public static final int MOVE_MODE_RIGHT = 2;
    public static final int MOVE_MODE_TOP = 3;
    public static final int MOVE_MODE_DOWN = 4;

    private static final int MOVE_STEP = 300;

    private int mMode = 0;

    private Scroller mScroller;


    public ScrollerView(Context context) {
        super(context);
        init(context);
    }

    public ScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
    }

    public void move(@MoveFlag int orientation) {
        this.mMode = orientation;

        int startX = (int) this.getX();
        int startY = (int) this.getY();
        int dx = 0;
        int dy = 0;
        switch (orientation) {
            case MOVE_MODE_LEFT:
                dx = -MOVE_STEP;
                dy = 0;
                break;
            case MOVE_MODE_RIGHT:
                dx = MOVE_STEP;
                dy = 0;
                break;
            case MOVE_MODE_TOP:
                dx = 0;
                dy = -MOVE_STEP;
                break;
            case MOVE_MODE_DOWN:
                dx = 0;
                dy = MOVE_STEP;
                break;
            default:
                break;
        }

        Log.d("wenhao", "startX = " + startX + ", startY = " + startY);
        mScroller.startScroll(startX, startY, dx, dy);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            if(mMode == MOVE_MODE_LEFT || mMode == MOVE_MODE_RIGHT) {
                Log.d("wenhao", "LEFT_RIGHT = " + mScroller.getCurrX() + "," + getY());
                scrollTo(mScroller.getCurrX(), (int)getY());
            } else if(mMode == MOVE_MODE_TOP || mMode == MOVE_MODE_DOWN){
                scrollTo((int) getX(), mScroller.getCurrY());
                Log.d("wenhao", "TOP_DOWN = " + getX() + "," + mScroller.getCurrY());
            }
            postInvalidate();
        }
    }
}
