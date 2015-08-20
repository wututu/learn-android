package com.leochin.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wenhao on 8/3/15.
 */
public class CustomView extends View {

    private Paint mPaint;
    private float mRadius = 175;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Bitmap mBitmap;
    private int x;
    private int y;

    private void initRes() {
        mBitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.b);
    }

    private void init() {
//        setBackgroundColor(0x809966cc);
        initRes();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//        mPaint.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.argb(255, 255, 128, 103));
//        mPaint.setStrokeWidth(10);

        // 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.5f, 0, 0, 0, 0,
                0, 0.5f, 0, 0, 0,
                0, 0, 0.5f, 0, 0,
                0, 0, 0, 1, 0,
        });
//        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        mPaint.setShader(new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

//        x = widthSize / 2 - mBitmap.getWidth() / 2;
//        y = heightSize / 2 - mBitmap.getHeight() / 2;

        x = widthSize / 2;
        y = heightSize / 2;

        left = x - RECT_SIZE;
        top = y -RECT_SIZE;
        right = x + RECT_SIZE;
        bottom = y + RECT_SIZE;
    }

    private float left;
    private float top;
    private float right;
    private float bottom;

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private static final int RECT_SIZE = 400;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("wenhao", "onDraw...");
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius, mPaint);
//        canvas.drawBitmap(mBitmap, x, y , mPaint);
        canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), mPaint);
//        canvas.drawRect(left, top, right, bottom, mPaint);
    }

    public void setCircleRadius(float radius) {
        this.mRadius = radius;
        invalidate();
    }
}
