package com.leochin.blanktextdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by wenhao on 5/16/15.
 *
 * NOTICE: BlankTextView不能设置background
 *
 */
public class BlankTextView extends TextView {
    private Paint mPaint;
    private RectF mRectF;

    private Bitmap mBackgroundBitmap;
    private Bitmap mTextBitmap;

    private int mBackgroundColor = 0xff9966cc; //0xc0ffffff
    private int mCornerSize = 10;

    public BlankTextView(Context context) {
        super(context);
        init();
    }

    public BlankTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BlankTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mRectF = new RectF();
    }

    private Bitmap makeBackground() {
        int width = (int) mRectF.width();
        int height = (int) mRectF.height();

        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(mBackgroundColor);
        c.drawRoundRect(mRectF, mCornerSize, mCornerSize, p);
        return bm;
    }

    private Bitmap makeText() {
        CharSequence text = getText();
        int width = (int) mRectF.width();
        int height = (int) mRectF.height();

        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        //Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        Paint p = new Paint();
        p.set(getPaint());

//        p.setColor(Color.YELLOW);
//        p.setTextSize(getTextSize());

        Paint.FontMetricsInt fontMetrics = p.getFontMetricsInt();
        float baseline = mRectF.top + (mRectF.bottom - mRectF.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        p.setTextAlign(Paint.Align.CENTER);
        c.drawText(text, 0, text.length(), mRectF.centerX(), baseline, p);

        return bm;
    }

    private void setup() {
        mRectF.set(0, 0, getWidth(), getHeight());

        mBackgroundBitmap = makeBackground();
        mTextBitmap = makeText();
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        //super.onDraw(canvas);

        setup();
        int sc = canvas.saveLayer(mRectF.left, mRectF.top, mRectF.right, mRectF.bottom, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);

        canvas.drawBitmap(mBackgroundBitmap, 0, 0, mPaint); // dst
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(mTextBitmap, 0, 0, mPaint); //src
        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }

    public void setBlankBackgroundColor(int color) {
        this.mBackgroundColor = color;
    }

    public void setCornerSize(int size) {
        this.mCornerSize = size;
    }

}
