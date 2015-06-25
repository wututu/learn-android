package com.leochin.animationhei;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private final int ROTATE_ANIM_DURATION = 180;

    private ImageView mImageView;
    private Button mButton;

    private boolean flag = true;

    private RotateAnimation mRotateUpAnim;
    private RotateAnimation mRotateDownAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageview);
        mButton = (Button) findViewById(R.id.button);

        initRotateAnim();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.clearAnimation();

                if(flag) {
                    mImageView.startAnimation(mRotateUpAnim);
                } else {
                    mImageView.startAnimation(mRotateDownAnim);
                }

                flag = !flag;
            }
        });
    }

    private void initRotateAnim() {
        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);

        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }
}
