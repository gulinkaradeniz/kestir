package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.SAAT;
import static com.example.kestir.veri_tabani2.TARIH;

public class islem_secimi extends AppCompatActivity {
    private CheckBox checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    Button button_islem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.islem_secimi);

        //long id2=db2.Ekle(ISLEM+"-"+"Saç Boyama",SAAT,TARIH);

        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        button_islem = findViewById(R.id.button_islem);

        final veri_tabani2 db2 = new veri_tabani2(getApplicationContext());
        String c2;


    }
    public void gonder_islem_secimi(View view) {
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(((CheckBox)compoundButton).isChecked())
                {
                    Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
                    startActivity(intent);
                    String islem=((CheckBox)compoundButton).getText().toString();
                    intent.putExtra("SacKesimi",islem);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(((CheckBox)compoundButton).isChecked())
                {
                    Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
                    startActivity(intent);
                    String islem=((CheckBox)compoundButton).getText().toString();
                    intent.putExtra("SacBoyama",islem);
                }
            }
        });
    }


    /*public void gonder_islem_onay(View view) {
        final Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
        startActivity(intent);
        final Object iptalislem = null;

        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
                startActivity(intent);
                intent.putExtra("SacBoyama",islem);
                Toast.makeText(islem_secimi.this, "Saç Boyama seçildi.", Toast.LENGTH_SHORT).show();


    }*/
}
