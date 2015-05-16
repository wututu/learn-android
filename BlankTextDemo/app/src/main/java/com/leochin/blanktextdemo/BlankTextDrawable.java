package com.leochin.blanktextdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created by wenhao on 5/16/15.
 */
public class BlankTextDrawable extends Drawable {

    private Paint mPaint = new Paint();
    private RectF mRect = new RectF();
    private static final String text = "wenhao";
    private static final int TEXT_SIZE = 40; //sps

    private Bitmap mBackgroundBitmap;
    private Bitmap mTextBitmap;

    public BlankTextDrawable() {
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);

        mRect.set(0, 0, bounds.width(), bounds.height());

        mBackgroundBitmap = makeBackground();
        mTextBitmap = makeText();
    }

    private Bitmap makeBackground() {

        int width = (int) mRect.width();
        int height = (int) mRect.height();

        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF9966cc);
        c.drawRoundRect(mRect, 10, 10, p);
        return bm;
    }

    private Bitmap makeText() {
        int width = (int) mRect.width();
        int height = (int) mRect.height();

        Bitmap bm = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(Color.YELLOW);
        p.setTextSize(TEXT_SIZE);
        p.setTextAlign(Paint.Align.CENTER);

//        c.drawText(text, mRect.left + mRect.centerX(), mRect.top + TEXT_SIZE, p);
        Paint.FontMetricsInt fontMetrics = p.getFontMetricsInt();
        float baseline = mRect.top + (mRect.bottom - mRect.top - fontMetrics.bottom + fontMetrics.top) / 2 - fontMetrics.top;
        c.drawText(text, mRect.centerX(), baseline, p);
        return bm;
    }

    @Override
    public void draw(Canvas canvas) {

        int sc = canvas.saveLayer(mRect.left, mRect.top, mRect.right, mRect.bottom, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);

        canvas.drawBitmap(mBackgroundBitmap, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(mTextBitmap, 0, 0, mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
