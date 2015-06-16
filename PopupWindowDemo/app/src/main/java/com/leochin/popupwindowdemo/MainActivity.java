package com.leochin.popupwindowdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
        setContentView(R.layout.activity_main);


        //rootView = getWindow().getDecorView().findViewById(android.R.id.content);

        poiTipsPopupWindow = new PoiTipsPopupWindow(this);
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

            poiTipsPopupWindow.showAtLocation(rootView, Gravity.TOP, 0, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
