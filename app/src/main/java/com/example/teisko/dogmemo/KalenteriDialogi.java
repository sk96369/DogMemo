package com.example.teisko.dogmemo;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Sampo on 1.12.2017.
 */

public class KalenteriDialogi extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        String date = day + "-" + (month + 1) + "-" + year;
        NewPlayer callingActivity = (NewPlayer)getActivity();
        callingActivity.onOk(date);
    }
}
