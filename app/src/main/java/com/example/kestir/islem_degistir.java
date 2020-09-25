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

public class islem_degistir extends AppCompatActivity {
    EditText islem1,islem_saati;
    Button ekle,düzenle;
    ListView islemler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.islem_degistir);
        islem1=findViewById(R.id.islem1);
        düzenle=findViewById(R.id.düzenle);
        islem_saati=findViewById(R.id.islem_saati);
        ekle=findViewById(R.id.ekle);
        islemler=findViewById(R.id.islemler);
        islemler_veri_tabani islemler_veri_tabani=new islemler_veri_tabani(islem_degistir.this);
        List<String> Veriler=islemler_veri_tabani.İslemListele();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(islem_degistir.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
        islemler.setAdapter(adapter);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String islem=islem1.getText().toString();
                String islemsaati=islem_saati.getText().toString();
                islemler_veri_tabani db2;
                Islem islem2 =new Islem(islem,islemsaati);
                if(islem.equals("")||islemsaati.equals("")){
                    Toast.makeText(islem_degistir.this, "BOŞ ALAN BIRAKMAYINIZ", Toast.LENGTH_SHORT).show();
                }else{
                    db2= new islemler_veri_tabani(getApplicationContext());
                    boolean id=db2.IslemEkle(islem2);
                    islemler_veri_tabani islemler_veri_tabani=new islemler_veri_tabani(islem_degistir.this);
                    List<String> Veriler=islemler_veri_tabani.İslemListele();
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(islem_degistir.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                    islemler.setAdapter(adapter);
                }

            }
        });
        islemler.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                if (v.getId() == R.id.islemler) ;
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                menu.setHeaderTitle(islemler.getItemAtPosition(info.position).toString());
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
                final String secili=islemler.getItemAtPosition(info.position).toString();
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Veri");
                builder.setMessage("\""+secili+"\" adlı veri düzenlensin mi?");
                builder.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi=secili.split("-");
                        final long secilen_id=Long.parseLong(dizi[0].trim());
                        String secilen_islem=dizi[1].trim();
                        String secilen_islemsaati=dizi[2].trim();
                        islem1.setText(secilen_islem);
                        islem_saati.setText(secilen_islemsaati);
                        islemler_veri_tabani islemler_veri_tabani=new islemler_veri_tabani(islem_degistir.this);
                        düzenle.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String islem=islem1.getText().toString();
                                String islemsaati=islem_saati.getText().toString();
                                Islem islem2 =new Islem(islem,islemsaati);
                                if(islem.equals("")||islemsaati.equals("")){
                                    Toast.makeText(islem_degistir.this, "BOŞ ALAN BIRAKMAYINIZ", Toast.LENGTH_SHORT).show();
                                }else{
                                    islemler_veri_tabani islemler_veri_tabani= new islemler_veri_tabani(getApplicationContext());
                                    islemler_veri_tabani.update_islemler(islem,islemsaati,secilen_id);
                                    List<String> Veriler=islemler_veri_tabani.İslemListele();
                                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(islem_degistir.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                                    islemler.setAdapter(adapter);
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
                final String secili1=islemler.getItemAtPosition(info1.position).toString();
                AlertDialog.Builder builder1=new AlertDialog.Builder(this);
                builder1.setTitle("Veri");
                builder1.setMessage("\""+secili1+"\" adlı veriyi silmek istediğinize emin misiniz?");
                builder1.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi=secili1.split("-");
                        long id=Long.parseLong(dizi[0].trim());
                        islemler_veri_tabani islemler_veri_tabani=new islemler_veri_tabani(islem_degistir.this);
                        islemler_veri_tabani.verisil(id);
                        final List<String> Veriler = islemler_veri_tabani.İslemListele();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(islem_degistir.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        islemler.setAdapter(adapter);
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