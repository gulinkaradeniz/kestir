package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class geldi extends AppCompatActivity {
    ListView geldi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geldi);
        geldi=findViewById(R.id.listgeldi);
        final veri_tabani veri_tabani=new veri_tabani(geldi.this);
        final List<String> veriler=veri_tabani.VeriListeleGeldi();
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(geldi.this,android.R.layout.simple_list_item_1,android.R.id.text1,veriler);
        geldi.setAdapter(adapter);

    }
}