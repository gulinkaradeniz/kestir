package com.example.kestir;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class randevu_basarili extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevu_basarili);

    }

    public void gonder_randevu_basarili(View view) {
        Intent intent=new Intent(getApplicationContext(), giris.class);
        startActivity(intent);

    }
}