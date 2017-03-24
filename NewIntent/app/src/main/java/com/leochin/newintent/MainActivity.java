package com.leochin.newintent;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch(MainActivity.class);
            }
        });

        findViewById(R.id.intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch(NewIntentActivity.class);
            }
        });
    }
}
