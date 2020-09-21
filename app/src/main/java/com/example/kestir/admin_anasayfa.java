package com.example.kestir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class admin_anasayfa extends AppCompatActivity {
    Custom_adapter custom_adapter;
    ListView listview;
    veri_tabani veri_tabani;
    ArrayList<String> islem,tarih,saat,telno,ad_soyad,_id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_anasayfa);
            listview=findViewById(R.id.listview);
            veri_tabani veri_tabani=new veri_tabani(admin_anasayfa.this);
            List<String> Veriler=veri_tabani.VeriListele2();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(admin_anasayfa.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
            listview.setAdapter(adapter);

            /*veri_tabani=new veri_tabani(admin_anasayfa.this);
            _id2=new ArrayList<>();
            islem=new ArrayList<>();
            tarih=new ArrayList<>();
            saat=new ArrayList<>();
            telno=new ArrayList<>();
            ad_soyad=new ArrayList<>();

        storeDataInArrays();

            custom_adapter =new Custom_adapter(admin_anasayfa.this,islem,tarih,saat,telno,ad_soyad,_id2);
            recyclerView.setAdapter(custom_adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(admin_anasayfa.this));*/


    }
    /*void storeDataInArrays(){
        Cursor cursor=veri_tabani.readAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                islem.add(cursor.getString(1));
                tarih.add(cursor.getString(2));
                saat.add(cursor.getString(3));
                telno.add(cursor.getString(4));
                ad_soyad.add(cursor.getString(6));
            }
        }
    }*/
}