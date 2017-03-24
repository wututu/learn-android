package com.leochin.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wenhao on 3/19/16.
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        this.getWindow().setBackgroundDrawableResource(R.color.colorAccent);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
