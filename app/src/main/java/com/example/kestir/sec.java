package com.example.kestir;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import static com.example.kestir.veri_tabani2.ISLEM;
import static com.example.kestir.veri_tabani2.SAAT;
import static com.example.kestir.veri_tabani2.TARIH;

public class sec extends AppCompatActivity {
    Button buttonislemler,selectDate,buttonsaat,okey,okey2;
    TextView textView4,date,tvsaat,textView5;
    DatePickerDialog datePickerDialog;
    int year,month,dayOfMonth;
    Calendar calendar;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> islemItems= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);

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
        date = findViewById(R.id.tvSelectedDate);
        selectDate=findViewById(R.id.btnDate);

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
                            }
                        },year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
        final String[] listItemssaat = getResources().getStringArray(R.array.saatler);
        buttonsaat=findViewById(R.id.buttonsaat);
        tvsaat=findViewById(R.id.tvsaat);
        buttonsaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                veri_tabani2 db2= new veri_tabani2(getApplicationContext());
                long id2=db2.Ekle(islem,saat,tarih,telno);
                Intent intent=new Intent(getApplicationContext(), randevu_basarili.class);
                startActivity(intent);


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