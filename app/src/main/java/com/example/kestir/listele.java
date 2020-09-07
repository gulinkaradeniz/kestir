package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class listele extends AppCompatActivity {

    veri_tabani veri_tabani;
    ListView list_liste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listele);
        //Verilerin listelenmesi
        ListView list_liste=(ListView) findViewById(R.id.list_liste);
        int idler[]={R.id.tv_adsoyad,R.id.tv_mail,R.id.tv_telefon,R.id.tv_sifre};
        String kolonlar[] ={veri_tabani.AD,veri_tabani.MAIL,veri_tabani.TELEFON,veri_tabani.SIFRE};
        veri_tabani db=new veri_tabani(this);
        Cursor cursor =db.getTumKayitlarCursor();
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.custom_list,cursor,kolonlar,idler);
        list_liste.setAdapter(adapter);


    }
}
