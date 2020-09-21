package com.example.kestir;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class randevu_basarili extends AppCompatActivity {
    ListView listView;
    TextView textView10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevu_basarili);
        listView=findViewById(R.id.listView);
        textView10=findViewById(R.id.textView10);
        Intent al= getIntent();
        String alinan=al.getStringExtra("telno");
        textView10.setText(alinan);
        String telno=textView10.getText().toString();
        veri_tabani veri_tabani=new veri_tabani(randevu_basarili.this);
        List<String> Veriler=veri_tabani.VeriListele(telno);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(randevu_basarili.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
        listView.setAdapter(adapter);

    }

    public void gonder_randevu_basarili(View view) {
        Intent intent=new Intent(getApplicationContext(), giris.class);
        startActivity(intent);

    }
}