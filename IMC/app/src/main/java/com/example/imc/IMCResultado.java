package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IMCResultado extends AppCompatActivity {

    TextView txtResulIMC;
    ImageView imgResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        txtResulIMC = findViewById(R.id.txtResuIMC); // associei a varia´vel local ao view na tela
        imgResul = findViewById(R.id.imgResul);


        Intent i = getIntent(); //recuperamos a intenção que veio atividade anterior
        Bundle bundle = i.getExtras(); //recuperamos os dados que acompanham
        String s = bundle.getString("valorimc");
        Integer imc = Integer.parseInt(s);
        //Log.d("Valor do IMC:", bundle.getString("valorIMC"));

        if (imc<16){
            imgResul.setImageResource(R.drawable.abaixopeso);
        }
        txtResulIMC.setText(s);
    }
}