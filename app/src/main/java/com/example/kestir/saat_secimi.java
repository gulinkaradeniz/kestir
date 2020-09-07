package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.SAAT;

public class saat_secimi extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7,radioButton8,radioButton9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saat_secimi);

        final RadioGroup group= (RadioGroup) findViewById(R.id.saatler);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = group.getCheckedRadioButtonId();
                veri_tabani2 db2= new veri_tabani2(getApplicationContext());

                switch (id){
                    case R.id.radioButton:
                        Toast.makeText(saat_secimi.this, "saat:10:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"10:00");
                        }
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(saat_secimi.this, "saat:11:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"11:00");
                        }
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(saat_secimi.this, "saat:12:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"12:00");
                        }
                        break;
                    case R.id.radioButton4:
                        Toast.makeText(saat_secimi.this, "saat:13:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"13:00");
                        }
                        break;
                    case R.id.radioButton5:
                        Toast.makeText(saat_secimi.this, "saat:14:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"14:00");
                        }
                        break;
                    case R.id.radioButton6:
                        Toast.makeText(saat_secimi.this, "saat:15:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"15:00");
                        }
                        break;
                    case R.id.radioButton7:
                        Toast.makeText(saat_secimi.this, "saat:16:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"16:00");
                        }
                        break;
                    case R.id.radioButton8:
                        Toast.makeText(saat_secimi.this, "saat:17:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"17:00");
                        }
                        break;
                    case R.id.radioButton9:
                        Toast.makeText(saat_secimi.this, "saat:18:00", LENGTH_SHORT).show();
                        if (id!=0){
                            long id2=db2.Ekle(ISLEM,SAAT+"-"+"18:00");
                        }
                        break;
                    default:
                        Toast.makeText(saat_secimi.this, "BİR SAAT SEÇİNİZ", LENGTH_SHORT).show();
                        break; }
            }
        } );
    }

    public void gonder_randevu_basarili(View view) {
        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
        startActivity(intent);

    }
}