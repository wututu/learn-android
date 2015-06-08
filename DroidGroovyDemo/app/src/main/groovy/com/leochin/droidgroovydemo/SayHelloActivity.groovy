package com.leochin.droidgroovydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

public class SayHelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayhello);

        def intent = getIntent();
        def name = intent.getStringExtra(MainActivity.BUNDLE_PARAM_NAME)

        def messageTextView = findViewById(R.id.message) as TextView
        messageTextView.text = "Hello ${name}!".toString()

        def closeButton = findViewById(R.id.close_btn) as Button
        closeButton.onClickListener = {
            finish();
        }

    }

}