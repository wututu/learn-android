package com.leochin.bitmapshaderdemo;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by wenhao on 5/14/15.
 */
public class StreamAdapter extends ArrayAdapter<StreamItem> {
    private static final int CORNER_RADIUS = 60; // dips
    private static final int MARGIN = 12; // dips

    private final int mCornerRadius;
    private final int mMargin;
    private final LayoutInflater mInflater;

    public StreamAdapter(Context context) {
        super(context, 0);

        final float density = context.getResources().getDisplayMetrics().density;

        //  TypedValue.applyDimension() 作用是将其他尺寸转换为px
        mCornerRadius = (int) (CORNER_RADIUS * density + 0.5f);
        mMargin = (int) (MARGIN * density + 0.5f);

        mInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewGroup view = null;

        if (convertView == null) {
            view = (ViewGroup) mInflater.inflate(R.layout.stream_item, parent, false);
        } else {
            view = (ViewGroup) convertView;
        }

        StreamItem item = getItem(position);

        StreamDrawable d = new StreamDrawable(item.mBitmap, mCornerRadius, mMargin);

        view.setBackground(d);

        ((TextView) view.findViewById(R.id.textView1)).setText(item.mLine1);
        ((TextView) view.findViewById(R.id.textView2)).setText(item.mLine2);

        int w = item.mBitmap.getWidth();
        int h = item.mBitmap.getHeight();

        float ratio = w / (float) h;

        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.width = getContext().getResources().getDisplayMetrics().widthPixels;
        lp.height = (int) (lp.width / ratio);

        return view;
    }
}