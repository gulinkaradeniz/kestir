package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.SAAT;
import static com.example.kestir.veri_tabani2.TELNO;

public class randevular extends AppCompatActivity {
    Button button_islem_onay;
    ListView islemler;
    TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevular);

        textView7=findViewById(R.id.textView7);
        Intent al= getIntent();
        String alinan=al.getStringExtra("telno");
        textView7.setText(alinan);

        islemler=findViewById(R.id.islemler);
        button_islem_onay=findViewById(R.id.button_islem_onay);
        button_islem_onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telno=textView7.getText().toString();
                /*veri_tabani2 db = new veri_tabani2(getApplicationContext());
                boolean Telno = db.Telno(telno);
                if(Telno){*/
                    veri_tabani2 veri_tabani2=new veri_tabani2(randevular.this);
                    List<String> Veriler=veri_tabani2.VeriListele(telno);
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(randevular.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                    islemler.setAdapter(adapter);

            }
        });




    }
}