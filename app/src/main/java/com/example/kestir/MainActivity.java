package com.example.kestir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gonder(View view) {
            Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent);

    }

    public void gonder3(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(intent);
    }

    public void gonder5(View view) {
        Intent intent=new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(intent);
    }

    public void gonder9(View view) {
    }
}