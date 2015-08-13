package com.leochin.webviewdemo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by wenhao on 8/13/15.
 */
public class WebAppInterface {

    private Context mContext;

    public WebAppInterface(Context mContext) {
        this.mContext = mContext;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(this.mContext, toast, Toast.LENGTH_SHORT).show();
    }
}
