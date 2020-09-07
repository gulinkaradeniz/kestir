package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class giris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);
    }
    public void gonder_kayit_ol(View view) {
            Intent intent=new Intent(getApplicationContext(), kayit_ol.class);
            startActivity(intent);

    }

    public void gonder_sifre_yenile(View view) {
        Intent intent=new Intent(getApplicationContext(), sifre_yenile.class);
        startActivity(intent);
    }

    public void gonder_islem_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), islem_secimi.class);
        startActivity(intent);
    }
}