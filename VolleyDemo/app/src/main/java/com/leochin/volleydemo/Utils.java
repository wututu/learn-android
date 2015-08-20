package com.leochin.volleydemo;

import java.util.Calendar;

/**
 * Created by wenhao on 8/21/15.
 */
public class Utils {

    public static String getDateToGetUrl() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return Constants.simpleDateFormat.format(calendar.getTime());
    }
}
