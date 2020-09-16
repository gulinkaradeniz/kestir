package com.example.kestir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static com.example.kestir.R.id.textView6;

public class uye_anasayfa extends AppCompatActivity {
    Button randevularim,iletisim;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uye_anasayfa);
        textView6=findViewById(R.id.textView6);
        Intent al= getIntent();
        String alinan=al.getStringExtra("telno");
        textView6.setText(alinan);
        randevularim=findViewById(R.id.randevularim);
        iletisim=findViewById(R.id.iletisim);
        randevularim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String veri=textView6.getText().toString();
                Intent intent=new Intent(getApplicationContext(), randevular.class);
                intent.putExtra("telno",veri);
                startActivity(intent);
            }
        });

}

   public void gonder_uye_anasayfa(View view) {
        String veri=textView6.getText().toString();
       Intent intent=new Intent(getApplicationContext(), sec.class);
       intent.putExtra("telno",veri);
       startActivity(intent);
    }

    public void gonder_iletisim(View view) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(uye_anasayfa.this);
        mBuilder.setTitle("İLETİŞİM");
        mBuilder.setMessage("0555 861 0317");
        mBuilder.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();

    }
}