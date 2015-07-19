package com.leochin.popupwindowdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private View rootView;
    PoiTipsPopupWindow poiTipsPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        setContentView(rootView);
        //rootView = getWindow().getDecorView().findViewById(android.R.id.content);

        height = getStatusBarHeight();
        Log.d("wenhao", "height = " + height);

        poiTipsPopupWindow = new PoiTipsPopupWindow.Builder(this, R.layout.popupwindow_poi_tips).create();

        findViewById(R.id.main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poiTipsPopupWindow.dismiss();
            }
        });
    }

    private int height;

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            poiTipsPopupWindow.showAtLocation(rootView, Gravity.TOP, 0, height);
            rootView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    poiTipsPopupWindow.dismiss();
                }
            }, 4000);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
