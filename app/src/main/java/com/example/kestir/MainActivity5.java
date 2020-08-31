package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    private CheckBox checkBox2,checkBox3,checkBox4,checkBox5,checkBox6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        checkBox5=findViewById(R.id.checkBox5);
        checkBox6=findViewById(R.id.checkBox6);


        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity5.this, "Saç Kesimi seçildi.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity5.this, "Saç Kesimi iptal edildi.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void gonder5(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity6.class);
        startActivity(intent);
    }

    public void gonder7(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}