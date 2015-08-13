package com.leochin.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wenhao on 7/21/15.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View text = findViewById(R.id.text2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("wenhao", "text size = " + text.getWidth() + "," + text.getHeight());
//                Log.d("wenhao", "text size2 = " + text.getMeasuredWidth() + "," + text.getMeasuredHeight());
                ViewGroup.LayoutParams lp =  text.getLayoutParams();
                Log.d("wenhao", "lp == " + lp);
                lp.width = 350;
                lp.height = 350;
                text.setLayoutParams(lp);
            }
        });
    }
}
