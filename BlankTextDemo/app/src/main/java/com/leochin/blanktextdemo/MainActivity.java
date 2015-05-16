package com.leochin.blanktextdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {


    @InjectView(R.id.blank_layout) LinearLayout mBlankLayout;
    @InjectView(R.id.blank_text) TextView mBlankText;
    @InjectView(R.id.main_layout) RelativeLayout mMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        Log.d("wenhao", this.getResources().getDisplayMetrics().density + "");
        mBlankLayout.setBackground(new BlankTextDrawable());
//        mMainLayout.setBackground(new BlankTextDrawable());
    }
}
