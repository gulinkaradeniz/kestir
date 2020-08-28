package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void gonder5(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity6.class);
        startActivity(intent);
    }

    public void gonder7(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}