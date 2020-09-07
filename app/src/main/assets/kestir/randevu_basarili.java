package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class randevu_basarili extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevu_basarili);
    }

    public void gonder_uye_anasayfa(View view) {
        Intent intent=new Intent(getApplicationContext(), uye_anasayfa.class);
        startActivity(intent);
    }
}