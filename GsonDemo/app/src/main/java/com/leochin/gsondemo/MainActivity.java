package com.leochin.gsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textview);

        User user = new User("leochin", 18);
        Gson gson = new Gson();
        StringBuilder builder = new StringBuilder();

        String json = gson.toJson(user);
        builder.append(String.format("%s\n", json));
        mTextView.setText(builder.toString());

        User leo = gson.fromJson(json, User.class);
        leo.age = 21;
        builder.append(leo.toString());
        mTextView.setText(builder.toString());
    }
}
