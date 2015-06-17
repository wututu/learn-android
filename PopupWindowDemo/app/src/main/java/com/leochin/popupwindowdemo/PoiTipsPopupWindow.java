package com.leochin.popupwindowdemo;

import android.content.Context;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by wenhao on 6/16/15.
 */
public class PoiTipsPopupWindow extends PopupWindow {

    private Context context;
    private View contentView;

    private PoiTipsPopupWindow(Context context, int layoutId) {
        super(context);
        this.context = context;
        this.contentView = LayoutInflater.from(context).inflate(layoutId, null);
        setBackgroundDrawable(null);
        this.setContentView(this.contentView);

        init();
    }

    public void init() {
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, context.getResources().getDisplayMetrics());
        this.setHeight(height);

        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hi~", Toast.LENGTH_SHORT).show();
            }
        });
        contentView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dismiss();
                }
                return true;
            }
        });
    }

    public View getContentView() {
        return contentView;
    }

    public static class Builder {
        private Context context;
        private int layoutId;
        private boolean focusable = false;
        private int animationStyle = 0;

        public Builder(Context context, int layoutId) {
            this.context = context;
            this.layoutId = layoutId;
        }

        public Builder setFocusable(boolean focusable) {
            this.focusable = focusable;
            return this;
        }

        public Builder setAnimationStyle(int animationStyle) {
            this.animationStyle = animationStyle;
            return this;
        }

        public PoiTipsPopupWindow create() {
            final PoiTipsPopupWindow poiTips = new PoiTipsPopupWindow(context, layoutId);
            poiTips.setFocusable(focusable);
            if (animationStyle != 0) {
                poiTips.setAnimationStyle(animationStyle);
            }

            return poiTips;
        }
    }
}
