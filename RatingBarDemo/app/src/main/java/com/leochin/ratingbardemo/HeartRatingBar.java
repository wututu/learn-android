package com.leochin.ratingbardemo;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.RatingBar;

/**
 * Created by wenhao on 6/24/15.
 */
public class HeartRatingBar extends RatingBar implements RatingBar.OnRatingBarChangeListener {

    public interface OnHeartRatingBarChangeListener {
        void setOnRatingBarChangeListener(RatingBar ratingBar, float rating, boolean fromUser);
    }

    private OnHeartRatingBarChangeListener mOnHeartRatingBarChangeListener;
    private LayerDrawable mLayerDrawable;

    public HeartRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public HeartRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public HeartRatingBar(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.setOnRatingBarChangeListener(this);
        initDrawable();
    }

    private void initDrawable() {
        if (mLayerDrawable != null) {
            return;
        }

        Drawable drawable = this.getProgressDrawable();
        if (drawable != null && drawable instanceof LayerDrawable) {
            mLayerDrawable = (LayerDrawable) drawable;
        }
    }

    public void setOnHeartRatingBarChangeListener(OnHeartRatingBarChangeListener listener) {
        this.mOnHeartRatingBarChangeListener = listener;
    }

    public OnHeartRatingBarChangeListener getOnHeartRatingBarChangeListener() {
        return mOnHeartRatingBarChangeListener;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        if (mOnHeartRatingBarChangeListener != null) {
            mOnHeartRatingBarChangeListener.setOnRatingBarChangeListener(ratingBar, rating, fromUser);
        }

        changeColor(rating);
    }

    @Override
    public void setRating(float rating) {
        super.setRating(rating);
        initDrawable();

        changeColor(rating);
    }

    private void changeColor(float rating) {
        if (mLayerDrawable == null) {
            return;
        }

        if (rating == 1f) {
            mLayerDrawable.getDrawable(2).setColorFilter(0xff994444, PorterDuff.Mode.SRC_ATOP);
        } else if (rating == 2f) {
            mLayerDrawable.getDrawable(2).setColorFilter(0xffcc5b5b, PorterDuff.Mode.SRC_ATOP);
        } else {
            mLayerDrawable.getDrawable(2).setColorFilter(0xffff7272, PorterDuff.Mode.SRC_ATOP);
        }
    }
}
