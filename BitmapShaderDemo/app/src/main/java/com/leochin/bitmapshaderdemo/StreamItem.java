package com.leochin.bitmapshaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by wenhao on 5/14/15.
 */
public class StreamItem {
    final Bitmap mBitmap;
    final String mLine1;
    final String mLine2;

    StreamItem(Context c, int resid, String line1, String line2) {
        mBitmap = BitmapFactory.decodeResource(c.getResources(), resid);
        mLine1 = line1;
        mLine2 = line2;
    }
}
