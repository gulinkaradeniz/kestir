package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class giris extends AppCompatActivity {

    EditText et_telefon_giris,et_sifre_giris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);

        et_telefon_giris=findViewById(R.id.et_telefon_giris);
        et_sifre_giris=findViewById(R.id.et_sifre_giris);


    }
    public void gonder_girisyap(View view) {
        String telefon_giris=et_telefon_giris.getText().toString();
        String sifre_giris=et_sifre_giris.getText().toString();

        Intent al=getIntent();
        String alinanbilgi1=al.getStringExtra("telefon_bilgi");
        String alinanbilgi2=al.getStringExtra("sifre_bilgi");

        if (telefon_giris.equals(alinanbilgi1)||sifre_giris.equals(alinanbilgi2)){
            Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(), uye_anasayfa.class);
            startActivity(intent);
        }

        else{
        Toast.makeText(this, "Telefon ve şifrenizi kontrol ediniz.", Toast.LENGTH_SHORT).show();}
    }
    public void gonder_giris(View view) {
            Intent intent=new Intent(getApplicationContext(), kayit_ol.class);
        startActivity(intent);

    }

    public void gonder_sifre_yenile(View view) {
        Intent intent=new Intent(getApplicationContext(), saat_secimi.class);
        startActivity(intent);
    }

    public void gonder_islem_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
        startActivity(intent);
    }

}