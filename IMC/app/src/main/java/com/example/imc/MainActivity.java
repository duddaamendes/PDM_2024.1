package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText txtAltura, txtPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
    }

    public void calcularIMC(View view){
        double altura = Double.parseDouble(txtAltura.getText().toString());
        double peso = Double.parseDouble(txtPeso.getText().toString());

        DecimalFormat df = new DecimalFormat("##.##");

        double imc = peso/ (altura*altura);
        String resp = df.format(imc);

        Log.d("i", resp);
        Toast.makeText(this, resp,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), IMCResultado.class);
        Bundle b = new Bundle();
        b.putString("valorimc", resp);
        intent.putExtras(b);
        startActivity(intent);

    }
}