package com.example.kestir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.List;

public class randevu_basarili extends AppCompatActivity {
    veri_tabani veri_tabani;
    EditText name;
    Button button;
    ListView listView;

    //Butona basıldığında verinin eklenmesi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randevu_basarili);

        name=findViewById(R.id.name);
        button =findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                //veri_tabani = new veri_tabani(randevu_basarili.this);
                //veri_tabani.addOne(name.getText().toString());
                //String ad=name.getText().toString();
                Intent intent=new Intent(getApplicationContext(), listele.class);//Başka sayfaya veri aktarması için
                //final Intent intent1 = intent.putExtra(name);
                startActivity(intent);
            }
        });
    }

}