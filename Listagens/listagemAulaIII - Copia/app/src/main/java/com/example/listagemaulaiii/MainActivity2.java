package com.example.listagemaulaiii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent i = getIntent();
        String planet = i.getStringExtra("planet");
        String info = i.getStringExtra("Infos");

        TextView tv = findViewById(R.id.txtNome);
        tv.setText(planet);

        TextView tvInfo = findViewById(R.id.txtInfo);
        tvInfo.setText(info);
    }
}