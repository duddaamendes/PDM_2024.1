package com.example.bancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;

    EditText ed;

    ListView listView;

    Button btnSalvar;

    ArrayAdapter<String> adapter;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.txtAdicionar);
        listView = findViewById(R.id.listView);
        btnSalvar = findViewById(R.id.btnAdicionar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ed.getText().toString();
                inserirNota(s);
                carregarListaNotas();
            }
        });
        configDatabase();
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarListaNotas();
    }

    public void configDatabase(){
        sqLiteDatabase = openOrCreateDatabase("notas", MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, txt TEXT);");
    }

    @SuppressLint("Range")
    public ArrayList<Nota> recuperarNotas(){
        ArrayList<Nota> notas = new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM notas", null);
        c.moveToFirst();
        int id;
        String txt;

        while (!c.isAfterLast()){
            id = c.getInt(c.getColumnIndex("id"));
            txt = c.getString(c.getColumnIndex("txt"));

            Nota nota = new Nota(id, txt);
            notas.add(nota);
            c.moveToNext();
        }
        return notas;
    }

    public ArrayList<String> notastotxt(ArrayList<Nota> notas){
        ArrayList<String> notastxt = new ArrayList<>();
        for(Nota nota:notas){
            notastxt.add(nota.nota);
        }
        return notastxt;
    }

    public void carregarListaNotas(){
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notastotxt(recuperarNotas())
        );
        listView.setAdapter(adapter);
    }

    public void inserirNota(String txtNota){
        ContentValues cv = new ContentValues();
        cv.put("txt", txtNota);
        sqLiteDatabase.insert("notas", null, cv);
    }

}