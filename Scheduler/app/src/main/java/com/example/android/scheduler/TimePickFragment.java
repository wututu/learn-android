package com.example.android.scheduler;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.TimePicker;

import java.util.Calendar;

import de.greenrobot.event.EventBus;

/**
 * Created by wenhao on 7/17/15.
 */
public class TimePickFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog dailog = new TimePickerDialog(getActivity(), this, hour, minute, true);
        dailog.setTitle("打卡提醒时间");
        return dailog;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("wenhao", "haha..." + hourOfDay + "," + minute);
        BaseTime time = new BaseTime(hourOfDay, minute);
        EventBus.getDefault().post(time);
    }
}
