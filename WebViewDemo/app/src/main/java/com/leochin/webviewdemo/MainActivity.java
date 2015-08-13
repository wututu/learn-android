package com.leochin.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mWebView = (WebView) findViewById(R.id.webview);
        setSettings();

        WebAppInterface wai = new WebAppInterface(this);
        this.mWebView.addJavascriptInterface(wai, "android");

        this.mWebView.loadUrl("http://www.baidu.com");
    }

    private void setSettings() {
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebChromeClient
        this.mWebView.setWebViewClient(new WebViewClient());
    }

}
