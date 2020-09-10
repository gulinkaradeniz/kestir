package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sifre_yenile extends AppCompatActivity {

    EditText Telefon_yenile,Sifre_yenile;
    Button button_sifre_yenile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sifre_yenile);
        Telefon_yenile=findViewById(R.id.Telefon_yenile);
        Sifre_yenile=findViewById(R.id.Sifre_yenile);
        button_sifre_yenile=findViewById(R.id.button_sifre_yenile);

    }

    public void gonder_sifre_yenile2(View view) {
        String telefonyenile=Telefon_yenile.getText().toString();
        String sifreyenile=Sifre_yenile.getText().toString();
        veri_tabani db = new veri_tabani(getApplicationContext());
        boolean Telefonno = db.Telefonno(telefonyenile);
        Log.d("test", "gonder_sifre_yenile: "+String.valueOf(telefonyenile));
        if(Telefonno){
            boolean Sifreyenile = db.Sifreyenile(telefonyenile,sifreyenile);
            if(Sifreyenile==true){
                if(sifreyenile.length()<6){
                    Sifre_yenile.setText("");
                    Toast.makeText(sifre_yenile.this, "ŞİFRENİZ 6 KARAKTERDEN KÜÇÜK OLMAMALI.", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(sifre_yenile.this, "ŞİFRENİZ YENİLENMİŞTİR.", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(), giris.class);
                    startActivity(intent);
                }
            }

        }else{
            Toast.makeText(sifre_yenile.this, "BU NUMARAYA AİT KAYIT BULUNMAMAKTADIR.", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(getApplicationContext(), kayit_ol.class);
            startActivity(intent);
        }

    }

}