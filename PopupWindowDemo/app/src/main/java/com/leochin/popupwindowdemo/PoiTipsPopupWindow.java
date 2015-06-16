package com.leochin.popupwindowdemo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by wenhao on 6/16/15.
 */
public class PoiTipsPopupWindow extends PopupWindow {

    private Context context;
    private View rootView;
    private LayoutInflater inflater;

    public PoiTipsPopupWindow(Context context) {
        super(context);
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.popupwindow_poi_tips, null);

        this.setContentView(rootView);
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
        this.setHeight(height);
        this.setFocusable(true);
        this.setAnimationStyle(R.style.AnimBottom);
    }
}
