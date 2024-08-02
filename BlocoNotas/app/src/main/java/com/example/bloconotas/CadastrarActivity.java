package com.example.bloconotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.bloconotas.controller.NotaController;
import com.example.bloconotas.model.Nota;

public class CadastrarActivity extends AppCompatActivity {

    Button btnSalvar, btnCancelar;
    EditText edTitulo, edTexto;
    NotaController notaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        btnCancelar = findViewById((R.id.btnCancelar));
        btnSalvar=findViewById((R.id.btnSalvar));
        edTexto = findViewById(R.id.edTexto);
        edTitulo=findViewById(R.id.edTitulo);

        notaController = new NotaController(getApplicationContext());
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nota nota = new Nota(edTitulo.getText().toString(), edTexto.getText().toString());
                notaController.cadastrarNota(nota);
            }
        });
    }
}