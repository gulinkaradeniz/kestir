package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class randevular extends AppCompatActivity {
    ListView listView;
    TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevular);
        listView=findViewById(R.id.listView);

        textView7=findViewById(R.id.textView7);
        Intent al= getIntent();
        String alinan=al.getStringExtra("telno");
        textView7.setText(alinan);

        String telno=textView7.getText().toString();
        veri_tabani veri_tabani=new veri_tabani(randevular.this);
        List<String> Veriler=veri_tabani.VeriListele(telno);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(randevular.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
        listView.setAdapter(adapter);



    }
}