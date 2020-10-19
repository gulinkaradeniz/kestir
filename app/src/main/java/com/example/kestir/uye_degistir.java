package com.example.kestir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class uye_degistir extends AppCompatActivity {
    EditText adsoyad,telefon;
    Button düzenle;
    ListView uyeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uye_degistir);
        adsoyad=findViewById(R.id.adsoyad);
        telefon=findViewById(R.id.telefon);
        düzenle=findViewById(R.id.düzenle);
        uyeler=findViewById(R.id.uyeler);
        veri_tabani veri_tabani=new veri_tabani(uye_degistir.this);
        List<String> Veriler=veri_tabani.Veriler2();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(uye_degistir.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
        uyeler.setAdapter(adapter);
        uyeler.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                if (v.getId() == R.id.uyeler) ;
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                menu.setHeaderTitle(uyeler.getItemAtPosition(info.position).toString());
                menu.add(0, 0, 0, "DÜZENLE");
                menu.add(0, 1, 0, "SİL");
            }
        });
    }
    public boolean onContextItemSelected(MenuItem item)
    {
        boolean donus;
        switch (item.getItemId())
        {
            case 0:
                AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                final String secili=uyeler.getItemAtPosition(info.position).toString();
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Veri");
                builder.setMessage("\""+secili+"\" adlı veri düzenlensin mi?");
                builder.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi=secili.split("-");
                        final long secilen_id=Long.parseLong(dizi[0].trim());
                        String secilen_adsoyad=dizi[1].trim();
                        String secilen_telefon=dizi[2].trim();
                        adsoyad.setText(secilen_adsoyad);
                        telefon.setText(secilen_telefon);
                        veri_tabani veri_tabani=new veri_tabani(uye_degistir.this);
                        düzenle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String adsoyad1=adsoyad.getText().toString();
                                String telefon1=telefon.getText().toString();
                                Musteri uye2 =new Musteri(adsoyad1,telefon1);
                                if(adsoyad1.equals("")||telefon1.equals("")){
                                    Toast.makeText(uye_degistir.this, "BOŞ ALAN BIRAKMAYINIZ", Toast.LENGTH_SHORT).show();
                                }else{
                                    veri_tabani veri_tabani= new veri_tabani(getApplicationContext());
                                    veri_tabani.update_uyeler(adsoyad1,telefon1,secilen_id);
                                    List<String> Veriler=veri_tabani.Veriler2();
                                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(uye_degistir.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                                    uyeler.setAdapter(adapter);
                                }

                            }
                        });
                    }
                });
                builder.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
                donus=true;
                break;
            case 1:
                AdapterView.AdapterContextMenuInfo info1=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                final String secili1=uyeler.getItemAtPosition(info1.position).toString();
                AlertDialog.Builder builder1=new AlertDialog.Builder(this);
                builder1.setTitle("Veri");
                builder1.setMessage("\""+secili1+"\" adlı veriyi silmek istediğinize emin misiniz?");
                builder1.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi=secili1.split("-");
                        long id=Long.parseLong(dizi[0].trim());
                        veri_tabani veri_tabani=new veri_tabani(uye_degistir.this);
                        veri_tabani.uyesil(id);
                        final List<String> Veriler = veri_tabani.Veriler2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(uye_degistir.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        uyeler.setAdapter(adapter);
                    }
                });
                builder1.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog1=builder1.create();
                dialog1.show();
                donus=true;

                break;
            default:
                donus=false;
                break;

        }
        return donus;
    }
}