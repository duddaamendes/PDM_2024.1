package com.example.bloconotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bloconotas.controller.NotaController;
import com.example.bloconotas.model.Nota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    NotaController notaController;
    ArrayList<Nota> notas;
    ArrayList<String> tituloNotas;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        notaController = new NotaController(getApplicationContext());
        fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(i);
            }
        });
    }

    public void atualizarLista(){
        notas = notaController.listarNota();
        tituloNotas = getTituloNotas(notas);

        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                tituloNotas);
        listView.setAdapter(adapter);
    }

    public ArrayList<String> getTituloNotas(ArrayList<Nota> lnotas){
        ArrayList<String> result = new ArrayList<>();
        for (Nota nota: lnotas){
            result.add(nota.getTitulo());
        }
        return result;
    }
}