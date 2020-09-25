package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        veri_tabani db = new veri_tabani(getApplicationContext());

        Musteri musteri =new Musteri(adsoyad,mail,telefon,sifre);

        boolean Telefonno = db.Telefonno(telefon);
        Log.d("test", "gonder_girisyap: "+String.valueOf(telefon));


        try {

            if(adsoyad.equals("")||mail.equals("")||telefon.equals("")||sifre.equals("")){
                Toast.makeText(kayit_ol.this, "BOŞ YERLERİ DOLDURUNUZ.", Toast.LENGTH_SHORT).show();
            }
            else{
                if(telefon.length()<=9){
                    et_telefon.setText("");
                    Toast.makeText(kayit_ol.this, "TELEFON NUMARANIZI KONTROL EDİNİZ.", Toast.LENGTH_LONG).show();
                }
                else if(Telefonno){
                    Toast.makeText(kayit_ol.this, "BU NUMARAYA AİT KAYIT BULUNMAKTADIR.", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(), sifre_yenile.class);
                    startActivity(intent);
                    et_adsoyad.setText("");
                    et_mail.setText("");
                    et_telefon.setText("");
                    et_sifre.setText("");
                }
                else if(sifre.length()<6){
                    et_sifre.setText("");
                    Toast.makeText(kayit_ol.this, "ŞİFRENİZ 6 KARAKTER OLMALI.", Toast.LENGTH_LONG).show();
                }
                else{
                db= new veri_tabani(getApplicationContext());
                boolean id=db.KayitEkle(musteri);
                //Toast.makeText(kayit_ol.this, "KAYIT BAŞARILI.", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), uye_anasayfa.class);
                intent.putExtra("telno",telefon);
                startActivity(intent);
                    et_adsoyad.setText("");
                    et_mail.setText("");
                    et_telefon.setText("");
                    et_sifre.setText("");
                }


            }
        }catch (Exception e){
            Toast.makeText(kayit_ol.this, "HAY AKSİ", Toast.LENGTH_SHORT).show();

        }



    }
}