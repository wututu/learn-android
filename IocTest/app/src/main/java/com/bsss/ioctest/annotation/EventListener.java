package com.bsss.ioctest.annotation;

import java.lang.reflect.Method;

import android.view.View;
import android.view.View.OnClickListener;

public class EventListener implements OnClickListener {
    private Object handler;
    private String clickMethod;

    public EventListener(Object obj) {
        handler = obj;
    }

    public EventListener click(String method) {
        clickMethod = method;
        return this;
    }

    @Override
    public void onClick(View v) {
        invokeClickMethod(handler, clickMethod, v);
    }

    private static Object invokeClickMethod(Object handler, String methodName,
                                            Object... params) {
        if (handler == null)
            return null;
        Method method = null;

        try {
            method = handler.getClass().getDeclaredMethod(methodName,
                    View.class);
            if (method != null)
                return method.invoke(handler, params);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
