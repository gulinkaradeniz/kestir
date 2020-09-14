package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class admin_anasayfa extends AppCompatActivity {
    Button button_admin_anasayfa;
    ListView admin_anasayfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_anasayfa);

        button_admin_anasayfa=findViewById(R.id.button_admin_anasayfa);
        admin_anasayfa=findViewById(R.id.admin_anasayfa);
        button_admin_anasayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veri_tabani2 veri_tabani2=new veri_tabani2(admin_anasayfa.this);
                List<String> Veriler=veri_tabani2.VeriListele2();
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(admin_anasayfa.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                admin_anasayfa.setAdapter(adapter);
            }
        });

    }
}