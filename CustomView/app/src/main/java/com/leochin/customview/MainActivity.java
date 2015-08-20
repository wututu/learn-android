package com.leochin.customview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by wenhao on 7/21/15.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

//        final View text = findViewById(R.id.text2);
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewGroup.LayoutParams lp =  text.getLayoutParams();
//                Log.d("wenhao", "lp == " + lp);
//                lp.width = 350;
//                lp.height = 350;
//                text.setLayoutParams(lp);
//            }
//        });


//        mHandler = new Handler() {
//
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//
//                if (runFlag) {
//                    run();
//                    sendEmptyMessageDelayed(1, 100);
//                }
//            }
//        };
//        initCustom();
    }


    private Handler mHandler;
    private CustomView view;
    private Button startButton;
    private Button stopButton;

    private boolean runFlag = true;
    private float radius = 0;


    private void run() {
        radius = radius + 10;
        view.setCircleRadius(radius);

        if (radius >= 170) {
            radius = 0;
        }
    }

    private void initCustom() {
        view = (CustomView) findViewById(R.id.custom_view);
        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                runFlag = true;
                mHandler.sendEmptyMessageDelayed(1, 100);
                break;
            case R.id.stop_button:
                runFlag = false;
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
