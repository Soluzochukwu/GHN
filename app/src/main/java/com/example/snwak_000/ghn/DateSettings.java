package com.example.snwak_000.ghn;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by snwak_000 on 2017-11-08.
 */

public class DateSettings implements DatePickerDialog.OnDateSetListener{
    Context context;
    public DateSettings(Context context){
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(context, ""+ i2 + "/" + i1 + "/" + i, Toast.LENGTH_LONG).show();
    }
}
