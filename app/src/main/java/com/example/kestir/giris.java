package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class giris extends AppCompatActivity {

    EditText et_telefon_giris,et_sifre_giris;
    private veri_tabani db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);

        et_telefon_giris=findViewById(R.id.et_telefon_giris);
        et_sifre_giris=findViewById(R.id.et_sifre_giris);
        db = new veri_tabani(getApplicationContext());
    }
    public void gonder_giris(View view) {
        Intent intent=new Intent(getApplicationContext(), kayit_ol.class);
        startActivity(intent);

    }

    public void gonder_sifre_yenile(View view) {
        Intent intent=new Intent(getApplicationContext(), sifre_yenile.class);
        startActivity(intent);
    }

    public void gonder_islem_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
        startActivity(intent);
    }


    public void gonder_girisyap(View view) {

        String telefon_giris=et_telefon_giris.getText().toString();
        String sifre_giris=et_sifre_giris.getText().toString();
        if(telefon_giris.equals("")||sifre_giris.equals("")){
            Toast.makeText(giris.this, "Telefon ve şifre giriniz.", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean Telefon_sifre = db.Telefon_sifre(telefon_giris, sifre_giris);
            Log.d("test", "gonder_girisyap: "+String.valueOf(Telefon_sifre));
            if (Telefon_sifre){
                Intent intent=new Intent(getApplicationContext(), uye_anasayfa.class);
                intent.putExtra("telno",telefon_giris);
                startActivity(intent);
            }
            else if(telefon_giris.equals("5558610317")&&sifre_giris.equals("admin1")){
                Intent intent=new Intent(getApplicationContext(), admin_anasayfa.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(giris.this, "BİLGİLERİNİZİ TEKRAR KONTROL EDİNİZ.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}