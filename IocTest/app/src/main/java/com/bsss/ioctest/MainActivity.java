package com.bsss.ioctest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.bsss.ioctest.annotation.ViewInject;
import com.bsss.ioctest.annotation.ViewUtils;

public class MainActivity extends Activity {
    @ViewInject(id = R.id.button1, click = "button1Clicked")
    private Button button1;

    @ViewInject(id = R.id.button2)
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button2 Click",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void button1Clicked(View view) {
        Toast.makeText(MainActivity.this, "Button1 Click", Toast.LENGTH_SHORT)
                .show();
    }
}
