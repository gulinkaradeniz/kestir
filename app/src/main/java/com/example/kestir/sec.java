package com.example.kestir;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.strictmode.CleartextNetworkViolation;
import android.view.ActionProvider;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;


public class sec extends AppCompatActivity {
    Button buttonislemler,selectDate,buttonsaat,okey,okey2;
    ListView liste;
    TextView textView4,textView8,textView9;
    TextView date;
    TextView tvsaat;
    TextView textView5;
    DatePickerDialog datePickerDialog;
    int year,month,dayOfMonth;
    Calendar calendar;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> islemItems= new ArrayList<>();
    private veri_tabani db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);
        textView9=findViewById(R.id.textView9);
        Intent al= getIntent();
        String alinan=al.getStringExtra("telno");
        textView9.setText(alinan);
        db = new veri_tabani(getApplicationContext());

        textView4=findViewById(R.id.textView4);
        buttonislemler=findViewById(R.id.buttonislemler);

        listItems=getResources().getStringArray(R.array.islemler);
        checkedItems=new boolean[listItems.length];
        buttonislemler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(sec.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                            if(isChecked){
                                if(! islemItems.contains(position)){
                                    islemItems.add(position);
                                }
                            }
                            else if(islemItems.contains(position)){
                                islemItems.remove(position);
                            }
                        }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item="";
                        for(int i=0;i< islemItems.size();i++){
                            item=item + listItems[islemItems.get(i)];
                            if(i !=islemItems.size()-1){
                                item=item+"-";
                            }
                        }
                        textView4.setText(item);
                        /*Intent intent=new Intent(getApplicationContext(), tarih_secimi.class);
                        startActivity(intent);
                        String islem=textView4.getText().toString();
                        intent.putExtra("islem_bilgisi",islem);*/

                    }
                });
                /*mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });*/
                mBuilder.setNeutralButton(R.string.clear_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for(int i=0;i<checkedItems.length;i++){
                            checkedItems[i]=false;
                            islemItems.clear();
                            textView4.setText("");
                        }
                    }
                });
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });
        textView8=findViewById(R.id.textView8);
        date = findViewById(R.id.tvSelectedDate);
        selectDate=findViewById(R.id.btnDate);
        liste=findViewById(R.id.liste);
        final String[] listItemssaat2 = getResources().getStringArray(R.array.saatler);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar=Calendar.getInstance();
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);


                datePickerDialog =new DatePickerDialog(sec.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day+"/"+(month+1)+"/"+year);
                                String tarih=date.getText().toString();
                                veri_tabani db = new veri_tabani(getApplicationContext());
                                boolean TarihKontrol = db.TarihKontrol(tarih);
                                if(TarihKontrol){
                                    veri_tabani veri_tabani=new veri_tabani(sec.this);
                                    List<String> Veriler=veri_tabani.VeriListele3(tarih);
                                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(sec.this,android.R.layout.simple_list_item_1,android.R.id.text1,Veriler);
                                    liste.setAdapter(adapter);
                                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(sec.this);
                                    mBuilder.setTitle("DOLU SAATLER");
                                    mBuilder.setSingleChoiceItems(adapter,-1,new DialogInterface.OnClickListener(){
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            listItemssaat2[i].equals(View.INVISIBLE);
                                            dialogInterface.dismiss();

                                        }
                                    });
                                    AlertDialog mDialog = mBuilder.create();
                                    mDialog.show();

                                }

                                //date.setText(day+"/"+(month+1)+"/"+year);
                            }
                        },year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });
        final String[] listItemssaat = getResources().getStringArray(R.array.saatler);
        buttonsaat=findViewById(R.id.buttonsaat);
        tvsaat=findViewById(R.id.tvsaat);
        buttonsaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(sec.this);
                mBuilder.setTitle("SAATLER");
                mBuilder.setSingleChoiceItems(listItemssaat, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvsaat.setText(listItemssaat[i]);
                        dialogInterface.dismiss();

                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }
        });
        textView8=findViewById(R.id.textView8);
        liste=findViewById(R.id.liste);
        okey=findViewById(R.id.okey);
        okey2=findViewById(R.id.okey2);

        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView5=findViewById(R.id.textView5);
                Intent al= getIntent();
                String alinan=al.getStringExtra("telno");
                textView5.setText(alinan);
                String islem=textView4.getText().toString();
                String saat=tvsaat.getText().toString();
                String tarih=date.getText().toString();
                String telno=textView5.getText().toString();
                if(islem.equals("")||saat.equals("")||tarih.equals("")){
                    Toast.makeText(sec.this, "BOŞ ALAN BIRAKMAYINIZ", Toast.LENGTH_SHORT).show();
                }else{
                    veri_tabani db = new veri_tabani(getApplicationContext());
                    boolean TarihSaatKontrol = db.TarihSaatKontrol(tarih,saat);
                    if (TarihSaatKontrol) {
                        Toast.makeText(sec.this, "BAŞKA BİR SAATE RANDEVU ALINIZ", Toast.LENGTH_SHORT).show();
                        tvsaat.setText("");
                    }else {
                        veri_tabani db2=new veri_tabani(sec.this);
                        long id2=db2.Ekle(islem,saat,tarih,telno);
                        String veri=textView9.getText().toString();
                        Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
                        intent.putExtra("telno",veri);
                        startActivity(intent);
                    }
                }

            }
        });

        okey2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), uye_anasayfa.class);
                startActivity(intent);
            }
        });
    }

}