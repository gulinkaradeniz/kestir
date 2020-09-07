package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.SAAT;

public class randevular extends AppCompatActivity {
    Button button_listele;
    RadioGroup r1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevular);

        button_listele=findViewById(R.id.button_listele);
        button_listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });




    }
}