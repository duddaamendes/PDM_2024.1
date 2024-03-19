package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

        double imc = peso/ (altura*altura);
    }
}