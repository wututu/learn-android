package com.leochin.rxjava_demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseRxJavaUsage();
        baseSimpleRxJavaUsage();
        baseSimple2RxJavaUsage();
        baseMapRxJavaUsage();
        baseFromRxJavaUsage();
        baseFlatMapRxJavaUsage();
    }


    private void baseRxJavaUsage() {

        Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("Hello, World!");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e(TAG, Thread.currentThread().getName() + "," + s);
            }
        };


        myObservable.subscribe(mySubscriber);
    }

    private void baseSimpleRxJavaUsage() {

        Observable<String> myObservable = Observable.just("Hello, World! 2"); // 上面创建Observable的简写版

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.e(TAG, Thread.currentThread().getName() + "," + s);
            }
        };
        myObservable.subscribe(onNextAction); // 只关心onNext方法
    }

    private void baseSimple2RxJavaUsage() {

        /* 上面创建Observable的简写版 */
        Observable.just("Hello, World! 3")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(TAG, Thread.currentThread().getName() + "," + s);
                    }
                });
    }

    private void baseMapRxJavaUsage() {

        /* 实现对数据的转换 */
        Observable.just("Hello, World!")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + " -Hao";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(TAG, Thread.currentThread().getName() + "," + s);
                    }
                });
    }

    private void baseFromRxJavaUsage() {

        String[] fruits = new String[]{"apple", "banana", "orange"};
        /* 遍历array中的数据 */
        Observable.from(fruits)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(TAG, Thread.currentThread().getName() + "," + s);
                    }
                });
    }

    private void baseFlatMapRxJavaUsage() {

        /* 遍历array中的数据 */
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("white");

        Observable.just(colors)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> strings) {
                        Log.e(TAG, "ObserveOn..." + Thread.currentThread().getName());
                        return Observable.from(strings);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.e(TAG, Thread.currentThread().getName() + "," + s);
                    }
                });

    }

}
