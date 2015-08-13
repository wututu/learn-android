package com.leochin.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wenhao on 7/21/15.
 */
public class CircleView extends View {

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;
    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
    }

    private int size = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        Log.d("wenhao", "Width = " + Integer.toHexString(widthMeasureSpec) + ",Height = " + Integer.toHexString(heightMeasureSpec));
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.AT_MOST) {
            Log.d("wenhao", "Width Mode = " + "AT_MOST");
        }

        if(widthMode == MeasureSpec.EXACTLY) {
            Log.d("wenhao", "Width Mode = " + "EXACTLY");
        }

        if(widthMode == MeasureSpec.UNSPECIFIED) {
            Log.d("wenhao", "Width Mode = " + "UNSPECIFIED");
        }

        if(heightMode == MeasureSpec.AT_MOST) {
            Log.d("wenhao", "Height Mode = " + "AT_MOST");
        }

        if(heightMode == MeasureSpec.EXACTLY) {
            Log.d("wenhao", "Height Mode = " + "EXACTLY");
        }

        if(heightMode == MeasureSpec.UNSPECIFIED) {
            Log.d("wenhao", "Height Mode = " + "UNSPECIFIED");
        }

        Log.d("wenhao", "Width = " + widthSize + ",Height = " + heightSize);
        Log.d("wenhao", "Suggest Width = " + getSuggestedMinimumWidth() + ", Height = " + getSuggestedMinimumHeight());

        cx = widthSize / 2;
        cy = heightSize / 2;
        size = Math.min(widthSize, heightSize) / 2;
    }

    private float cx = 0;
    private float cy = 0;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("wenhao", "onLayout..." + left + "," + top + "," + right + "," + bottom);

        Log.d("wenhao", "width = " + getWidth() +", getMeasureWidth = " + getMeasuredWidth() + ", right-left = " + (right - left));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("wenhao", "onDraw...");
        canvas.drawCircle(0, 0, size, mPaint);
    }
}
