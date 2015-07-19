package com.leochin.toucheventdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by wenhao on 7/19/15.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MainActivity-dispatchTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MainActivity-dispatchTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MainActivity-dispatchTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.dispatchTouchEvent(ev);
        Log.d("wenhao", "MainActivity-dispatchTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MainActivity-onTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MainActivity-onTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MainActivity-onTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d("wenhao", "MainActivity-onTouchEvent...value = " + flag);
        return flag;
    }
}
