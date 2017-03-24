package com.leochin.scrollerdemo;

import android.content.Context;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wenhao on 4/19/16.
 */
public class ScrollerView extends RelativeLayout {

    @IntDef({MOVE_MODE_LEFT, MOVE_MODE_RIGHT, MOVE_MODE_TOP, MOVE_MODE_DOWN})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MoveFlag {
    }

    public static final int MOVE_MODE_LEFT = 1;
    public static final int MOVE_MODE_RIGHT = 2;
    public static final int MOVE_MODE_TOP = 3;
    public static final int MOVE_MODE_DOWN = 4;

    private static final int MOVE_STEP = 100;

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
        int startX = this.getScrollX();
        int startY = this.getScrollY();
        int dx = 0;
        int dy = 0;
        switch (orientation) {
            case MOVE_MODE_LEFT:
                dx = MOVE_STEP;
                dy = 0;
                break;
            case MOVE_MODE_RIGHT:
                dx = -MOVE_STEP;
                dy = 0;
                break;
            case MOVE_MODE_TOP:
                dx = 0;
                dy = MOVE_STEP;
                break;
            case MOVE_MODE_DOWN:
                dx = 0;
                dy = -MOVE_STEP;
                break;
            default:
                break;
        }

        mScroller.startScroll(startX, startY, dx, dy);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            /**
             * scrollTo或者scrollBy移动的为ContentView而不是View本身
             */
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
