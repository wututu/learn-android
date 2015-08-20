package com.leochin.volleydemo;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by wenhao on 8/20/15.
 */
public class Constants {

    private Constants() {

    }

    public static final String ZHIHU_DAILY_BEFORE = "http://news.at.zhihu.com/api/3/news/before/";
    public static final String ZHIHU_DAILY_OFFLINE_NEWS = "http://news-at.zhihu.com/api/3/news/";

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
}
