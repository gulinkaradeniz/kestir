package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class saat_secimi extends AppCompatActivity {
    CustomerModel customerModel;
    Button button_saat_onay;
    RadioGroup saatler,radiobutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saat_secimi);
        button_saat_onay=findViewById(R.id.button_saat_onay);
        saatler=findViewById(R.id.saatler);
    }


    public void gonder_randevu_basarili(View view) {
        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
        startActivity(intent);

        Toast.makeText(saat_secimi.this,"Randevu oluşturuldu",Toast.LENGTH_SHORT).show();

        veri_tabani veri_tabani= new veri_tabani(saat_secimi.this);
        boolean success = veri_tabani.addOne(customerModel);
        Toast.makeText(saat_secimi.this,"Success=",Toast.LENGTH_SHORT).show();
    }
}