package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import android.app.Activity;
import java.util.Calendar;


public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar calNow = Calendar.getInstance();
        int dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK);
        int currentYear = calNow.get(Calendar.YEAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

}