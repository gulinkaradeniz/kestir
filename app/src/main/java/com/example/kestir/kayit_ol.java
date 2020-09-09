package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class kayit_ol extends AppCompatActivity {

    EditText et_adsoyad,et_mail,et_telefon,et_sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kayit_ol);

        et_adsoyad=findViewById(R.id.et_adsoyad);
        et_mail=findViewById(R.id.et_mail);
        et_telefon=findViewById(R.id.et_telefon);
        et_sifre=findViewById(R.id.et_sifre);

    }
    public void gonder_kayit_ol(View view) {
        String adsoyad=et_adsoyad.getText().toString();
        String mail=et_mail.getText().toString();
        String telefon=et_telefon.getText().toString();
        String sifre=et_sifre.getText().toString();

        Müsteri müsteri=new Müsteri(adsoyad,mail,telefon,sifre);


        try {

            if(adsoyad.equals("")||mail.equals("")||telefon.equals("")||sifre.equals("")){
                Toast.makeText(kayit_ol.this, "BOŞ YERLERİ DOLDURUNUZ.", Toast.LENGTH_SHORT).show();
            }
            else{
                veri_tabani db= new veri_tabani(getApplicationContext());
                boolean id=db.KayitEkle(müsteri);
                Intent intent=new Intent(getApplicationContext(), giris.class);
                startActivity(intent);


            }

            /*if (id==-1){
                Toast.makeText(kayit_ol.this, "HATA", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(kayit_ol.this, "Kayıt işlemi başarılı.", Toast.LENGTH_SHORT).show();
            }*/

        }catch (Exception e){
            Toast.makeText(kayit_ol.this, "HAY AKSİ", Toast.LENGTH_SHORT).show();

        }


        et_adsoyad.setText("");
        et_mail.setText("");
        et_telefon.setText("");
        et_sifre.setText("");

    }
}