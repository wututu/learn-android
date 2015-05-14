package com.leochin.bitmapshaderdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;

/**
 * Created by wenhao on 5/14/15.
 */
public class StreamDrawable extends Drawable {
    private static final boolean USE_VIGNETTE = false;
    private static final int STROKE_COLOR = Color.BLACK;

    private final float mCornerRadius;
    private final RectF mRect = new RectF();
    private final BitmapShader mBitmapShader;
    private final Paint mPaint;
    private final int mMargin;
    private final int mStroke;

    private final Paint mStrokePaint;

    StreamDrawable(Bitmap bitmap, float cornerRadius, int margin, int stroke) {

        mCornerRadius = cornerRadius;
        mMargin = margin;
        mStroke = stroke;

        mBitmapShader = new BitmapShader(bitmap,
                Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(mBitmapShader);

        mStrokePaint = new Paint();
        mStrokePaint.setAntiAlias(true);
        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(mStroke);
        mStrokePaint.setColor(STROKE_COLOR);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);

        // 初始化和位置相关的东西
        mRect.set(mMargin, mMargin, bounds.width() - mMargin, bounds.height() - mMargin);

        // 是否在图片的四周添加黑色阴影
        if (USE_VIGNETTE) {
            // RadialGradient 环形渐变渲染
            RadialGradient vignette = new RadialGradient(
                    mRect.centerX(), mRect.centerY() * 1.0f / 0.7f, mRect.centerX() * 1.3f,
                    new int[] { 0, 0, 0x7f000000 }, new float[] { 0.0f, 0.7f, 1.0f },
                    Shader.TileMode.CLAMP);

            Matrix oval = new Matrix();
            oval.setScale(1.0f, 0.7f);
            vignette.setLocalMatrix(oval);

            // ComposeShader 混合Shader
            mPaint.setShader(
                    new ComposeShader(mBitmapShader, vignette, PorterDuff.Mode.SRC_OVER));
        }
    }

    @Override
    public void draw(Canvas canvas) {
//        canvas.drawRoundRect(mRect, mCornerRadius, mCornerRadius, mPaint); // 圆矩形
        canvas.drawCircle(mRect.centerX(), mRect.centerY(), mCornerRadius, mPaint); // 圆形
        canvas.drawCircle(mRect.centerX(), mRect.centerY(), mCornerRadius, mStrokePaint);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }
}
