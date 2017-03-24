package com.leochin.boltsdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;

public class MainActivity extends AppCompatActivity {

    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initView();

        test();
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.body);
    }

    private void println(String content) {
        StringBuilder builder = new StringBuilder();
        CharSequence rawContent = mText.getText();
        builder.append(rawContent);
        builder.append("\n");
        builder.append(content);
        mText.setText(builder.toString());
    }

    private void test() {
        Task.call(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                println("Thread ... " + Thread.currentThread().getName());
                return null;
            }
        }).onSuccess(new Continuation<Object, Object>() {

            @Override
            public Object then(Task<Object> task) throws Exception {
                println("onSucces then");
                return null;
            }
        });

        Task.callInBackground(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                println("Thread2 ... " + Thread.currentThread().getName());
                return null;
            }
        });

        Task.call(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                println("Thread3 ... " + Thread.currentThread().getName());
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);

        Task.call(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                println("Task.call...");
                return null;
            }
        }).onSuccessTask(new Continuation<Object, Task<Object>>() {
            @Override
            public Task<Object> then(Task<Object> task) throws Exception {

                return null;
            }
        });
    }
}
