package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.os.Bundle;

public class MainActivity7 extends AppCompatActivity {
    TimePicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        picker = (TimePicker)findViewById(R.id.datePicker1);
        picker.setIs24HourView(true);
    }

}