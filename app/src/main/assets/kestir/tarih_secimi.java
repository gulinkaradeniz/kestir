package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;


public class tarih_secimi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Calendar calNow = Calendar.getInstance();
        int dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK);
        int currentYear = calNow.get(Calendar.YEAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarih_secimi);

    }
    public void gonder_saat_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), saat_secimi.class);
        startActivity(intent);
    }
}