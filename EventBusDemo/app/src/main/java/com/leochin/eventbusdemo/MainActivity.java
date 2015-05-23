package com.leochin.eventbusdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.show_text)
    TextView showText;
    @InjectView(R.id.jump_button)
    Button jumpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(String text) {
        Log.e("wenhao", "text = " + text + ",threadName = " + Thread.currentThread().getName());
        showText.setText(text);
    }

    @OnClick(R.id.jump_button)
    public void jump() {
        OtherActivity.open(this);
    }
}
