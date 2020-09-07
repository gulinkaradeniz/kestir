package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class islem_secimi extends AppCompatActivity {
    private CheckBox checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.islem_secimi);

        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);


        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(islem_secimi.this, "Saç Kesimi seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(islem_secimi.this, "Saç Kesimi iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(islem_secimi.this, "Saç Boyama seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(islem_secimi.this, "Saç Boyama iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(islem_secimi.this, "Fön seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(islem_secimi.this, "Fön iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(islem_secimi.this, "Kaş Bıyık seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(islem_secimi.this, "Kaş Bıyık iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(islem_secimi.this, "Makyaj seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(islem_secimi.this, "Makyaj iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void gonder_tarih_secimi(View view) {
        Intent intent=new Intent(getApplicationContext(), tarih_secimi.class);
        startActivity(intent);
    }

}