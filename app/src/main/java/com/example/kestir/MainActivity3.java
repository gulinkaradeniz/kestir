package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void gonder6(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(intent);
    }


    public void gonder8(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity7.class);
        startActivity(intent);
    }
}