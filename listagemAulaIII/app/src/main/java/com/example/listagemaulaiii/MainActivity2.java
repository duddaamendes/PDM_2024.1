package com.example.listagemaulaiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent i = getIntent();
        String planet = i.getStringExtra("planet");

        TextView tv = findViewById(R.id.textView2);
        tv.setText(planet);
    }
}