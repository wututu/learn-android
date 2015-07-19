package com.leochin.toucheventdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by wenhao on 7/19/15.
 */
public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyButton-dispatchTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyButton-dispatchTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyButton-dispatchTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.dispatchTouchEvent(ev);
        Log.d("wenhao", "MyButton-dispatchTouchEvent...value = " + flag);
        return flag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("wenhao", "MyButton-onTouchEvent---DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("wenhao", "MyButton-onTouchEvent---MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("wenhao", "MyButton-onTouchEvent---UP");
                break;
            default:
                break;
        }

        boolean flag = super.onTouchEvent(event);
        Log.d("wenhao", "MyButton-onTouchEvent...value = " + flag);
        return flag;
    }
}
