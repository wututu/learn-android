package com.leochin.eventbusdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by wenhao on 5/23/15.
 */
public class OtherActivity extends AppCompatActivity {

    @InjectView(R.id.show_text)
    TextView showText;
    @InjectView(R.id.plus_button)
    Button plusButton;
    @InjectView(R.id.close_button) Button closeButton;

    private int count;

    public static void open(Context context) {
        Intent intent = new Intent(context, OtherActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @OnClick(R.id.plus_button)
    public void plus(){
        count++;
        showText.setText(String.valueOf(count));
    }

    @OnClick(R.id.close_button)
    public void close() {
        EventBus.getDefault().post(String.valueOf(count));
        finish();
    }
}
