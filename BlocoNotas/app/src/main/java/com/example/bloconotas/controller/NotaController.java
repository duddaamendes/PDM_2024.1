package com.example.bloconotas.controller;

import android.content.Context;

import com.example.bloconotas.model.Nota;
import com.example.bloconotas.model.NotaDAO;

import java.util.ArrayList;

public class NotaController {
    NotaDAO dao;
    public NotaController(Context c){
        dao = new NotaDAO(c);
    }

    public void cadastrarNota(Nota nota){
        if (nota.getTitulo().length()>3){
            dao.inserir(nota);
        }
    }

    public void editarNota(Nota nota){
        if (nota.getTitulo().length()>3){
            dao.atualizar(nota);
        }
    }

    public void excluirNota(Nota nota){
        dao.excluirNota(nota);
    }

    public ArrayList<Nota> listarNota(){
        return dao.listarNotas();
    }

    public Nota getNota(int id){
        return dao.getNota(id);
    }
}
