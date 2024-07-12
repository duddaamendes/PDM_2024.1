package com.example.bloconotas.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {
    SQLiteDatabase database;

    public NotaDAO(Context c){
        database=c.openOrCreateDatabase("minhasnotas", Context.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, txt TEXT);");
    }

    public void inserir(Nota nota){
        ContentValues cv = new ContentValues();
        cv.put("titulo", nota.getTitulo());
        cv.put("txt", nota.getTxt());
        database.insert("notas", null, cv);
    }

    public void atualizar (Nota nota){
        ContentValues cv = new ContentValues();
        cv.put("id", nota.getId());
        cv.put("titulo", nota.getTitulo());
        cv.put("txt", nota.getTxt());
        database.update("notas", cv, "id=?", new String [] {nota.getId().toString()});
    }

    public void excluirNota (Nota nota){
        database.delete("notas", "id=?", new String [] {nota.getId().toString()});
    }

    public ArrayList<Nota> listarNotas(){
        Cursor c = database.rawQuery("SELECT * FROM notas", null);
        c.moveToFirst();
        ArrayList<Nota> notasResult = new ArrayList<>();
        while (! c.isAfterLast()){
            Nota n = new Nota(c.getInt(0), c.getString(1), c.getString(2));
            notasResult.add(n);
            c.moveToFirst();
        }
        return notasResult;
    }

    public Nota getNota(Integer id){
        Cursor c = database.rawQuery("SELECT * FROM notas WHERE id=?", new String[]{id.toString()});
        c.moveToFirst();
        Nota n = new Nota(c.getInt(0), c.getString(1), c.getString(2));
        return n;
    }
}
