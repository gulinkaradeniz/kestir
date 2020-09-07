package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.GregorianCalendar;
public class uye_anasayfa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uye_anasayfa);

    }

    public void gonder_islem_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), islem_secimi.class);
        startActivity(intent);
    }
}