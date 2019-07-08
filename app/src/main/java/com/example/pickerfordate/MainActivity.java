package com.example.pickerfordate;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void datePickerResult(int year, int month, int day){
        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String date = day_string + "/" + month_string + "/" + year_string;

        // The month integer returned by the date picker starts counting at 0 for January,
        // so you need to add 1 to it to show months starting at 1.

        Toast.makeText(this, "Date is " + date, Toast.LENGTH_SHORT).show();
    }


    public void showTimePicker(View view) {
        DialogFragment timeFragment = new TimePickerFragment();
        // To display the timePicker on the screen.
        timeFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void timePickerResult(int hour, int minutes){
        String hour_string = Integer.toString(hour);
        String minutes_string = Integer.toString(minutes);
        String time = hour_string + ":" + minutes_string;

        Toast.makeText(this, "Time is " + time, Toast.LENGTH_SHORT).show();
    }
}
