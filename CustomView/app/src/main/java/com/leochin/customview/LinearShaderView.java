package com.leochin.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wenhao on 8/12/15.
 */
public class LinearShaderView extends View {

    public LinearShaderView(Context context) {
        super(context);
    }

    public LinearShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private Paint mPaint;
    private void init() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        Log.d("wenhao", "width = " + this.getWidth() + "," + this.getHeight());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;

        Log.d("wenhao", left +"," +top +"," + right +"," + bottom);
        mPaint.setShader(new LinearGradient(left, top, right - this.getWidth() / 4, bottom - this.getHeight() / 4, Color.RED, Color.YELLOW, Shader.TileMode.MIRROR));
    }

    private int left;
    private int top;
    private int right;
    private int bottom;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(left, top, right, bottom, mPaint);
//        Paint paint = new Paint();
//        paint.setColor(Color.YELLOW);
////        canvas.drawRect(left, top, right - this.getWidth() / 2, bottom - this.getHeight() / 2, paint);
//        Path path = new Path();
////        path.moveTo(200, 0);
//        path.lineTo(0, this.getHeight());
//        path.lineTo(this.getWidth(), 0);
//        canvas.drawPath(path, mPaint);
    }
}
