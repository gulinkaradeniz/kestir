package com.example.kestir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class admin_anasayfa extends AppCompatActivity {
    Custom_adapter custom_adapter;
    ListView listview;
    TextView textView19;
    Spinner spinner;
    String names[]={"BEKLEYEN İŞLEMLER","TAMAMLANAN İŞLEMLER","İPTAL OLAN İŞLEMLER"};
    ArrayAdapter <String> adapter1;
    veri_tabani veri_tabani;
    ArrayList<String> islem,tarih,saat,telno,ad_soyad,_id2;
    private String record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_anasayfa);

        textView19 = findViewById(R.id.textView19);
        listview = findViewById(R.id.veriler);
        spinner=(Spinner) findViewById(R.id.spinner);
        adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        final veri_tabani veri_tabani = new veri_tabani(admin_anasayfa.this);
                        final List<String> Veriler = veri_tabani.VeriListele2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        listview.setAdapter(adapter);
                        listview.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                            @Override
                            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                                if (v.getId() == R.id.veriler) ;
                                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                                menu.setHeaderTitle(listview.getItemAtPosition(info.position).toString());
                                menu.add(0, 0, 0, "İŞLEM TAMAMLANDI.");
                                menu.add(0, 1, 0, "İŞLEM İPTAL EDİLDİ.");
                            }
                        });
                        break;
                    case 1:
                        final veri_tabani veri_tabani2 = new veri_tabani(admin_anasayfa.this);
                        final List<String> Veriler2 = veri_tabani2.TamamlananVeriListele2();
                        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler2);
                        listview.setAdapter(adapter2);
                        break;
                    case 2:
                        final veri_tabani veri_tabani3 = new veri_tabani(admin_anasayfa.this);
                        final List<String> Veriler3 = veri_tabani3.İptalVeriListele2();
                        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler3);
                        listview.setAdapter(adapter3);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public boolean onContextItemSelected(MenuItem item) {
        boolean donus;
        switch (item.getItemId()) {
            case 0:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                final String secili = listview.getItemAtPosition(info.position).toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Veri");
                builder.setMessage("\"" + secili + "\" adlı veri tamamlandı mı?");
                builder.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi = secili.split("-");
                        long id = Long.parseLong(dizi[0].trim());
                        veri_tabani veri_tabani = new veri_tabani(admin_anasayfa.this);
                        veri_tabani.update1(false, id);
                        final List<String> Veriler = veri_tabani.VeriListele2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        listview.setAdapter(adapter);
                    }
                });
                builder.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi = secili.split("-");
                        long id = Long.parseLong(dizi[0].trim());
                        veri_tabani veri_tabani = new veri_tabani(admin_anasayfa.this);
                        veri_tabani.update1(true, id);
                        final List<String> Veriler = veri_tabani.VeriListele2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        listview.setAdapter(adapter);


                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                donus = true;
                break;
            case 1:
                AdapterView.AdapterContextMenuInfo info1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                final String secili1 = listview.getItemAtPosition(info1.position).toString();
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Veri");
                builder1.setMessage("\"" + secili1 + "\" adlı veriyi iptal etmek istediğinize emin misiniz?");
                builder1.setNegativeButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi = secili1.split("-");
                        long id = Long.parseLong(dizi[0].trim());
                        veri_tabani veri_tabani = new veri_tabani(admin_anasayfa.this);
                        veri_tabani.update2(false, id);
                        final List<String> Veriler = veri_tabani.VeriListele2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        listview.setAdapter(adapter);
                    }
                });
                builder1.setPositiveButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] dizi = secili1.split("-");
                        long id = Long.parseLong(dizi[0].trim());
                        veri_tabani veri_tabani = new veri_tabani(admin_anasayfa.this);
                        veri_tabani.update2(true, id);
                        final List<String> Veriler = veri_tabani.VeriListele2();
                        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(admin_anasayfa.this, android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);
                        listview.setAdapter(adapter);
                    }
                });
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
                donus = true;

                break;
            default:
                donus = false;
                break;

        }
        return donus;
    }


}
