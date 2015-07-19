package com.leochin.ottodemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Produce;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by wenhao on 6/1/15.
 */
public class OtherActivity extends Activity {

    @InjectView(R.id.other_text) TextView showTextView;
    @InjectView(R.id.other_plus_button) Button plusButton;
    @InjectView(R.id.other_back_button)Button backButton;

    private int count = 100;

    public static void launch(Context context){
        Intent intent = new Intent(context, OtherActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
        Log.d("leochin", "register bus...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
        Log.d("leochin", "unregister bus...");
    }

    @OnClick(R.id.other_back_button)
    public void onBackPress() {
        finish();
    }

    @OnClick(R.id.other_plus_button)
    public void onPlusPress() {
        count++;
        showTextView.setText(count+"");

//        Bundle bundle = new Bundle();
//        bundle.putInt("count", count);
//        BusProvider.getInstance().post(bundle);
        BusProvider.getInstance().post(produceCount());
    }

    /**
     *
     * 产生事件，
     * 该方法在对象被register前即被调用，该方法必须有一个非空的返回值，参数必须为空。
     *
     * 除非对构造事件初始值有特殊需求，可以用该方式
     *
     * @return
     */
    @Produce
    public Bundle produceCount() {
        Log.d("leochin", "produceCount...");
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);
        return bundle;
    }

}
