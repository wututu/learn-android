package com.leochin.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wenhao on 8/9/15.
 */
public class BrickView extends View {

    private Paint mFillPaint;
    private Paint mBrickPaint;

    private BitmapShader bs;
    private LinearGradient lg;
    private Bitmap bitmap;

    public BrickView(Context context) {
        super(context);
    }

    public BrickView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBrickPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mFillPaint = new Paint(mBrickPaint);
        mFillPaint.setStyle(Paint.Style.STROKE);
        mFillPaint.setStrokeWidth(4);
        mFillPaint.setColor(Color.BLACK);
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.brick);
//        bs = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);

        mBrickPaint.setShader(bs);
        x = bitmap.getWidth() / 2;
        y = bitmap.getHeight() / 2;
        radius = 200;
    }

    private float x;
    private float y;
    private float radius;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);

        if(event.getAction() == MotionEvent.ACTION_MOVE) {
            x = event.getX();
            y = event.getY();

            invalidate();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y ,radius, mBrickPaint);
        canvas.drawCircle(x, y, radius, mFillPaint);
    }
}
