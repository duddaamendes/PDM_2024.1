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

    TextView txtResulIMC, txtNome, txtPeso, txtAlt;
    ImageView imgResul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        txtResulIMC = findViewById(R.id.txtIMC); // associei a varia´vel local ao view na tela
        txtNome = findViewById(R.id.lblNome);
        txtAlt = findViewById(R.id.lblAltura);
        txtPeso = findViewById(R.id.lblPeso);
        imgResul = findViewById(R.id.imgResul);

        Intent i = getIntent(); //recuperamos a intenção que veio atividade anterior
        Bundle bundle = i.getExtras(); //recuperamos os dados que acompanham
        String nomeS = bundle.getString("nome");
        String alturaS = bundle.getString("altura");
        String pesoS = bundle.getString("peso");

        txtNome.setText(nomeS);
        txtPeso.setText(pesoS);
        txtAlt.setText(alturaS);

        Double altura = Double.parseDouble(alturaS);
        Double peso = Double


        //Integer imc = Integer.parseInt(s);

        //Log.d("Valor do IMC:", bundle.getString("valorIMC"));

        if (imc<16){
            imgResul.setImageResource(R.drawable.abaixopeso);
        }
        txtResulIMC.setText(s);
    }
}