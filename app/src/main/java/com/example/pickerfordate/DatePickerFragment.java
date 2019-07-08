package com.example.pickerfordate;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        // Use the current date as the default date in the picker.
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Creates a new instance of the DatePickerDialog and returns it.
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    /**
     *  Calls whenever the user sets the date.
     *
     *  You use getActivity() which, when used in a Fragment, returns the Activity the Fragment is
     *  currently associated with. You need this because you can't call a method in MainActivity
     *  without the context of MainActivity (you would have to use an intent instead, as you learned
     *  in another lesson). The Activity inherits the context, so you can use it as the context for
     *  calling the method (as in activity.processDatePickerResult).
     */

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.datePickerResult(year, month, dayOfMonth);
    }
}
