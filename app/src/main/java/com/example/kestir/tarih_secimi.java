package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.TARIH;


public class tarih_secimi extends AppCompatActivity {
    CalendarView calendar;
    private Object CalendarView;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar calNow = Calendar.getInstance();
        int dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK);
        int currentYear = calNow.get(Calendar.YEAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarih_secimi);

        calendar =(CalendarView)findViewById(R.id.calendar);


    }
    public void gonder_saat_secimi(final View view) {
        String date=calendar.toString();
        final İslemler i̇slemler=new İslemler(İslemler.getTarih());
        //final String date=CalendarView.toString();
        //final İslemler islem=new İslemler(date);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( android.widget.CalendarView calendarView, int i, int i1, int i2) {
                String date=(i+"/"+i1+"/"+i2);
                veri_tabani2 db2= new veri_tabani2(getApplicationContext());
                long id2=db2.Tarih_Ekle(i̇slemler);

            }
        });
        Intent intent=new Intent(getApplicationContext(), saat_secimi.class);
        startActivity(intent);


    }
}