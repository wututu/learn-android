package com.bsss.ioctest.annotation;

import java.lang.reflect.Field;

import android.app.Activity;
import android.view.View;

public class ViewUtils {

	public static void inject(Activity activity) {
		Field[] fields = activity.getClass().getDeclaredFields();

		if ((fields != null) && (fields.length > 0)) {
			for (Field field : fields) {
				try {
					ViewInject viewInject = field
							.getAnnotation(ViewInject.class);

					if (viewInject != null) {
						int id = viewInject.id();// set the view id
						String methodName = viewInject.click();
						View view = activity.findViewById(id);

						if (view != null) {
							field.setAccessible(true);
							field.set(activity, view);
						}

						Object obj = (View) field.get(activity);
						if (obj instanceof View) {
							((View) obj).setOnClickListener(new EventListener(activity).click(methodName));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
