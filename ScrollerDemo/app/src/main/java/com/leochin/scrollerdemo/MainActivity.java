package com.leochin.scrollerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ScrollerView mScrollerView;
    private Button mLeftButton;
    private Button mRightButton;
    private Button mTopButton;
    private Button mDownButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mScrollerView = (ScrollerView) findViewById(R.id.scroller_view);
        mLeftButton = (Button) findViewById(R.id.button_left);
        mRightButton = (Button) findViewById(R.id.button_right);
        mTopButton = (Button) findViewById(R.id.button_top);
        mDownButton = (Button) findViewById(R.id.button_down);

        mLeftButton.setOnClickListener(this);
        mRightButton.setOnClickListener(this);
        mTopButton.setOnClickListener(this);
        mDownButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_left:
                mScrollerView.move(ScrollerView.MOVE_MODE_LEFT);
                break;
            case R.id.button_right:
                mScrollerView.move(ScrollerView.MOVE_MODE_RIGHT);
                break;
            case R.id.button_top:
                mScrollerView.move(ScrollerView.MOVE_MODE_TOP);
                break;
            case R.id.button_down:
                mScrollerView.move(ScrollerView.MOVE_MODE_DOWN);
                break;
            default:
                break;
        }
    }
}
